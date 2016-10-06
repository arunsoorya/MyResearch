package com.arunsoorya.myresearch.mvp;

/**
 * Created by T10778 on 19/06/2016.
 */
public class Note {
    private String textNote;
    private String date;

    public void setText(String textNote){
        this.textNote = textNote;
    }
    public void setDate(String date){
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
