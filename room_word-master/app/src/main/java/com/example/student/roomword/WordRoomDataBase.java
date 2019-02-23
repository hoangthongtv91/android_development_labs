package com.example.student.roomword;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

@Database(entities = (Word.class), version = 1, exportSchema = false)
public abstract class WordRoomDataBase extends RoomDatabase {
    public abstract WordDAO wordDAO();

    private static WordRoomDataBase INSTANCE;

    static WordRoomDataBase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDataBase.class,
                            "word_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(mRoomDatabaseCallback)
                            .build();
                }

            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback mRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };


    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{
        private WordDAO mWordDao;
        String [] words = {};
        PopulateDbAsync(WordRoomDataBase db){
            mWordDao = db.wordDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDao.deleteAll();
            for (int i = 0; i < words.length, i++){
                Word word = new Word(words[i]);
                mWordDao.insert(word);
            }
            return null;
        }
    }
}
