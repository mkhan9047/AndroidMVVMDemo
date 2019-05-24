package com.app.androidmvvmdemo.Model.RoomPrecistenceDatabase.Dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.app.androidmvvmdemo.Model.RoomPrecistenceDatabase.EntityClasses.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * FROM note_table ORDER BY  priority_name DESC")
    LiveData<List<Note>> noteList();

    @Query("DELETE FROM note_table")
    void deleteAllNotes();
}
