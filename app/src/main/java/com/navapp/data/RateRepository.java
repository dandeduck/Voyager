package com.navapp.data;

import com.navapp.util.Optional;

import java.util.Collection;
import java.util.List;

import androidx.lifecycle.LiveData;

public class RateRepository {

    private final RateDao mRateDao;
    private final DefaultStoreDao mDefaultStoreDao;

    private final LiveData<List<Rate>> mAllRates;

    private final Object mDefaultLock = new Object();

    public RateRepository(AppDatabase database) {
        mRateDao = database.rateDao();
        mDefaultStoreDao = database.defaultStoreDao();

        mAllRates = mRateDao.getAll();
    }

    public LiveData<List<Rate>> getAllRates() {
        return mAllRates;
    }

    public void insert(Collection<? extends Rate> rates) {
        mRateDao.insert(rates.toArray(new Rate[0]));
    }

    public void update(Collection<? extends Rate> rates) {
        mRateDao.update(rates.toArray(new Rate[0]));
    }

    public void delete(Collection<? extends Rate> rates) {
        synchronized (mDefaultLock) {
            DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
            for (Rate rate : rates) {
                if (store != null && store.getRowId() == rate.getId()) {
                    store.setRowId(-1);
                    mDefaultStoreDao.update(store);
                }
            }

            mRateDao.delete(rates.toArray(new Rate[0]));
        }
    }

    public Optional<Rate> getDefaultRate() {
        DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
        if (store == null) {
            return Optional.empty();
        }
        Rate rate = mRateDao.getById(store.getRowId());
        return Optional.ofNullable(rate);
    }

    public void setDefaultRate(Rate rate) {
        synchronized (mDefaultLock) {
            DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
            store.setRowId(rate.getId());
            mDefaultStoreDao.update(store);
        }
    }
}
