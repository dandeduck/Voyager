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
    List<AddressModel> getAll();

    @Insert
    long[] insert(AddressModel... addresses);
    @Update
    void update(AddressModel... addresses);
    @Delete
    void delete(AddressModel... addresses);
}
