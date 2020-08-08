package com.navapp.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RateDao {
    @Query("SELECT * FROM rates")
    List<RateModel> getAll();
    @Query("SELECT * FROM rates WHERE rates.id = :id")
    RateModel getById(long id);

    @Insert
    void insert(RateModel... rate);
    @Update
    void update(RateModel... rate);
    @Delete
    void delete(RateModel... rate);
}
