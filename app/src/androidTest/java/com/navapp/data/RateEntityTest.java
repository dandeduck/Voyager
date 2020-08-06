package com.navapp.data;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class RateEntityTest {

    private RateDao mRateDao;
    private AppDatabase mDatabase;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        mDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        mRateDao = mDatabase.rateDao();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void insertAndRead_ofNewData_findsAll() throws Exception {
        final Rate[] RATES = {
                new Rate("rate1 name", 100),
                new Rate("whaaaaaaat", 10),
                new Rate("ratatouille", 120)
        };

        mRateDao.insert(RATES);

        List<Rate> allRates = mRateDao.getAll().getValue();
        assertThat(allRates, containsInAnyOrder(RATES));
    }
}
