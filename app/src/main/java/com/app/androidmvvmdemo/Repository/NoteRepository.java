package com.app.androidmvvmdemo.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.app.androidmvvmdemo.Model.LocalDataSource.Dao.NoteDao;
import com.app.androidmvvmdemo.Model.LocalDataSource.EntityClasses.Note;
import com.app.androidmvvmdemo.Model.LocalDataSource.NoteDatabase;

import java.util.List;

public class NoteRepository {

    public NoteDao noteDao;
    private LiveData<List<Note>> listOfNotes;

    public NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        listOfNotes = noteDao.noteList();
    }

    public void insert(Note note) {
        new InsertNoteAsynTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateAsynTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteAysnTask(noteDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllAysnTask(noteDao).execute();
    }

    public LiveData<List<Note>> getListOfNotes() {
        return listOfNotes;
    }

    private static class InsertNoteAsynTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public InsertNoteAsynTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    //update asyntask
    private static class UpdateAsynTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public UpdateAsynTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    //delete AsynTask
    private static class DeleteAysnTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        public DeleteAysnTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    //delete all notes

    private static class DeleteAllAysnTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        public DeleteAllAysnTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }


}
