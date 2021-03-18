package com.ca.culturalawarenessapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*
        Rushabh Picha
 */
public class ContributeDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "culturalawarenessapp.db";
    public static final String TABLE_NAME = "contribute";
    public static final int version = 1;
    public static final String col_1 = "id";
    public static final String col_2 = "culture_name";
    public static final String col_3 = "culture_description";
    private static ContributeDatabase contributeDatabase = null;
    public Context context;
    // Constructor for the database helper class
    public ContributeDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
        this.context = context;
    }

    public ContributeDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public ContributeDatabase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    // onCreate overriden method to write a create table query.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (col_2 varchar,col_3 varchar)");
    }

    public ContributeDatabase getInstance()
    {
        if (contributeDatabase == null)
            contributeDatabase = new ContributeDatabase(context);
        return contributeDatabase;
    }

    //onUpgrade method to perform operations when the database is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTs " + TABLE_NAME);
        onCreate(db);
    }

    // the insertData method to insert the values in the database. Pass the parameters which are the column names in the database.
    public boolean insertData(String culture_name, String culture_description) {
        // create an instance of SQLiteDatabase to convert it into writable mode
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValue class lets you put information inside an object in the form of Key-Value pairs
         for columns and their value. The object can then be passed to the insert() method of an instance
         of the SQLiteDatabase class to insert or update your WritableDatabase.*/
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2, culture_name);
        contentValues.put(col_3, culture_description);

        // result is set to -1 if there is an error in inserting data into the database.
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}