package com.navapp.data;

import java.util.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "defaults")
public class DefaultStoreModel {

    @PrimaryKey
    @ColumnInfo(name = "table_type")
    private DefaultStoreTable table;
    @ColumnInfo(name = "row_id")
    private long rowId;

    public DefaultStoreModel(DefaultStoreTable table, long rowId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultStoreModel that = (DefaultStoreModel) o;
        return rowId == that.rowId &&
                table == that.table;
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, rowId);
    }
}
