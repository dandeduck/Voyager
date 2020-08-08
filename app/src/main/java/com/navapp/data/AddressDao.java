package com.navapp.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface AddressDao {
    @Query("SELECT * FROM addresses")
    List<Address> getAll();

    @Insert
    void insert(Address... addresses);
    @Update
    void update(Address... addresses);
    @Delete
    void delete(Address... addresses);
}
