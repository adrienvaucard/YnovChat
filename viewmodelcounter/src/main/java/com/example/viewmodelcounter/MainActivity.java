package com.example.viewmodelcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ViewModelMainActivity va;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        va = new ViewModelProvider(this).get(ViewModelMainActivity.class);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        TextView tv = findViewById(R.id.textViewCounter);

        tv.setText(String.valueOf(va.getCounter()));
        Observer<Integer> counterObserver = integer -> {
          tv.setText(String.valueOf(integer));
        };
        va.getCounter().observe(this, counterObserver);
        fab.setOnClickListener((view) -> va.incrementCounter());
    }
}