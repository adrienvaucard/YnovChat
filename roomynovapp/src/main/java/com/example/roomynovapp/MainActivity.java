package com.example.roomynovapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.roomynovapp.bo.Place;
import com.example.roomynovapp.dao.DbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(() -> {
            Place appartVueTourEiffel = new Place("Paris 7e", 250, 2, true, true);
            Place maisonBordDeMer = new Place("Pornic", 300, 6, false, false);
            DbHelper.getDb(this).placeDao().insertPlace(appartVueTourEiffel);
            DbHelper.getDb(this).placeDao().insertPlace(maisonBordDeMer);
        });
    }
}