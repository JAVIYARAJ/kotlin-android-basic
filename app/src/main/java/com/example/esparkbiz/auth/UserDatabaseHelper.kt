package com.example.esparkbiz.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class UserDatabaseHelper(context: Context) : SQLiteOpenHelper(context, "Student_Info", null, 1) {

    final val ID: String = "ID";
    final val NAME: String = "NAME";
    final val EMAIL: String = "EMAIL";
    final val PASSWORD: String = "PASSWORD";
    final val TABLE: String = "USER";


    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE ($ID INTEGER PRIMARY KEY,$NAME TEXT,$EMAIL TEXT,$PASSWORD TEXT)";
        db?.execSQL(query);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var query = "DROP TABLE IF EXISTS $TABLE";
        db?.execSQL(query);
        onCreate(db);
    }

    fun insertData(
        name: String,
        email: String,
        password: String,
    ): Long {
        var value = ContentValues();
        with(value) {
            this.put(NAME, name);
            this.put(EMAIL, email);
            this.put(PASSWORD, password);
        }

        var db = writableDatabase;

        var result = db.insert(TABLE, null, value);

        return result;
    }

    fun displayData(): Cursor {
        var query = "SELECT * FROM $TABLE";

        var db = writableDatabase;

        var result = db.rawQuery(query, null);
        return result;
    }

    fun editData(
        id: String, name: String,
        email: String,
        password: String,
        address: String,
    ): Int {

        var db = writableDatabase;
        var value = ContentValues();
        with(value) {
            this.put(NAME, name);
            this.put(EMAIL, email);
            this.put(PASSWORD, password);
        }
        var result = db.update(TABLE, value, "$ID=?", arrayOf(id));

        return result;
    }

    fun deleteData(id: String): Int {

        var db = writableDatabase;
        var result = db.delete(TABLE, "$ID=?", arrayOf(id));

        return result;
    }

    fun getUserInfo(email: String, password: String): Int {
        var db = writableDatabase;

        var selection = "$EMAIL = ? AND $PASSWORD = ?";

        var result = db.query(
            TABLE,
            arrayOf("EMAIL", "PASSWORD"),
            selection,
            arrayOf(email, password),
            null,
            null,
            null
        );

        return  result.count;
    }

}