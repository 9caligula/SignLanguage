package com.example.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.model.ChapterEducation;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFactory {
    private DatabaseHelper databaseHelper;
    public static SQLiteDatabase db;
    public static List<ChapterEducation> listAllLessons = new ArrayList<>();
    private Cursor userCursor;

    @SuppressLint("Range")
    public DatabaseFactory(Context c) {
        // создаем базу данных
        databaseHelper = new DatabaseHelper(c.getApplicationContext());
        databaseHelper.create_db();
        db = databaseHelper.open();
        listAllLessons = new ArrayList<>();

        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE, null);
        while (userCursor.moveToNext()) {
            listAllLessons.add(new ChapterEducation(
                    userCursor.getInt(userCursor.getColumnIndex(DatabaseHelper.COLUMN_ID)),
                    userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_CHAPTER)),
                    userCursor.getString(userCursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)),
                    userCursor.getInt((userCursor.getColumnIndex(DatabaseHelper.COLUMN_ISSTUDY))),
                    userCursor.getString((userCursor.getColumnIndex(DatabaseHelper.COLUMN_URL))))
            );
        }
    }

    public List<ChapterEducation> getList() {
        return listAllLessons;
    }
}