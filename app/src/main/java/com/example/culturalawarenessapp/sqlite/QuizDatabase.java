package com.example.culturalawarenessapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QuizDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "culturalawarenessapp.db";
    public static final String TABLE_NAME = "cultures";
    public static final String col_1 = "id";
    public static final String col_2 = "culture_name";
    public static final String col_3 = "culture_info";
    public static final String col_4 = "bunked_lectures";

    public QuizDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
