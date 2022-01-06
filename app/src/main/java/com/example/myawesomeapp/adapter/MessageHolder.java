package com.example.myawesomeapp.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myawesomeapp.databinding.RowLayoutMessageBinding;

public class MessageHolder extends RecyclerView.ViewHolder {
    RowLayoutMessageBinding binding;

    public MessageHolder(@NonNull RowLayoutMessageBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
