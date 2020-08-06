package com.navapp.data;

import android.content.Context;

import com.navapp.util.function.Supplier;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Rate.class, DefaultStore.class, Address.class, Route.class},
        version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract RateDao rateDao();
    public abstract DefaultStoreDao defaultStoreDao();
    public abstract AddressDao addressDao();
    public abstract RouteDao routeDao();

    public void executeWrite(Runnable action) {
        action.run();
    }

    public <T> T executeWrite(Supplier<T> action) {
        return action.get();
    }

    private static AppDatabase sInstance;
    public static AppDatabase getDatabase(Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "database")
                            .build();
                }
            }
        }

        return sInstance;
    }
}
