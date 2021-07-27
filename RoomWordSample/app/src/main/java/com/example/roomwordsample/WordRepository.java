package com.example.roomwordsample;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private WordDAO mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDAO();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords()
    {
        return mAllWords;
    }

    public void insert (Word word)
    {
        new insertAsyncTask(mWordDao).execute(word);
    }
    public void deleteAll()
    {
        new deleteAllWordsAsyncTask(mWordDao).execute();
    }
    public void deleteWord(Word word)
    {
        new deleteWordAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDAO mAsyncTaskDao;

        insertAsyncTask(WordDAO dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params)
        {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Word, Void, Void>
    {

        private WordDAO mAsyncTaskDao;

        deleteAllWordsAsyncTask(WordDAO dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params)
        {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    private static class deleteWordAsyncTask extends AsyncTask<Word, Void, Void>
    {
        private WordDAO mAsyncTaskDao;

        deleteWordAsyncTask(WordDAO dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params)
        {
            mAsyncTaskDao.deleteWord(params[0]);
            return null;
        }
    }
}