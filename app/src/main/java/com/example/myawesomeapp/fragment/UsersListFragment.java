package com.example.myawesomeapp.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.R;
import com.example.myawesomeapp.User;
import com.example.myawesomeapp.adapter.UserAdapter;
import com.example.myawesomeapp.viewmodel.ListUserFragmentViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class UsersListFragment extends Fragment {
    ListUserFragmentViewModel vm;
    private RecyclerView rv;
    private UserAdapter userAdapter;
    OkHttpClient client;
    private SharedPreferences sp;
    private String token;
    private static final String TAG = "UsereListFragment";


    public UsersListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();
        sp = getContext().getSharedPreferences(getString(R.string.spConfigName), MODE_PRIVATE);
        token = sp.getString(getString(R.string.keyJwt), "Hello");

        vm = new ViewModelProvider(this).get(ListUserFragmentViewModel.class);
        if (vm.getUserArrayList().getValue().isEmpty()) {
            fetchUsers();
        } else {
            userAdapter.setArrayListUsers(vm.getUserArrayList().getValue());
        }
    }

    private void fetchUsers() {
        Request requestMsg = new Request.Builder()
                .url("https://flutter-learning.mooo.com/users")
                .header("Authorization", "Bearer " + token)
                .build();
        client.newCall(requestMsg).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, "onFailure: " + "getUsers - " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.code() == 200) {
                    ArrayList<User> alUsers = new Gson().fromJson(
                            response.body().string(),
                            new TypeToken<ArrayList<User>>(){}.getType()
                    );
                    vm.getUserArrayList().postValue(alUsers);
                } else {
                    Log.e(TAG, "onResponse: " + "Authentification incorrecte" );
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.recyclerViewUsers);
        userAdapter = new UserAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(userAdapter);
        Observer<ArrayList<User>> alUsersObserver = users -> {
            userAdapter.setArrayListUsers(users);
        };
        vm.getUserArrayList().observe(this.getViewLifecycleOwner(), alUsersObserver);
    }
}