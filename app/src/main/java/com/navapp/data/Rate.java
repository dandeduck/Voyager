package com.navapp.data;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "rates")
public class Rate {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private long mId;

    @ColumnInfo(name = "name")
    @NonNull
    private String mName;
    @ColumnInfo(name = "price")
    @NonNull
    private double mPrice;

    public Rate(@NonNull String name, double price) {
        mName = name;
        mPrice = price;
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

    public double getPrice() {
        return mPrice;
    }
    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return
                Double.compare(rate.mPrice, mPrice) == 0 &&
                mName.equals(rate.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mPrice);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                '}';
    }
}
