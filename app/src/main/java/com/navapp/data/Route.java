package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "routes")
public class Route {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "name")
    @NonNull
    private String mName;

    public Route(@NonNull String name) {
        mName = name;
    }

    long getId() {
        return mId;
    }
    void setId(long id) {
        mId = id;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }
    @NonNull
    public String getName() {
        return mName;
    }
}
