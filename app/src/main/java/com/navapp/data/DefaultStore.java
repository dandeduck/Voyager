package com.navapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "defaults")
public class DefaultStore {

    @ColumnInfo(name = "table_type")
    private DefaultStoreTable mTable;
    @ColumnInfo(name = "row_id")
    private long mRowId;

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
