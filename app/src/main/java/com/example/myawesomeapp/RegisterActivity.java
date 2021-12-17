package com.example.myawesomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button loginBtn = (Button)findViewById(R.id.buttonLogin);
        Button registerBtn = (Button)findViewById(R.id.buttonRegister);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View baseView) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View baseView) {
                // Todo send register request to server
                String email = editTextEmail.getText().toString();
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString();

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://flutter-learning.mooo.com/auh/local/register")
                        .post(RequestBody.create(
                                
                        ))
                        .build();


                Snackbar snackbar1 = Snackbar.make(baseView, "Registered !", Snackbar.LENGTH_SHORT);
                snackbar1.show();
            }
        });
    }
}