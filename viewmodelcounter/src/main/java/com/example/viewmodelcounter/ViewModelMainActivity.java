package com.example.viewmodelcounter;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelMainActivity extends ViewModel {
    private static final String TAG = "ViewModelMainActivity";
    private MutableLiveData<Integer> counter;

    public ViewModelMainActivity() {

    }

    public MutableLiveData<Integer> getCounter() {
        if (counter == null) {
            counter = new MutableLiveData<>();
            counter.setValue(0);
        }
        return counter;
    }

    public void incrementCounter() {
        try {
            counter.postValue(getCounter().getValue() + 1);
        } catch (NullPointerException npe) {
            Log.e(TAG, "incrementCounter: " + "Counter or Value inexistant" );
        }
    }
}
