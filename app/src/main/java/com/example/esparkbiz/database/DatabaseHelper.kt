package com.example.esparkbiz.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "Student_Info", null, 1) {

    final val ID: String = "ID";
    final val NAME: String = "NAME";
    final val EMAIL: String = "EMAIL";
    final val CITY: String = "CITY";
    final val ADDRESS: String = "ADDRESS";
    final val TABLE: String = "STUDENT";


    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "CREATE TABLE $TABLE ($ID INTEGER PRIMARY KEY,$NAME TEXT,$EMAIL TEXT,$CITY TEXT,$ADDRESS TEXT)";
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
        city: String,
        address: String,
    ): Long {
        var value = ContentValues();
        with(value) {
            this.put(NAME, name);
            this.put(EMAIL, email);
            this.put(CITY, city);
            this.put(ADDRESS, address);

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
        city: String,
        address: String,
                 ): Int {

        var db = writableDatabase;
        var value = ContentValues();
        with(value) {
            this.put(NAME, name);
            this.put(EMAIL, email);
            this.put(CITY, city);
            this.put(ADDRESS, address);
        }
        var result = db.update(TABLE, value, "$ID=?", arrayOf(id));

        return result;
    }

    fun deleteData(id: String): Int {

        var db = writableDatabase;
        var result = db.delete(TABLE, "$ID=?", arrayOf(id));

        return result;
    }

    fun filterData(columns:Array<String>?,selectionArgs:String,value:Array<String>?):Cursor{

        var db=writableDatabase;

        var result=db.query(TABLE,columns,selectionArgs,value,null,null,null);
        return result;
    }

}