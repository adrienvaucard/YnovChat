package com.example.myawesomeapp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myawesomeapp.databinding.RowLayoutUserBinding;

public class UserViewHolder extends RecyclerView.ViewHolder {
    RowLayoutUserBinding binding;

    public UserViewHolder(@NonNull RowLayoutUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
