package com.example.playground.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Query;

import java.util.List;


@Entity(tableName = "savedStrings")
public class savedString {
    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;
    @ColumnInfo(name = "data")
    public String data;


    public savedString(int id, String data){
        this.data = data;
        this.id = id;
    }

}
