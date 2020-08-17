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
    List<DestinationModel> getAll();
    @Query("SELECT * FROM destinations WHERE destinations.route_id = :routeId")
    List<DestinationModel> getByRouteId(long routeId);

    @Insert
    long[] insert(DestinationModel... destinations);
    @Update
    void update(DestinationModel... destinations);
    @Delete
    void delete(DestinationModel... destinations);
}
