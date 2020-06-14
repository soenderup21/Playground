package com.example.playground;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class APIViewModel extends ViewModel {
    private DataRepo repo;
    private MutableLiveData<WeatherResponse> response;

    public void init(){
        if (response != null)
            return;
        repo = DataRepo.getInstance();
        response = repo.getData();
    }

    public LiveData<WeatherResponse> getWeather(){
        return response;
    }


}
