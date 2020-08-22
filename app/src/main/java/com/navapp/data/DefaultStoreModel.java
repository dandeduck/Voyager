package com.navapp.data;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "defaults",
        foreignKeys = {
                @ForeignKey(entity = RateModel.class,
                        parentColumns = "id",
                        childColumns = "rate_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = EndPointModel.class,
                        parentColumns = "id",
                        childColumns = "endpoint_id",
                        onDelete = ForeignKey.CASCADE)
        },
        indices = {
                @Index("rate_id"),
                @Index("endpoint_id")
        }
)
public class DefaultStoreModel {

    @PrimaryKey
    @ColumnInfo(name = "table_type")
    private DefaultStoreTable table;

    // RateModel
    @ColumnInfo(name = "rate_id")
    private Long rateId;
    // EndPointModel
    @ColumnInfo(name = "endpoint_id")
    private Long endPointId;

    public DefaultStoreModel(DefaultStoreTable table, Long rateId, Long endPointId) {
        this.table = table;
        this.rateId = rateId;
        this.endPointId = endPointId;
    }

    @Ignore
    public DefaultStoreModel(DefaultStoreTable table, long rowId) {
        this(table, null, null);
        setRowId(rowId);
    }

    public DefaultStoreTable getTable() {
        return table;
    }
    public void setTable(DefaultStoreTable table) {
        this.table = table;
    }

    public Long getRateId() {
        return rateId;
    }
    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getEndPointId() {
        return endPointId;
    }
    public void setEndPointId(Long endPointId) {
        this.endPointId = endPointId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultStoreModel that = (DefaultStoreModel) o;
        return table == that.table &&
                Objects.equals(rateId, that.rateId) &&
                Objects.equals(endPointId, that.endPointId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, rateId, endPointId);
    }

    public long getRowId() {
        return table.getFromModel(this);
    }
    public void setRowId(long rowId) {
        table.setInModel(this, rowId);
    }
}
