package com.example.student.roomword;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class WordVIewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords; // to cache the list of words

    public WordVIewModel(Application application){
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }

    public LiveData<List<Word>> getmAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        mRepository.insert(word);
    }
}
