package com.example.myawesomeapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.R;
import com.example.myawesomeapp.User;
import com.example.myawesomeapp.databinding.ActivityShowMsgBinding;

public class ShowMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowMsgBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_msg);
        binding.setMessage(new Message(
                "Salut mon pote !",
                new User("adrien@ynov.com", "Gradrien"),
                "Aujourd'hui"));
    }
}