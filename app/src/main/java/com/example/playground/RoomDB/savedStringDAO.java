package com.example.playground.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface savedStringDAO {
    @Update
    void Update(savedString strings);
    @Insert
    void Insert(savedString strings);
    @Query("SELECT * FROM savedStrings")
    LiveData<List<savedString>> getAllString();

}