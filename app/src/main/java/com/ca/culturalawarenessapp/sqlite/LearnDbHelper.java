package com.ca.culturalawarenessapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ca.culturalawarenessapp.datamodels.LearnDataModel;

import java.util.ArrayList;
import java.util.List;
//engmuheidat@gmail.com
/*
    Author : Rushabh Picha
 */
public class LearnDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Info.db";
    public static final int DATABASE_VERSION = 7;
    public final String TABLE_NAME = "LEARN_TABLE";
    private static LearnDbHelper instance;
    private String id = "id";
    private String name = "name";
    private String info = "info";


    private SQLiteDatabase db;
    // Info Database Constructor
    public LearnDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Used Singleton Design Pattern to avoid repeated creating of the QuizBdHelper Object.
    public static synchronized LearnDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new LearnDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String infoQuery = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                this.id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                this.name + " TEXT, " + this.info +" TEXT" + ")";

        db.execSQL(infoQuery);
        fillValues();
    }

    private void fillValues() {
        LearnDataModel info1 = new LearnDataModel(1, "Asian", "Asians tend to be highly group-oriented people who place a strong emphasis on family connection as the major source of identity and protection against the hardships of life.");
        //LearnDataModel info2 = new LearnDataModel(1, "Asian", "The culture of Asia encompasses the collective and diverse customs and traditions of art, architecture, music, literature, lifestyle, philosophy, politics and religion that have been practiced and maintained by the numerous ethnic groups of the continent of Asia since prehistory.");

        insertInfo(info1);
        //insertInfo(info2);
    }

    private void insertInfo(LearnDataModel learnDataModel) {
        ContentValues cv = new ContentValues();
        cv.put("id", learnDataModel.getId());
        cv.put("name", learnDataModel.getName());
        cv.put("info", learnDataModel.getInfo());
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(db);
    }
    public boolean insertData(String culture_name, String culture_description) {
        // create an instance of SQLiteDatabase to convert it into writable mode
        SQLiteDatabase db = this.getWritableDatabase();
        /* ContentValue class lets you put information inside an object in the form of Key-Value pairs
         for columns and their value. The object can then be passed to the insert() method of an instance
         of the SQLiteDatabase class to insert or update your WritableDatabase.*/
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, culture_name);
        contentValues.put(info, culture_description);

        // result is set to -1 if there is an error in inserting data into the database.
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<LearnDataModel> getLearnInfo(String cultureName){
        List<LearnDataModel> learnDataModelList = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE NAME='"+cultureName+"';", null);
        StringBuffer stringBuffer = new StringBuffer();
        LearnDataModel learnDataModel = null;

        while(cursor.moveToNext()){
            learnDataModel = new LearnDataModel();
            String cultureInfo = cursor.getString(cursor.getColumnIndexOrThrow(info));
            learnDataModel.setInfo(cultureInfo);

            //stringBuffer.append(learnDataModel);

            learnDataModelList.add(learnDataModel);
        }
        return learnDataModelList;
    }

    public List<String> getCultureNames(){
        List<String> cultureLists = new ArrayList<>();
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT NAME FROM "+TABLE_NAME+";", null);
        while(cursor.moveToNext()){
            String cultureName = cursor.getString(cursor.getColumnIndex(name));
            cultureLists.add(cultureName);
        }
        cultureLists.add("American");
        cultureLists.add("Latino");
        cultureLists.add("European");
        cultureLists.add("CSUSB culture");
        cultureLists.add("African");

        return cultureLists;
    }
}
