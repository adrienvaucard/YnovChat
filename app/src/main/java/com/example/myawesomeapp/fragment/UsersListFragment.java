package com.example.myawesomeapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myawesomeapp.R;
import com.example.myawesomeapp.User;
import com.example.myawesomeapp.adapter.UserAdapter;
import com.example.myawesomeapp.viewmodel.ListUserFragmentViewModel;

import java.util.ArrayList;


public class UsersListFragment extends Fragment {
    ListUserFragmentViewModel vm;
    private RecyclerView rv;
    private UserAdapter userAdapter;

    public UsersListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vm = new ViewModelProvider(this).get(ListUserFragmentViewModel.class);
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