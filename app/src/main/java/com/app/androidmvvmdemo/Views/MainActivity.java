package com.app.androidmvvmdemo.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.app.androidmvvmdemo.Model.RoomPrecistenceDatabase.EntityClasses.Note;
import com.app.androidmvvmdemo.R;
import com.app.androidmvvmdemo.Repository.NoteRepository;
import com.app.androidmvvmdemo.ViewModel.NoteViewModel;
import com.app.androidmvvmdemo.Views.CustomAdapter.NoteRecycleAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    NoteRecycleAdapter noteRecycleAdapter;
    RecyclerView rvNoteRecyclerView;
    NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        noteViewModel = ViewModelProviders.of(MainActivity.this).get(NoteViewModel.class);
        noteViewModel.getNoteList().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteRecycleAdapter = new NoteRecycleAdapter(notes, MainActivity.this);
                rvNoteRecyclerView.setAdapter(noteRecycleAdapter);
            }
        });
    }

    private void initViews() {
        rvNoteRecyclerView = findViewById(R.id.rv_notes_recycler);
        rvNoteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
