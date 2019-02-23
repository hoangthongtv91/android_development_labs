package com.example.student.roomword;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDAO mWordDAO;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDataBase db = WordRoomDataBase.getDataBase(application);
        mWordDAO = db.wordDAO();
        mAllWords = mWordDAO.getAllWord();

    }

    public LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        new InsertASyncTask(mWordDAO).execute(word);
    }

    private static class InsertASyncTask extends AsyncTask<Word, Void, Void> {
        private WordDAO mAsyncTaskDAO;

        InsertASyncTask(WordDAO dao) {
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDAO.insert(words[0]);
            return null;
        }
    }
}
