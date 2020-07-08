package com.example.notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import java.util.zip.Inflater;

public class DialogShowNote extends DialogFragment {

    private Note mNote;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        final TextView txtTitle = (TextView) dialogView.findViewById(R.id.textTitle);
        final TextView txtDescription = (TextView) dialogView.findViewById(R.id.textDescription);

        txtTitle.setText(mNote.getmTitle());
        txtDescription.setText(mNote.getmDescription());

        TextView txtImportant = (TextView) dialogView.findViewById(R.id.textViewImportant);
        TextView txtTodo = (TextView) dialogView.findViewById(R.id.textViewTodo);
        TextView txtIdea = (TextView) dialogView.findViewById(R.id.textViewIdea);

        if(!mNote.ismImportant()){
            txtImportant.setVisibility(View.GONE);
        }
        if(!mNote.ismIdea()){
            txtIdea.setVisibility(View.GONE);
        }
        if(!mNote.ismTodo()){
            txtTodo.setVisibility(View.GONE);
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);
        builder.setView(dialogView).setMessage("Your Note");
        btnOK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dismiss();
            }
        });

        return builder.create();
    }

    public void sendNoteSelected(Note noteSelected){
        mNote = noteSelected;
    }
}
