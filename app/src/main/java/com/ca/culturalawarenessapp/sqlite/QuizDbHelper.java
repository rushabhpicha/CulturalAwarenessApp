package com.ca.culturalawarenessapp.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

import com.ca.culturalawarenessapp.datamodels.Category;
import com.ca.culturalawarenessapp.definitions.QuizDetails.*;
import com.ca.culturalawarenessapp.datamodels.QuestionModel;
/*
    Author : Rushabh Picha
 */

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizDatabase.db";
    public static final int DATABASE_VERSION = 5;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;
    // Quiz Database Constructor
    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Used Singleton Design Pattern to avoid repeated creating of the QuizBdHelper Object.
    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    /*
        onCreate method to create the tables Categories and List of Questions for the Quiz. I have used
        Column_category_Id from the Questions table and ID from the Category table as a foreign key
    */

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        // used final keyword since the variable is a constant
        final String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + " ( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " + ")";

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable.COLUMN_DIFFICULTY + " TEXT," +
                QuestionTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" + ")";

        db.execSQL(SQL_CREATE_CATEGORY_TABLE);
        db.execSQL(SQL_CREATE_QUESTION_TABLE);

        /* once the database is created we call the fillCategoriesTable() method and the fillQuestionTable()
            to enter values in our two two tables.
        */

        fillCategoriesTable();
        fillQuestionTable();
    }

    // We call the onUpgrade and method to dop the table or delete the table whenever necessary
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Implementation of the fillCategoriesTable which is called after the creation of the table.
    private void fillCategoriesTable() {
        Category c1 = new Category("Asian");
        insertCategory(c1);

        Category c2 = new Category("American");
        insertCategory(c2);

        Category c3 = new Category("African");
        insertCategory(c3);
    }
    /*
        ContentValues class to insert values in our table. Content values stores values as Key and value pair
        where key corresponds to the table name and value corresponds to the acual value. Every instance of
        content values add each row in the table.
     */
    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    // Similar implementation of filQuestionTable();
    private void fillQuestionTable() {
        // Asian
        QuestionModel q1 = new QuestionModel("What is the capital of India?",
                "Mumbai", "New Delhi", "Kolkata", 2, QuestionModel.DIFFICULTY_EASY, Category.Asian);
        insertQuestion(q1);

        QuestionModel q2 = new QuestionModel("How do Asians greet ", "Shake hands",
                "Join hands", "none of the above", 2, QuestionModel.DIFFICULTY_EASY, Category.Asian);
        insertQuestion(q2);

        QuestionModel q3 = new QuestionModel("How do Africans greet?", "Shake hands",
                "Join Hands", "None of the above", 1, QuestionModel.DIFFICULTY_MEDIUM, Category.African);
        insertQuestion(q3);

        QuestionModel q4 = new QuestionModel("What do Asians wear", "Salvar Kameez",
                "Shirt", "Jeans", 2, QuestionModel.DIFFICULTY_MEDIUM, Category.Asian);
        insertQuestion(q4);

        QuestionModel q5 = new QuestionModel("What do Africans wear", "Salvar Kameez",
                "Shirt", "Jeans", 1, QuestionModel.DIFFICULTY_HARD, Category.African);
        insertQuestion(q5);

        QuestionModel q6 = new QuestionModel("What do Americans wear", "Salvar Kameez",
                "Shirt", "Jeans", 2, QuestionModel.DIFFICULTY_HARD, Category.American);
        insertQuestion(q6);


        QuestionModel q10 = new QuestionModel("What do Asians eat?",
                "Rice", "Noodles", "French Fries", 1, QuestionModel.DIFFICULTY_EASY, Category.Asian);
        insertQuestion(q10);

        QuestionModel q20 = new QuestionModel("What do Americans eat?", "Rice",
                "Noodles", "French Fries", 1, QuestionModel.DIFFICULTY_EASY, Category.American);
        insertQuestion(q20);

        QuestionModel q30 = new QuestionModel("What do Africans eat", "Rice",
                "Noodles", "French Fries", 3, QuestionModel.DIFFICULTY_MEDIUM, Category.African);
        insertQuestion(q30);

        QuestionModel q40 = new QuestionModel("Which is the largest country in Asia", "Russia",
                "India", "China", 2, QuestionModel.DIFFICULTY_MEDIUM, Category.Asian);
        insertQuestion(q40);

        QuestionModel q50 = new QuestionModel("Which is the largest country in America", "Canada",
                "Mexico", "USA", 2, QuestionModel.DIFFICULTY_HARD, Category.American);
        insertQuestion(q50);

        QuestionModel q60 = new QuestionModel("Which is the largest country in Africa", "South Africa",
                "Tanzania", "Egypt", 3, QuestionModel.DIFFICULTY_HARD, Category.African);
        insertQuestion(q60);

    }

    // Using Content Values to insert questions in our Questions Table.
    private void insertQuestion(QuestionModel questionModel) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, questionModel.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, questionModel.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, questionModel.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, questionModel.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, questionModel.getAnswerNr());
        cv.put(QuestionTable.COLUMN_DIFFICULTY, questionModel.getDifficulty());
        cv.put(QuestionTable.COLUMN_CATEGORY_ID, questionModel.getCategoryID());
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    /* getAllCategories method is used to get all the distinct values of the categories that we use in ou Quiz App.
        example Asian, African, American. We will need this in our QuizMainActivity for the user to choose the
         category to start the QUiz.
     */
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(cursor.getInt(cursor.getColumnIndex(CategoriesTable._ID)));
                category.setName(cursor.getString(cursor.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (cursor.moveToNext());
        }
        cursor.close();
        System.out.println(categoryList);
        return categoryList;
    }


    /* Get All Questions method is used to retrieve all the questions in our table. If the user wants to
        take the test for all the random questions this method will be helpful.
     */
    public ArrayList<QuestionModel> getAllQuestion() {
        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                QuestionModel questionModel = new QuestionModel();
                questionModel.setId(cursor.getInt(cursor.getColumnIndex(QuestionTable._ID)));
                questionModel.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questionModel.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questionModel.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questionModel.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questionModel.setAnswerNr(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questionModel.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                questionModel.setCategoryID(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_CATEGORY_ID)));
                questionModelList.add(questionModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        System.out.println(questionModelList);
        return questionModelList;
    }

    /*
        This is a crucial method which retrieves the questions based on the difficulty level that the user
        has chosen, eg Easy, Medium, Hard. This method returns questions based on the difficulty entered.
     */
    public ArrayList<QuestionModel> getQuestions(int categoryID, String difficulty) {
        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
        db = getReadableDatabase();
        String selection = QuestionTable.COLUMN_CATEGORY_ID + "= ? " +
                " AND " + QuestionTable.COLUMN_DIFFICULTY + " = ?";

        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor cursor = db.query(QuestionTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                QuestionModel questionModel = new QuestionModel();
                questionModel.setId(cursor.getInt(cursor.getColumnIndex(QuestionTable._ID)));
                questionModel.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questionModel.setOption1(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questionModel.setOption2(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questionModel.setOption3(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questionModel.setAnswerNr(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questionModel.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionTable.COLUMN_DIFFICULTY)));
                questionModel.setCategoryID(cursor.getInt(cursor.getColumnIndex(QuestionTable.COLUMN_CATEGORY_ID)));
                questionModelList.add(questionModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionModelList;
    }
}
