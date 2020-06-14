package com.example.playground;

import androidx.lifecycle.MutableLiveData;

public class DataRepo {
    private static DataRepo instance;
    private static APIManager manager;

    public static DataRepo getInstance(){
        if (instance == null)
            instance = new DataRepo();
        manager = new APIManager();
        return instance;
    }

    public MutableLiveData<WeatherResponse> getData(){
        MutableLiveData<WeatherResponse> data = new MutableLiveData<>();
        manager.getCurrentData(data);
        return data;
    }

}
