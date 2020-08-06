package com.navapp.data;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "defaults")
public class DefaultStore {

    @PrimaryKey
    @ColumnInfo(name = "table_type")
    private DefaultStoreTable mTable;
    @ColumnInfo(name = "row_id")
    private long mRowId;

    public DefaultStore(DefaultStoreTable table, long rowId) {
        mTable = table;
        mRowId = rowId;
    }

    public DefaultStoreTable getTable() {
        return mTable;
    }
    public void setTable(DefaultStoreTable table) {
        mTable = table;
    }

    public long getRowId() {
        return mRowId;
    }
    public void setRowId(long rowId) {
        mRowId = rowId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultStore that = (DefaultStore) o;
        return mRowId == that.mRowId &&
                mTable == that.mTable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTable, mRowId);
    }

    @Override
    public String toString() {
        return "DefaultStore{" +
                "mTable=" + mTable +
                ", mRowId=" + mRowId +
                '}';
    }
}
