package com.example.roomynovapp.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomynovapp.bo.Place;

@Database(entities = Place.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PlaceDao placeDao();

}
