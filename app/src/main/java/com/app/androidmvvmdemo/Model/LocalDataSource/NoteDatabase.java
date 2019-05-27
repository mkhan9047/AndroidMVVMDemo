package com.app.androidmvvmdemo.Model.LocalDataSource;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.app.androidmvvmdemo.Model.LocalDataSource.Dao.NoteDao;
import com.app.androidmvvmdemo.Model.LocalDataSource.EntityClasses.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                    .addCallback(roomCallBack)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataToDatabase(instance).execute();
        }
    };

    public static class PopulateDataToDatabase extends AsyncTask<Void, Void, Void> {
        NoteDao noteDao;
        public PopulateDataToDatabase(NoteDatabase noteDatabase) {
            noteDao = noteDatabase.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Title 1", "Hello it's test", 1));
            noteDao.insert(new Note("Title 2", "Hello it's test", 2));
            noteDao.insert(new Note("Title 3", "Hello it's test", 3));
            noteDao.insert(new Note("Title 4", "Hello it's test", 4));

            return null;
        }
    }
}
