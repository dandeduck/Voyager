package com.navapp.data;

import java.util.Collection;
import java.util.List;

import androidx.lifecycle.LiveData;

public class RateRepository {

    private final AppDatabase mDatabase;
    private final RateDao mRateDao;

    private final LiveData<List<Rate>> mAllRates;

    public RateRepository(AppDatabase database, RateDao rateDao) {
        mDatabase = database;
        mRateDao = rateDao;

        mAllRates = mRateDao.getAll();
    }

    public LiveData<List<Rate>> getAllRates() {
        return mAllRates;
    }

    public void insert(Collection<? extends Rate> rates) {
        mRateDao.insert(rates.toArray(new Rate[0]));
    }

    public void setDefaultRate(Rate rate) {

    }
}
