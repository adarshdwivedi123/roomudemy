package com.example.roomudemy.data;

import android.content.Context;
import android.media.midi.MidiManager;
import android.os.AsyncTask;
import android.os.strictmode.InstanceCountViolation;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomudemy.modal.NoDo;

@Database(entities = {NoDo.class},version = 1)
// we  mAke abstract  becoz we dont wasnt to  every time table is created
public abstract  class NoDORoomDatabase  extends RoomDatabase{
    private static volatile NoDORoomDatabase INSTANCE;
    public abstract  NoDoDao noDoDao();


    public static NoDORoomDatabase  getDatabase(final Context context){
        if(INSTANCE == null)
        {
            synchronized (NoDORoomDatabase.class)
            {
                if(INSTANCE == null)
                {
                    // create our db
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoDORoomDatabase.class,"nodo_database")
                            .addCallback(roomDatabaseCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;

    }

//call  back methood
    private  static  RoomDatabase.Callback  roomDatabaseCallBack=
        new  RoomDatabase.Callback()
        {

            @Override
            public void onOpen(@NonNull  SupportSQLiteDatabase db) {
                super.onOpen(db);
                new PopulateDbAsync(INSTANCE).execute();
            }
        };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final NoDoDao noDoDao;
        public PopulateDbAsync(NoDORoomDatabase db) {
            noDoDao= db.noDoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
//               // for testing i can use them
//            noDoDao.deleteAll(); // remove all the item from the  ytsbale
//            // fortesting
//            NoDo noDo=new NoDo("Buy anew ferrai");
//            noDoDao.insert(noDo);
//
//            noDo=new NoDo("Buy  Big House");
//            noDoDao.insert(noDo);

            return null;
        }
    }
}
