package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "endpoints",
            foreignKeys = {
                    @ForeignKey(entity = Address.class,
                            parentColumns = "id",
                            childColumns = "address_id",
                            onDelete = ForeignKey.CASCADE)
            },
            indices = {
                @Index("address_id")
            }
)
public class EndPoint {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "address_id")
    private long addressId;

    public EndPoint(@NonNull String name, long addressId) {
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
}
