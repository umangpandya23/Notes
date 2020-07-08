package com.example.notes;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ListItemHolder> {
    private List<Note> mNodeList;
    private MainActivity mMainActivity;

    public NoteAdapter(MainActivity mainActivity, List<Note> noteList){
        this.mNodeList = noteList;
        this.mMainActivity = mainActivity;
    }

    @NonNull
    @Override
    public NoteAdapter.ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new ListItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.ListItemHolder holder, int position) {
        Note note = mNodeList.get(position);
        holder.mTitle.setText(note.getmTitle());
        if(note.getmDescription().length()>15){
            holder.mDescription.setText(note.getmDescription().substring(0,15));
        }
        else{
            holder.mDescription.setText(note.getmDescription().substring(0,note.getmDescription().length()/2));
        }
        if (note.ismIdea()) {
            holder.mStatus.setText(R.string.idea_text);
        }else if(note.ismTodo()){
            holder.mStatus.setText(R.string.todo_text);
        }else if(note.ismImportant()){
            holder.mStatus.setText(R.string.important_text);
        }
    }

    @Override
    public int getItemCount() {
        return mNodeList.size();
    }

    public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle;
        TextView mDescription;
        TextView mStatus;
        public ListItemHolder(View view){
            super(view);
            mTitle = (TextView) view.findViewById(R.id.textViewTitile);
            mDescription = (TextView) view.findViewById(R.id.textViewDescription);
            mStatus = (TextView) view.findViewById(R.id.textViewStatus);
            view.setClickable(true);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            mMainActivity.showNote(getAdapterPosition());
        }
    }
}
