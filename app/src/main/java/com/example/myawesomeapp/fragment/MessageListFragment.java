package com.example.myawesomeapp.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.R;
import com.example.myawesomeapp.adapter.MessageAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MessageListFragment extends Fragment {
    OkHttpClient client;
    private static final String TAG = "MessageListFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fetchMessages();

        super.onViewCreated(view, savedInstanceState);
    }

    private void fetchMessages() {
        SharedPreferences sp = getContext().getSharedPreferences(getString(R.string.spConfigName), MODE_PRIVATE);
        String token = sp.getString(getString(R.string.keyJwt), "Hello");

        // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NzAyLCJpYXQiOjE2Mzk3NDY4NTIsImV4cCI6MTY0MjMzODg1Mn0.pZTreSlPiDrA7VEfYJSepW8vZDak65aS_knUEbrh_ss";
        Request requestMsg = new Request.Builder()
                .url("https://flutter-learning.mooo.com/messages")
                .header("Authorization", "Bearer " + token)
                .build();
        client.newCall(requestMsg).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + "Getmsg - " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.code() == 200) {
                    ArrayList<Message> allMsgs = new Gson().fromJson(
                            response.body().string(),
                            new TypeToken<ArrayList<Message>>(){}.getType()
                    );

                    getActivity().runOnUiThread(() -> {
                        showMessages(allMsgs);
                    });
                } else {
                    Log.e(TAG, "onResponse: " + "Authentification incorrecte" );
                }
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
    }

    private void showMessages(ArrayList<Message> msgs) {
        RecyclerView rv = getView().findViewById(R.id.recylerView);
        MessageAdapter adapter = new MessageAdapter(msgs);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
    }
}