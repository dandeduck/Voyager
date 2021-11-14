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

public class DestinationModelTest {

    private AppDatabase database;
    private DestinationDao dao;

    private FakeModels fakeModels;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        dao = database.destinationDao();

        fakeModels = new FakeModels(database);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertAndRead_normal_keepsData() throws Exception {
        final DestinationModel INSERT_MODEL = new DestinationModel(
                "000122313",
                "SET FIREEEEEE TO THE RAIN",
                fakeModels.makeFakeAddress().getId(),
                fakeModels.makeFakeRate().getId()
        );

        long[] ids = dao.insert(INSERT_MODEL);
        // fix since the ID is auto generated in insert
        INSERT_MODEL.setId(ids[0]);

        List<DestinationModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }
}