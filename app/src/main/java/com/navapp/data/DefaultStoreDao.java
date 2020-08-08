package com.navapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DefaultStoreDao {
    @Query("SELECT * FROM defaults WHERE `table_type` = :table")
    DefaultStore getDefaultByTable(DefaultStoreTable table);

    @Insert
    void insert(DefaultStore store);
    @Update
    void update(DefaultStore store);
    @Delete
    void delete(DefaultStore store);
}
