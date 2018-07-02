package com.android.sonsofpitches.starbazaar;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "events.db";
    private static final String TABLE_PRODUCTS = "events";
    private static final String COLUMN_ID = "eventID";
    private static final String COLUMN_EVENTNAME = "eventName";
    private static final String COLUMN_EVENTDATE = "eventDate";
    private static final String COLUMN_EVENTTIME = "eventTime";
    private static final String COLUMN_EVENTLOCFULL = "eventLocationFull";
    private static final String COLUMN_EVENTLOCBRIEF = "eventLocationBrief";
    private static final String COLUMN_EVENTTHUMBNAIL = "eventThumbnail";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_EVENTNAME + " TEXT, "
                + COLUMN_EVENTDATE + " TEXT, "
                + COLUMN_EVENTTIME + " TEXT, "
                + COLUMN_EVENTLOCFULL + " TEXT, "
                + COLUMN_EVENTLOCBRIEF + " TEXT, "
                +COLUMN_EVENTTHUMBNAIL + " INTEGER "
                + ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add new row to to Database
    public void addEvent(EventsList_Event event) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENTNAME, event.getEventName());
        values.put(COLUMN_EVENTDATE, event.getEventDate());
        values.put(COLUMN_EVENTTIME, event.getEventTime());
        values.put(COLUMN_EVENTLOCFULL, event.getEventLocationFull());
        values.put(COLUMN_EVENTLOCBRIEF, event.getEventLocationBrief());
        values.put(COLUMN_EVENTTHUMBNAIL, event.getEventThumbnail());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete Row from Database
    public void deleteEvents() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + ";");
    }


    public List<EventsList_Event> retrieveData() {

        List<EventsList_Event> listOfSavedEvents = new ArrayList<EventsList_Event>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] fields = {COLUMN_EVENTNAME, COLUMN_EVENTDATE, COLUMN_EVENTTIME, COLUMN_EVENTLOCFULL, COLUMN_EVENTLOCBRIEF, COLUMN_EVENTTHUMBNAIL};

        Cursor c = db.query(TABLE_PRODUCTS, fields, null,null, null, null, null);
        int e_name = c.getColumnIndex(COLUMN_EVENTNAME);
        int e_date = c.getColumnIndex(COLUMN_EVENTDATE);
        int e_time = c.getColumnIndex(COLUMN_EVENTTIME);
        int e_locFull = c.getColumnIndex(COLUMN_EVENTLOCFULL);
        int e_locBrief = c.getColumnIndex(COLUMN_EVENTLOCBRIEF);
        int e_thumbnail = c.getColumnIndex(COLUMN_EVENTTHUMBNAIL);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

            String name = c.getString(e_name);
            String date = c.getString(e_date);
            String time = c.getString(e_time);
            String locFull = c.getString(e_locFull);
            String locBrf = c.getString(e_locBrief);
            int thumb = c.getInt(e_thumbnail);


            listOfSavedEvents.add(new EventsList_Event(name, date, locFull, time, locBrf, thumb));
        }
        c.close();
        db.close();
        return listOfSavedEvents;
    }


}
