package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses")
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "address")
    @NonNull
    private String rawAddress;

    @ColumnInfo(name = "longitude")
    private long longitude;
    @ColumnInfo(name = "latitude")
    private long latitude;

    public Address(@NonNull String rawAddress, long longitude, long latitude) {
        this.rawAddress = rawAddress;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getRawAddress() {
        return rawAddress;
    }
    public void setRawAddress(@NonNull String rawAddress) {
        this.rawAddress = rawAddress;
    }

    public long getLongitude() {
        return longitude;
    }
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
