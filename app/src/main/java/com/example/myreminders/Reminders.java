package com.example.myreminders;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Reminders extends CursorAdapter {

    private Date currentDate;

    EditText titleEditText;
    EditText dateEditText;
    EditText typeEditText;

    public Reminders (Context context, Cursor cursor, int flags){
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.li_my_reminder, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.titleTextView))
                .setText(cursor.getString(cursor.getColumnIndex("title")));
        ((TextView) view.findViewById(R.id.dateTextView))
                .setText(cursor.getString(cursor.getColumnIndex("date")));
        Date currentDate = new Date();
        currentDate.getTime();
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String newDate = (cursor.getString(cursor.getColumnIndex("date")));
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(newDate);
            //String newDate = simpleDateFormat.format(new Date());
            if (currentDate.compareTo(date) < 0) {
                ((TextView) view.findViewById(R.id.typeTextView))
                        .setText(("Expired: false"));
            } else {
                ((TextView) view.findViewById(R.id.typeTextView))
                        .setText(("Expired: true"));
            }
        }
        catch (Exception exception){

        }
    }
}
