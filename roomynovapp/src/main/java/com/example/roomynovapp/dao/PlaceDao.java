package com.example.roomynovapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomynovapp.bo.Place;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("SELECT * FROM Place")
    List<Place> getAll();

    @Insert
    void insertPlace(Place place);

    @Insert
    void insertPlaces(List<Place> places);

    @Update
    void update(Place place);

    @Delete
    void delete(Place place);
}
