package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    private boolean mShowDividers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        mPrefs = getSharedPreferences("Note to Self", MODE_PRIVATE);
        mEditor = mPrefs.edit();

        mShowDividers = mPrefs.getBoolean("dividers", true);
        switch1.setChecked(mShowDividers);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                   mEditor.putBoolean("dividers",true);
                   mShowDividers = true;
                }else{
                    mEditor.putBoolean("dividers",false);
                    mShowDividers = false;
                }
            }
        });

    }

    @Override
    public void onPause(){
        super.onPause();
        mEditor.commit();
    }
}