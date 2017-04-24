package com.example.kiyep404.basajawa.DataKamus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataKamus extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "dbkamus";
        public static final String JENENGARANE = "jenengarane";
        public static final String ARANE= "arane";
        public static final String JENISARANE= "jenisarane";


        //Constructor DataKamus untuk initiate database
        public DataKamus(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        //method createTable untuk membuat table kamus
        public void createTable(SQLiteDatabase db){
            db.execSQL("DROP TABLE IF EXISTS kamus");
            db.execSQL("CREATE TABLE if not exists kamus (id INTEGER PRIMARY KEY AUTOINCREMENT, jenengarane TEXT, arane TEXT, jenisarane TEXT);");
        }

        //method generateData untuk mengisikan data ke kamus.
        public void generateData(SQLiteDatabase db){
            ContentValues cv=new ContentValues();
            cv.put(JENENGARANE, "asem");
            cv.put(ARANE, "sinom");
            cv.put(JENISARANE, "godhong");
            db.insert("kamus", ARANE, cv);

            cv.put(JENENGARANE, "aren");
            cv.put(ARANE, "dliring");
            cv.put(JENENGARANE, "godhong");
            db.insert("kamus", ARANE, cv);

            cv.put(JENENGARANE, "dhadap");
            cv.put(ARANE, "tawa");
            cv.put(JENISARANE, "godhong");

            cv.put(JENENGARANE, "gebang");
            cv.put(ARANE, "kejang");
            cv.put(JENISARANE, "godhong");
            db.insert("kamus", ARANE, cv);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
        }
    }


