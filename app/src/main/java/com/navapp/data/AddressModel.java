package com.navapp.data;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses")
public class AddressModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "address")
    @NonNull
    private String rawAddress;

    @ColumnInfo(name = "longitude")
    private double longitude;
    @ColumnInfo(name = "latitude")
    private double latitude;

    public AddressModel(@NonNull String rawAddress, double longitude, double latitude) {
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

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressModel that = (AddressModel) o;
        return id == that.id &&
                longitude == that.longitude &&
                latitude == that.latitude &&
                rawAddress.equals(that.rawAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rawAddress, longitude, latitude);
    }
}
