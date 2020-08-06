package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "endpoints")
public class EndPoint {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "name")
    @NonNull
    private String mName;
    @ColumnInfo(name = "address")
    @NonNull
    private String mRawAddress;

    public EndPoint(@NonNull String name, @NonNull String rawAddress) {
        mName = name;
        mRawAddress = rawAddress;
    }

    long getId() {
        return mId;
    }
    void setId(long id) {
        mId = id;
    }

    @NonNull
    public String getName() {
        return mName;
    }
    public void setName(@NonNull String name) {
        mName = name;
    }

    @NonNull
    public String getRawAddress() {
        return mRawAddress;
    }
    public void setRawAddress(@NonNull String rawAddress) {
        mRawAddress = rawAddress;
    }
}
