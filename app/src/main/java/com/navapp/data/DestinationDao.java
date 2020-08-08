package com.navapp.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DestinationDao {
    @Query("SELECT * FROM destinations")
    List<Destination> getAll();
    @Query("SELECT * FROM destinations WHERE destinations.route_id = :routeId")
    List<Destination> getByRouteId(long routeId);
    @Query("SELECT * FROM destinations WHERE destinations.route_id = -1")
    List<Destination> getWithoutRoute();

    @Insert
    void insert(Destination... destinations);
    @Update
    void update(Destination... destinations);
    @Delete
    void delete(Destination... destinations);
}
