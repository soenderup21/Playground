package com.example.playground.RoomDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class stringsViewModel extends AndroidViewModel {
    private stringRepo Repo;
    private LiveData<List<savedString>> allStrings;

    public stringsViewModel(@NonNull Application application) {
        super(application);
        Repo = new stringRepo(application);
        allStrings = Repo.getAllStrings();
    }

    public void insert(savedString string){
        Repo.insert(string);
    }
    public void update(savedString string){
        Repo.update(string);
    }

    public LiveData<List<savedString>> getAllStrings() {
        return allStrings;
    }
}
