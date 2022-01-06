package com.example.myawesomeapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.R;
import com.example.myawesomeapp.databinding.FragmentMessageDetailBinding;
import com.example.myawesomeapp.databinding.RowLayoutMessageBinding;

public class MessageDetailFragment extends Fragment {
    FragmentMessageDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.fragment_message_detail,
                container,
                false
        );

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Message msg = MessageDetailFragmentArgs.fromBundle(getArguments()).getMessage();
        binding.setMessage(msg);
        //Toast.makeText(view.getContext(), msg.getContent(), Toast.LENGTH_SHORT).show();
    }
}