package com.example.sompleapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String EMAIL_COL = "email";

    public DBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USERS = "CREATE TABLE "+TABLE_NAME+"("+ID_COL+"INTEGER PRIMARY KEY,"+NAME_COL+"TEXT,"+EMAIL_COL+"TEXT)";
        db.execSQL(CREATE_TABLE_USERS); //CREATE A TABLE
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
}
