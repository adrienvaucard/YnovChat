package com.example.myawesomeapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myawesomeapp.R;
import com.example.myawesomeapp.fragment.MessageListFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_msg, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_refresh) {
            Toast.makeText(this, "Chargement des nouveaux messages", Toast.LENGTH_SHORT).show();
            MessageListFragment mlf = (MessageListFragment) getSupportFragmentManager().findFragmentById(R.id.messageListFragment);

            if (mlf != null) {
                mlf.fetchMessages();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}