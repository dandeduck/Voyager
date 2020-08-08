package com.navapp.data;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "endpoints",
            foreignKeys = {
                    @ForeignKey(entity = AddressModel.class,
                            parentColumns = "id",
                            childColumns = "address_id",
                            onDelete = ForeignKey.CASCADE)
            },
            indices = {
                @Index("address_id")
            }
)
public class EndPointModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "address_id")
    private long addressId;

    public EndPointModel(@NonNull String name, long addressId) {
        this.name = name;
        this.addressId = addressId;
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

    public long getAddressId() {
        return addressId;
    }
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndPointModel that = (EndPointModel) o;
        return id == that.id &&
                addressId == that.addressId &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, addressId);
    }
}
