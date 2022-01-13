package com.example.myawesomeapp.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myawesomeapp.Message;
import com.example.myawesomeapp.User;

import java.util.ArrayList;

public class ListUserFragmentViewModel extends ViewModel {
    MutableLiveData<ArrayList<User>> arrayListUser;

    public MutableLiveData<ArrayList<User>> getUserArrayList() {
        if (arrayListUser == null) {
            this.arrayListUser = new MutableLiveData<>(new ArrayList<User>());
        }

        return this.arrayListUser;
    }
}
