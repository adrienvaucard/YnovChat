package com.example.myawesomeapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myawesomeapp.R;
import com.example.myawesomeapp.databinding.ActivityLoginBinding;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText editTextUsername, editTextPassword;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sp = getSharedPreferences(getString(R.string.spConfigName), MODE_PRIVATE);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        if(sp.getString(getString(R.string.keyJwt), "Hello") != "Hello") {
            onUserLoggedIn();
        }

        binding.buttonLogin.setOnClickListener(view -> {
            String identifier = binding.editTextUsername.getText().toString();
            String password = binding.editTextPassword.getText().toString();

            JSONObject json = new JSONObject();

            try {
                json.put("identifier", identifier);
                json.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://flutter-learning.mooo.com/auth/local")
                    .post(RequestBody.create(
                            json.toString(),
                            MediaType.get("application/json")
                    ))
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.e(TAG, "onFailure: " + "inscription" + e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    String body = response.body().string();
                    Log.i(TAG, "onResponse: " + body);

                    if (response.code() == 200) {
                        try {
                            JSONObject responseBody = new JSONObject((body));

                            String token = responseBody.getString("jwt");

                            sp.edit().putString(getString(R.string.keyJwt), token).commit();

                            onUserLoggedIn();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        });
    }

    public void onRegisterClick(View baseView) throws JSONException {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    private void onUserLoggedIn() {
        // TODO Get User on Home page
        // TODO Check response code
        Intent intentToMain = new Intent(this, MainActivity.class);
        startActivity(intentToMain);
    }
}