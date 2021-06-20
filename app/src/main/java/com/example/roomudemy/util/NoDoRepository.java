package com.example.roomudemy.util;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RoomDatabase;

import com.example.roomudemy.data.NoDORoomDatabase;
import com.example.roomudemy.data.NoDoDao;
import com.example.roomudemy.modal.NoDo;

import java.util.List;

public class NoDoRepository {
    private NoDoDao noDoDao;
    private LiveData<List<NoDo>> allNoDos;


    public NoDoRepository(Application application) {
        // get data from remote api then we put in a diff list
        NoDORoomDatabase db= NoDORoomDatabase.getDatabase(application);
        noDoDao=   db.noDoDao();
        allNoDos=noDoDao.getAllNoDos();



    }

    public LiveData<List<NoDo>>getAllNoDos(){
        return allNoDos;
    }
    public void insert(NoDo noDo)
    {

        new insertAsyncTask(noDoDao).execute(noDo);
    }


    private class insertAsyncTask  extends AsyncTask<NoDo,Void,Void>{
        private  NoDoDao asyncTaskDao;
        public insertAsyncTask(NoDoDao dao) {
            asyncTaskDao=dao;

        }

        @Override
        protected Void doInBackground(NoDo... params) {

            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
