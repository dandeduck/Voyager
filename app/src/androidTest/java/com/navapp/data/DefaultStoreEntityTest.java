package com.navapp.data;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class DefaultStoreEntityTest {

    private DefaultStoreDao mDefaultStoreDao;
    private AppDatabase mDatabase;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        mDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        mDefaultStoreDao = mDatabase.defaultStoreDao();
    }

    @After
    public void closeDb() throws Exception {
        mDatabase.close();
    }

    @Test
    public void insertAndRead_ofSpecificTable_dataMatches() throws Exception {
        DefaultStore defaultStore = new DefaultStore();
        defaultStore.setTable(DefaultStoreTable.RATE);
        defaultStore.setRowId(1);

        mDefaultStoreDao.insert(defaultStore);

        DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
        assertThat(store, equalTo(defaultStore));
    }

    @Test
    public void read_noDataForTable_returnsNull() throws Exception {
        DefaultStore store = mDefaultStoreDao.getDefaultByTable(DefaultStoreTable.RATE);
        assertThat(store, nullValue(DefaultStore.class));
    }
}
