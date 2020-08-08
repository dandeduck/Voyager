package com.navapp.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface EndPointDao {
    @Query("SELECT * FROM endpoints")
    List<EndPointModel> getAll();
    @Query("SELECT * FROM endpoints WHERE endpoints.id = :id")
    EndPointModel getById(long id);

    @Insert
    void insert(EndPointModel... endPoints);
    @Update
    void update(EndPointModel... endPoints);
    @Delete
    void delete(EndPointModel... endPoints);
}
