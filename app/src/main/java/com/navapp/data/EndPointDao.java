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
    List<EndPoint> getAll();
    @Query("SELECT * FROM endpoints WHERE endpoints.id = :id")
    EndPoint getById(long id);

    @Insert
    void insert(EndPoint... endPoints);
    @Update
    void update(EndPoint... endPoints);
    @Delete
    void delete(EndPoint... endPoints);
}
