package com.example.playground.RoomDB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class stringRepo {
    private savedStringDAO DAO;
    private LiveData<List<savedString>> allStrings;

    public stringRepo(Application app){
        stringsDatabase db = stringsDatabase.getInstance(app);
        DAO = db.stringsDao();
        allStrings = DAO.getAllString();
    }

    public void insert(savedString string){
        new insertStringAsync(DAO).execute(string);
    }
    public void update(savedString string){
        new updateStringAsync(DAO).execute(string);
    }

    public LiveData<List<savedString>> getAllStrings() {
        return allStrings;
    }

    private static class insertStringAsync extends AsyncTask<savedString, Void, Void> {
        private savedStringDAO DAO;
        private insertStringAsync(savedStringDAO DAO){
            this.DAO = DAO;
        }

        @Override
        protected Void doInBackground(savedString... savedStrings) {
            DAO.Insert(savedStrings[0]);
            return null;
        }
    }

    private static class updateStringAsync extends AsyncTask<savedString, Void, Void> {
        private savedStringDAO DAO;
        private updateStringAsync(savedStringDAO DAO){
            this.DAO = DAO;
        }

        @Override
        protected Void doInBackground(savedString... savedStrings) {
            DAO.Update(savedStrings[0]);
            return null;
        }
    }

}
