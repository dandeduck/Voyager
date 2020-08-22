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

public class RouteModelTest {

    private AppDatabase database;
    private RouteDao dao;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        dao = database.routeDao();
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertAndRead_normal_keepsData() throws Exception {
        final RouteModel INSERT_MODEL = new RouteModel(
                "THIS IS THE END. HOLD YOUR BREATH AND COUNT TO TEN. FEEL THE EARTH..."
        );

        long[] ids = dao.insert(INSERT_MODEL);
        // fix since the ID is auto generated in insert
        INSERT_MODEL.setId(ids[0]);

        List<RouteModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }
}