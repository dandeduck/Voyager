package com.navapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class DefaultStoreModelTest {

    private AppDatabase database;
    private DefaultStoreDao dao;

    private FakeModels fakeModels;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .build();
        dao = database.defaultStoreDao();

        fakeModels = new FakeModels(database);
    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    @Test
    public void insertAndRead_normal_keepsData() throws Exception {
        final DefaultStoreModel INSERT_MODEL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );

        dao.insert(INSERT_MODEL);

        List<DefaultStoreModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }

    @Test(expected = SQLiteConstraintException.class)
    public void insert_alreadyHasDefaultOfSameType_throwsSQLiteConstraintException() throws Exception {
        final DefaultStoreModel INSERT_ORIGINAL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );
        dao.insert(INSERT_ORIGINAL);

        dao.insert(new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        ));
    }

    @Test
    public void update_alreadyHasDefaultOfSameType_updatesRow() throws Exception {
        final DefaultStoreModel INSERT_ORIGINAL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );
        dao.insert(INSERT_ORIGINAL);

        final DefaultStoreModel UPDATED_MODEL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );
        dao.update(UPDATED_MODEL);

        DefaultStoreModel storedModel = dao.getDefaultByTable(DefaultStoreTable.RATE);
        assertThat(storedModel, equalTo(UPDATED_MODEL));
    }

    @Test
    public void deleteOfTargetDefaultModel_hasDefaultRow_deletesDefault() throws Exception {
        final RateModel TARGET_MODEL = fakeModels.makeFakeRate();
        final DefaultStoreModel INSERT_ORIGINAL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                TARGET_MODEL.getId()
        );
        dao.insert(INSERT_ORIGINAL);

        database.rateDao().delete(TARGET_MODEL);

        DefaultStoreModel storedModel = dao.getDefaultByTable(DefaultStoreTable.RATE);
        assertThat(storedModel, nullValue(DefaultStoreModel.class));
    }

    @Test
    public void upsertAndRead_doesNotHaveRow_finishesSuccessfully() throws Exception {
        final DefaultStoreModel INSERT_MODEL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );

        dao.upsert(INSERT_MODEL);

        List<DefaultStoreModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(INSERT_MODEL));
    }

    @Test
    public void upsertAndRead_hasRow_finishesSuccessfully() throws Exception {
        final DefaultStoreModel INSERT_MODEL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );
        dao.upsert(INSERT_MODEL);

        final DefaultStoreModel UPDATE_MODEL = new DefaultStoreModel(
                DefaultStoreTable.RATE,
                fakeModels.makeFakeRate().getId()
        );
        dao.upsert(UPDATE_MODEL);

        List<DefaultStoreModel> models = dao.getAll();
        assertThat(models, hasSize(1));
        assertThat(models.get(0), equalTo(UPDATE_MODEL));
    }
}