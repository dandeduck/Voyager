package com.navapp.data;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rates")
public class RateModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;
    @ColumnInfo(name = "price")
    private double price;

    public RateModel(@NonNull String name, double price) {
        this.name = name;
        this.price = price;
    }

    long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
    @NonNull
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateModel rateModel = (RateModel) o;
        return id == rateModel.id &&
                Double.compare(rateModel.price, price) == 0 &&
                name.equals(rateModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
