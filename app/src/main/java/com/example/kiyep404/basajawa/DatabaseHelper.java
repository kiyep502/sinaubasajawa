package com.example.kiyep404.basajawa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.kiyep404.basajawa.model.AnakKewan;

import java.util.ArrayList;

/**
 * Created by kiyep404 on 13/03/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Mydb.db";
    public static final String ANAK_KEWAN_TABLE_NAME = "anak_kewan";
    public static final String ANAK_KEWAN_COLUMN_ID = "id";
    public static final String ANAK_KEWAN_COLUMN_NAME = "kewan";
    public static final String ANAK_KEWAN_COLUMN_Anake = "anake";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ANAK_KEWAN_TABLE_NAME + "" +
                "(" + ANAK_KEWAN_COLUMN_ID + " integer primary key," +
                ANAK_KEWAN_COLUMN_NAME + " text," +
                ANAK_KEWAN_COLUMN_Anake + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop tables if exists " + ANAK_KEWAN_TABLE_NAME);
        onCreate(db);
    }

    public void addAnakKewan(AnakKewan kewan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(ANAK_KEWAN_COLUMN_ID, kewan.getId());
        content.put(ANAK_KEWAN_COLUMN_NAME, kewan.getKewan());
        content.put(ANAK_KEWAN_COLUMN_Anake, kewan.getAnakKewan());

        db.insert(ANAK_KEWAN_TABLE_NAME, null, content);
    }

    public void updateAnakKewan(AnakKewan kewan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();

        content.put(ANAK_KEWAN_COLUMN_NAME, kewan.getKewan());
        content.put(ANAK_KEWAN_COLUMN_Anake, kewan.getAnakKewan());

        db.update(ANAK_KEWAN_TABLE_NAME,
                content, ANAK_KEWAN_COLUMN_ID + " = ? ",
                new String[]{Integer.toString(kewan.getId())});
    }

    public void deleteAnakKewan(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(ANAK_KEWAN_TABLE_NAME, ANAK_KEWAN_COLUMN_ID + " = ? ",
                new String[]{Integer.toString(id)});
    }

    public ArrayList<AnakKewan> getAll() {
        ArrayList<AnakKewan> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ANAK_KEWAN_TABLE_NAME, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            AnakKewan kewan = new AnakKewan();
            kewan.setId(cursor.getInt(0));
            kewan.setKewan(cursor.getString(1));
            kewan.setAnakKewan(cursor.getString(2));

            arrayList.add(kewan);
            cursor.moveToNext();
        }

        return arrayList;
    }

    public AnakKewan getAnakeById(int id) {
        AnakKewan kewan = new AnakKewan();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + ANAK_KEWAN_TABLE_NAME + " where " + ANAK_KEWAN_COLUMN_ID + "=" + id, null);

        cursor.moveToFirst();

        if (cursor.getCount() <= 0) {
            return null;
        }

        kewan.setId(cursor.getInt(0));
        kewan.setKewan(cursor.getString(1));
        kewan.setAnakKewan(cursor.getString(2));

        return kewan;

    }
}