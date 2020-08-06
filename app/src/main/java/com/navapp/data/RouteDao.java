package com.navapp.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface RouteDao {
    @Query("SELECT * FROM routes")
    List<Route> getAll();

    @Insert
    void insert(Route... routes);
    @Update
    void update(Route... routes);
    @Delete
    void delete(Route... routes);
}
