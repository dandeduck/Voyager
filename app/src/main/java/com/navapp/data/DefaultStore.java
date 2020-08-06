package com.navapp.data;

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
}
