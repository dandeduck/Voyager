package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "addresses",
        foreignKeys = {
            @ForeignKey(entity = Route.class,
                parentColumns = "id",
                childColumns = "route_id",
                onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = Rate.class,
                parentColumns = "id",
                childColumns = "rate_id",
                onDelete = ForeignKey.CASCADE)
        },
        indices = {
            @Index("route_id"),
            @Index("rate_id")
        }
)
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "address")
    @NonNull
    private String rawAddress;

    @ColumnInfo(name = "phone")
    private String phoneNumber;
    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "route_id")
    private long routeId;
    @ColumnInfo(name = "rate_id")
    private long rateId;

    public Address(@NonNull String rawAddress, String phoneNumber, String comment, long rateId) {
        this.rawAddress = rawAddress;
        this.phoneNumber = phoneNumber;
        this.comment = comment;

        routeId = -1;
        this.rateId = rateId;
    }

    @Ignore
    public Address(@NonNull String rawAddress, long rateId) {
        this(rawAddress, null, null, rateId);
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

    long getRouteId() {
        return routeId;
    }
    void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    long getRateId() {
        return rateId;
    }
    void setRateId(long rateId) {
        this.rateId = rateId;
    }
}
