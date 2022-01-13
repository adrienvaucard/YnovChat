package com.example.myawesomeapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myawesomeapp.R;
import com.example.myawesomeapp.User;
import com.example.myawesomeapp.databinding.RowLayoutUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> arrayListUsers;

    public UserAdapter() {
        this.arrayListUsers = new ArrayList<>();
    }

    public void setArrayListUsers(ArrayList<User> arrayListUsers) {
        this.arrayListUsers = arrayListUsers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutUserBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_user,
                parent,
                false
        );
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User userToDisplay =  arrayListUsers.get(position);
        holder.binding.setUser(userToDisplay);
    }

    @Override
    public int getItemCount() {
        return arrayListUsers.size();
    }
}
