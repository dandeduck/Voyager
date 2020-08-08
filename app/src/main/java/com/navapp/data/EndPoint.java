package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "endpoints")
public class EndPoint {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;
    @ColumnInfo(name = "address")
    @NonNull
    private String rawAddress;

    public EndPoint(@NonNull String name, @NonNull String rawAddress) {
        this.name = name;
        this.rawAddress = rawAddress;
    }

    long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getRawAddress() {
        return rawAddress;
    }
    public void setRawAddress(@NonNull String rawAddress) {
        this.rawAddress = rawAddress;
    }
}
