package com.example.roomynovapp.bo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Place {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "maximum_capacity")
    public int maximumCapacity;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "price_per_night")
    public float pricePerNight;

    @ColumnInfo(name = "is_flat")
    public boolean isFlat;

    @ColumnInfo(name = "is_connected_to_www")
    public boolean isConnectedToWWW;

    @Ignore
    public Place(String location, float pricePerNight, int maximumCapacity, boolean isFlat, boolean isConnectedToWWW) {
        this.maximumCapacity = maximumCapacity;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.isFlat = isFlat;
        this.isConnectedToWWW = isConnectedToWWW;
    }

    public Place(int uid, String location, float pricePerNight, int maximumCapacity, boolean isFlat, boolean isConnectedToWWW) {
        this.uid = uid;
        this.maximumCapacity = maximumCapacity;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.isFlat = isFlat;
        this.isConnectedToWWW = isConnectedToWWW;
    }
}
