package com.navapp.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

// TODO: ADD INDEX TO route_id
// WARNING: route_id column references a foreign key but it is not part of an index.
// This may trigger full table scans whenever parent table is modified so you are highly advised to
// create an index that covers this column.
@Entity(tableName = "addresses",
        foreignKeys = @ForeignKey(entity = Route.class,
                parentColumns = "id",
                childColumns = "route_id",
                onDelete = ForeignKey.CASCADE))
public class Address {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "address")
    @NonNull
    private String mRawAddress;

    @ColumnInfo(name = "phone")
    private String mPhoneNumber;
    @ColumnInfo(name = "comment")
    private String mComment;

    @ColumnInfo(name = "route_id")
    private long mRouteId;

    public Address(@NonNull String rawAddress, String phoneNumber, String comment) {
        mRawAddress = rawAddress;
        mPhoneNumber = phoneNumber;
        mComment = comment;

        mRouteId = -1;
    }

    @Ignore
    public Address(@NonNull String rawAddress) {
        this(rawAddress, null, null);
    }

    long getId() {
        return mId;
    }
    void setId(long id) {
        mId = id;
    }

    @NonNull
    public String getRawAddress() {
        return mRawAddress;
    }
    public void setRawAddress(@NonNull String rawAddress) {
        mRawAddress = rawAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getComment() {
        return mComment;
    }
    public void setComment(String comment) {
        mComment = comment;
    }

    long getRouteId() {
        return mRouteId;
    }
    void setRouteId(long routeId) {
        mRouteId = routeId;
    }
}
