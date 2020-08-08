package com.navapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "destinations",
        foreignKeys = {
                @ForeignKey(entity = Route.class,
                        parentColumns = "id",
                        childColumns = "route_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Rate.class,
                        parentColumns = "id",
                        childColumns = "rate_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Address.class,
                        parentColumns = "id",
                        childColumns = "address_id",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {
                @Index("route_id"),
                @Index("rate_id"),
                @Index("address_id")
        }
)
public class Destination {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "phone")
    private String phoneNumber;
    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "address_id")
    private long addressId;
    @ColumnInfo(name = "rate_id")
    private long rateId;
    @ColumnInfo(name = "route_id")
    private long routeId;

    public Destination(String phoneNumber, String comment, long addressId, long rateId) {
        this.phoneNumber = phoneNumber;
        this.comment = comment;

        this.addressId = addressId;
        this.rateId = rateId;
        routeId = -1;
    }

    long getId() {
        return id;
    }
    void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getAddressId() {
        return addressId;
    }
    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    long getRateId() {
        return rateId;
    }
    void setRateId(long rateId) {
        this.rateId = rateId;
    }

    long getRouteId() {
        return routeId;
    }
    void setRouteId(long routeId) {
        this.routeId = routeId;
    }
}
