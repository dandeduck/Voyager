package com.navapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DefaultStoreDao {
    @Query("SELECT * FROM defaults WHERE `table_type` = :table")
    DefaultStoreModel getDefaultByTable(DefaultStoreTable table);

    @Insert
    void insert(DefaultStoreModel store);
    @Update
    void update(DefaultStoreModel store);
    @Delete
    void delete(DefaultStoreModel store);
}
