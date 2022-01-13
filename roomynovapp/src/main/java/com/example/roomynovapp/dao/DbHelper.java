package com.example.roomynovapp.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class DbHelper {
    public static AppDatabase getDb(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "ynovDb").build();
    }
}
