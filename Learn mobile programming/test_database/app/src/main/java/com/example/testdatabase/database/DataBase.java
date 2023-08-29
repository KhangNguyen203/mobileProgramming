package com.example.testdatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DataBase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public DataBase(Context context) {

        super(context, "TestDb.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table Products (id integer primary key autoincrement, " +
                " name text, price float, image text)";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('samsung galaxy', 5000000, 'img1')";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('iphone 11', 10000000, 'img2')";
        db.execSQL(sql);
        sql = "insert into Products( name, price, image) values ('iphone 13', 10000000, 'img2')";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('iphone 14', 10000000, 'img2')";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('iphone 15', 10000000, 'img2')";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('iphone 16', 10000000, 'img2')";
        db.execSQL(sql);

        sql = "insert into Products( name, price, image) values ('iphone 17', 10000000, 'img2')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase getWritableDatabasee() {
        return getWritableDatabase();
    }

    public SQLiteDatabase getReadableDatabasee() {
        return getReadableDatabase();
    }

}
