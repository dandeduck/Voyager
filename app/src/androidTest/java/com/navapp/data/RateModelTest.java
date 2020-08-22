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

public class RateModelTest {

    private AppDatabase database;
    private RateDao dao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        dao = database.rateDao();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertAndRead_normal_keepsData() throws Exception {
        final RateModel INSERT_MODEL = new RateModel(
                "AT THE SKYFALLLLL. WHEN IT CRUMBLES! WE WILL STAND TALL",
                20
        );

        long[] ids = dao.insert(INSERT_MODEL);
        // fix since the ID is auto generated in insert
        INSERT_MODEL.setId(ids[0]);

        List<RateModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }
}