package com.app.androidmvvmdemo.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.app.androidmvvmdemo.Model.LocalDataSource.EntityClasses.Note;
import com.app.androidmvvmdemo.Repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    NoteRepository noteRepository;
    LiveData<List<Note>> noteList;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        noteList = noteRepository.getListOfNotes();
    }

    public void insert(Note note) {
        noteRepository.insert(note);
    }

    public void update(Note note) {
        noteRepository.update(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }

    public void deleteAllNotes() {
        noteRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getNoteList() {
        return noteRepository.getListOfNotes();
    }

}
