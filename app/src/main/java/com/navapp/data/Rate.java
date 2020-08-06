package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rates")
public class Rate {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "name")
    @NonNull
    private String mName;
    @ColumnInfo(name = "price")
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
}
