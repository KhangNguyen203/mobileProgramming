package com.example.datlichtocapp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {
    //Khai báo tên các Table
    public static final String TB_USERS = "USERS";

    //Khai báo các trường của các Table
    public static String TB_USERS_USERNAME = "username";
    public static String TB_USERS_EMAIL = "email";
    public static String TB_USERS_PASSWORD = "password";

    public CreateDatabase(Context context) {

        super(context, "DatLichCatToc.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String tbUsers = "CREATE TABLE "+TB_USERS+ "( " +
//                TB_USERS_USERNAME +" TEXT PRIMARY KEY, " +
//                TB_USERS_EMAIL + " TEXT, " +
//                TB_USERS_PASSWORD + " TEXT)";

        String tbUsers = "create table USERS(username primary key,email text, password text) ";
        db.execSQL(tbUsers);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public SQLiteDatabase getWritableDatabasee() {
        return getWritableDatabase();
    }


//    public SQLiteDatabase getReadableDatabasee() {
//        return super.getReadableDatabase();
//    }
}
