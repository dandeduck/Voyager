package com.navapp.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {
        RateModel.class, DefaultStoreModel.class, AddressModel.class,
        DestinationModel.class, RouteModel.class, EndPointModel.class},
        version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract RateDao rateDao();
    public abstract DefaultStoreDao defaultStoreDao();
    public abstract AddressDao addressDao();
    public abstract DestinationDao destinationDao();
    public abstract RouteDao routeDao();
    public abstract EndPointDao endPointDao();

    private static AppDatabase sInstance;
    public static AppDatabase getDatabase(Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = createInstance(context);
                }
            }
        }

        return sInstance;
    }

    private static AppDatabase createInstance(Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "database")
                .build();
    }
}
