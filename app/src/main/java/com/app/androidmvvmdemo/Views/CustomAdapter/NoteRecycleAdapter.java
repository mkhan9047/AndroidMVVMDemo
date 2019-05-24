package com.app.androidmvvmdemo.Views.CustomAdapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.androidmvvmdemo.Model.RoomPrecistenceDatabase.EntityClasses.Note;
import com.app.androidmvvmdemo.R;

import java.util.List;

public class NoteRecycleAdapter extends RecyclerView.Adapter<NoteRecycleAdapter.NoteHolder> {

    List<Note> noteList;
    Activity activity;

    public NoteRecycleAdapter(List<Note> noteList, Activity activity) {
        this.noteList = noteList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_recycler_row, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.tvNotePirority.setText(String.format("Pirority: %d", noteList.get(position).getPriority()));
        holder.tvNoteTitle.setText(noteList.get(position).getTitle());
        holder.tvNoteDesc.setText(noteList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void setItems(Note note) {
        noteList.add(note);
        notifyItemInserted(noteList.size());
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        TextView tvNoteTitle, tvNoteDesc, tvNotePirority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvNoteTitle = itemView.findViewById(R.id.tv_note_title);
            tvNoteDesc = itemView.findViewById(R.id.tv_note_desc);
            tvNotePirority = itemView.findViewById(R.id.tv_pirority);
        }
    }
}
