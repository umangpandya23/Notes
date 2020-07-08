package com.example.notes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Note {

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;

    private static String JSON_TITLE = "title";
    private static String JSON_DESCRIPTION = "description";
    private static String JSON_IDEA = "idea";
    private static String JSON_TODO = "todo";
    private static String JSON_IMPORTANT = "important";

    public Note(){
    }

    public Note(JSONObject jo) throws JSONException {
        mTitle = jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
    }

    public void setmTitle(String mTitle) { this.mTitle = mTitle; }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    public void setmTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    public void setmImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public boolean ismIdea() {
        return mIdea;
    }

    public boolean ismTodo() {
        return mTodo;
    }

    public boolean ismImportant() {
        return mImportant;
    }

    public JSONObject convertToJSON() throws JSONException {
        JSONObject jo = new JSONObject();
        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_IMPORTANT, mImportant);
        jo.put(JSON_TODO, mTodo);
        return jo;
    }

}
