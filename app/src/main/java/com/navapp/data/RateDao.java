package com.navapp.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RateDao {
    @Query("SELECT * FROM rate")
    LiveData<List<Rate>> getAll();
    @Query("SELECT * FROM rate WHERE rate.id = :id")
    Rate getById(long id);

    @Insert
    void insert(Rate... rate);
    @Update
    void update(Rate... rate);
    @Delete
    void delete(Rate... rate);
}
