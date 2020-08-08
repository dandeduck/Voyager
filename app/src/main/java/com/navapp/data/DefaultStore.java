package com.navapp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "defaults")
public class DefaultStore {

    @PrimaryKey
    @ColumnInfo(name = "table_type")
    private DefaultStoreTable table;
    @ColumnInfo(name = "row_id")
    private long rowId;

    public DefaultStore(DefaultStoreTable table, long rowId) {
        this.table = table;
        this.rowId = rowId;
    }

    public DefaultStoreTable getTable() {
        return table;
    }
    public void setTable(DefaultStoreTable table) {
        this.table = table;
    }

    public long getRowId() {
        return rowId;
    }
    public void setRowId(long rowId) {
        this.rowId = rowId;
    }
}
