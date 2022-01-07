package com.example.myawesomeapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myawesomeapp.Message;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<Message>> arrayListMessage;

    public MutableLiveData<ArrayList<Message>> getMessageArrayList() {
        if (arrayListMessage == null) {
            this.arrayListMessage = new MutableLiveData<>(new ArrayList<Message>());
        }

        return this.arrayListMessage;
    }
}
