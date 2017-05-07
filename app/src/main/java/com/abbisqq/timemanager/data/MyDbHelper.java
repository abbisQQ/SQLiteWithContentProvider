package com.abbisqq.timemanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by chart on 2/5/2017.
 */

public class MyDbHelper extends SQLiteOpenHelper{


    public static final String DATABASE_NAME = "task_manager.db";


    private static final int DATABASE_VERSION = 2;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE "+

                ContractTimeManager.TasksEntry.TABLE_NAME + " (" +
                ContractTimeManager.TasksEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ContractTimeManager.TasksEntry.TITLE + " TEXT, "+
                ContractTimeManager.TasksEntry.INFO + " TEXT"+ ");";



        db.execSQL(SQL_CREATE_WEATHER_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + ContractTimeManager.TasksEntry.TABLE_NAME);
        onCreate(db);

    }
}
