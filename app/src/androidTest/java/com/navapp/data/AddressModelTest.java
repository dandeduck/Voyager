package com.navapp.data;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class AddressModelTest {

    private AppDatabase database;
    private AddressDao dao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        dao = database.addressDao();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertAndRead_normal_keepsData() throws Exception {
        final AddressModel INSERT_MODEL = new AddressModel(
                "addressData",
                1203,
                231
        );

        long[] ids = dao.insert(INSERT_MODEL);
        // fix since the ID is auto generated in insert
        INSERT_MODEL.setId(ids[0]);

        List<AddressModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }
}