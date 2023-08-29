package com.example.insertdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public DatabaseHelper(@Nullable Context context) {
        super(context, "InsertData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TB_Insert(id integer primary key autoincrement, title text, message text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertData(Data data){
        SQLiteDatabase myData = this.getWritableDatabase();
        ContentValues myValues = new ContentValues();
        myValues.put("title", data.getTitle());
        myValues.put("message", data.getMessage());

        myData.insert("TB_Insert", null , myValues);
        Log.e(TAG, "Insert Data Sucessfully");
    }

    public ArrayList fetchData(){
        ArrayList<String> myList = new ArrayList<>();
        myList.clear();

        SQLiteDatabase myData = this.getReadableDatabase();
        Cursor c = myData.rawQuery("select * from TB_Insert", null,null);
        c.moveToNext();
        String a;
        while(c.isAfterLast() == false){
            a = "title: "+ c.getString(1)+ " message: "+ c.getString(2);
            Log.e(TAG, "title: "+ c.getString(1)+ " message: "+ c.getString(2));
            c.moveToNext();
            myList.add(a);
        }
        c.close();
        return myList;
    }
}
