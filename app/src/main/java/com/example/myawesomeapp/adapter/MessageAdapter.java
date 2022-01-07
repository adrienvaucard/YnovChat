package com.example.myawesomeapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.R;
import com.example.myawesomeapp.databinding.RowLayoutMessageBinding;
import com.example.myawesomeapp.fragment.MessageListFragmentDirections;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

    ArrayList<Message> messageArrayList;

    public MessageAdapter(ArrayList<Message> messageArrayList) {
        this.messageArrayList = messageArrayList;
    }

    public void addMessage(Message m) {
        messageArrayList.add(m);
        notifyItemInserted(messageArrayList.size() - 1);
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutMessageBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.row_layout_message,
                parent,
                false
        );
        return new MessageHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        Message msg = messageArrayList.get(position);
        MessageListFragmentDirections.ActionMessageListFragmentToMessageDetailFragment action = MessageListFragmentDirections.actionMessageListFragmentToMessageDetailFragment(msg);
        holder.itemView.setOnClickListener(
                (view) -> Navigation.findNavController(holder.itemView)
                .navigate(action)
        );
        holder.binding.setMessage(msg);
    }

    @Override
    public int getItemCount() {
        return messageArrayList.size();
    }
}
