package com.example.myapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context) : SQLiteOpenHelper(context, "BASE", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE APPBANK(_id integer primary key autoincrement, EMAIL TEXT, SENHA TEXT)")
        db?.execSQL("INSERT INTO APPBANK(EMAIL, SENHA) VALUES ('muriel@gmail.com', '1234')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}