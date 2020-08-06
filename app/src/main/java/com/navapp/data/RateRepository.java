package com.navapp.data;

import com.navapp.util.Optional;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import androidx.lifecycle.LiveData;

public class RateRepository {

    private final AppDatabase mDatabase;
    private final RateDao mRateDao;
    private final DefaultStoreDao mDefaultStoreDao;

    private final LiveData<List<Rate>> mAllRates;

    private final ReadWriteLock mDefaultLock;

    public RateRepository(AppDatabase database) {
        mDatabase = database;
        mRateDao = database.rateDao();
        mDefaultStoreDao = database.defaultStoreDao();

        mAllRates = mRateDao.getAll();

        mDefaultLock = new ReentrantReadWriteLock();
    }

    public LiveData<List<Rate>> getAllRates() {
        return mAllRates;
    }

    public void insert(Collection<? extends Rate> rates) {
        mDatabase.executeWrite(()-> {
            mRateDao.insert(rates.toArray(new Rate[0]));
        });
    }

    public void update(Collection<? extends Rate> rates) {
        mDatabase.executeWrite(()-> {
            mRateDao.update(rates.toArray(new Rate[0]));
        });
    }

    public void delete(Collection<? extends Rate> rates) {
        mDatabase.executeWrite(()-> {
            mDefaultLock.writeLock().lock();
            try {
                DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
                for (Rate rate : rates) {
                    if (store != null && store.getRowId() == rate.getId()) {
                        mDefaultStoreDao.delete(store);
                    }
                }

                mRateDao.delete(rates.toArray(new Rate[0]));
            } finally {
                mDefaultLock.writeLock().unlock();
            }
        });
    }

    public Optional<Rate> getDefaultRate() {
        return mDatabase.executeWrite(()-> {
            mDefaultLock.readLock().lock();
            try {
                DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
                if (store == null) {
                    return Optional.empty();
                }
                Rate rate = mRateDao.getById(store.getRowId());
                return Optional.ofNullable(rate);
            } finally {
                mDefaultLock.readLock().unlock();
            }
        });
    }

    public void setDefaultRate(Rate rate) {
        mDatabase.executeWrite(()-> {
            mDefaultLock.writeLock().lock();
            try {
                DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
                if (store == null) {
                    store = new DefaultStore(DefaultStoreTable.RATE, rate.getId());
                    mDefaultStoreDao.insert(store);
                } else {
                    store.setRowId(rate.getId());
                    mDefaultStoreDao.update(store);
                }
            } finally {
                mDefaultLock.writeLock().unlock();
            }
        });
    }
}
