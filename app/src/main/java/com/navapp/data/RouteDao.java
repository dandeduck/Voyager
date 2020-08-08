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
    List<RouteModel> getAll();

    @Insert
    long[] insert(RouteModel... routes);
    @Update
    void update(RouteModel... routes);
    @Delete
    void delete(RouteModel... routes);
}
