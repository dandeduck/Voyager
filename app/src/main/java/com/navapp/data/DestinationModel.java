package com.navapp.data;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "destinations",
        foreignKeys = {
                @ForeignKey(entity = RouteModel.class,
                        parentColumns = "id",
                        childColumns = "route_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = RateModel.class,
                        parentColumns = "id",
                        childColumns = "rate_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = AddressModel.class,
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
public class DestinationModel {
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
    private Long routeId;

    public DestinationModel(String phoneNumber, String comment, long addressId, long rateId) {
        this.phoneNumber = phoneNumber;
        this.comment = comment;

        this.addressId = addressId;
        this.rateId = rateId;
        routeId = null;
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

    Long getRouteId() {
        return routeId;
    }
    void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestinationModel that = (DestinationModel) o;
        return id == that.id &&
                addressId == that.addressId &&
                rateId == that.rateId &&
                Objects.equals(routeId, that.routeId) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, comment, addressId, rateId, routeId);
    }
}
