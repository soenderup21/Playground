package com.example.playground.RoomDB;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {savedString.class}, version = 1)
public abstract class stringsDatabase extends RoomDatabase {

    private static stringsDatabase instance;

    public abstract savedStringDAO stringsDao();

    public static synchronized stringsDatabase getInstance(Context context){
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    stringsDatabase.class, "saved String DB")
                    .fallbackToDestructiveMigrationFrom()
                    .addCallback(roomCallback)
                    .build();
        return instance;
    }

    private static  RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(instance).execute();
        }
    };

    private static class PopulateAsyncTask extends AsyncTask<Void, Void, Void>{
        private savedStringDAO DAO;
        private PopulateAsyncTask(stringsDatabase db){
            DAO = db.stringsDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            DAO.Insert(new savedString(0, "hello"));
            return null;
        }
    }

}