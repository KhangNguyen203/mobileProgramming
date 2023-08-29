package com.example.datlichtocapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.util.Log;

import com.example.datlichtocapp.DTO.UserDTO;
import com.example.datlichtocapp.Database.CreateDatabase;

public class UsersDAO {
    private static final String TAG = "UsersDAO";
    private SQLiteDatabase database;
    private CreateDatabase createDatabase;

    public UsersDAO(Context context ){
        this.createDatabase = new CreateDatabase(context);
    }

    //Thêm dữ liệu vào các trường của bảng Users
    public void ThemUser(UserDTO userDTO){
        this.database = createDatabase.getWritableDatabasee();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_USERS_USERNAME, userDTO.getUsername());
        contentValues.put(CreateDatabase.TB_USERS_EMAIL, userDTO.getEmail());
        contentValues.put(CreateDatabase.TB_USERS_PASSWORD, userDTO.getPassword());
//        contentValues.put("passwordTEXT", userDTO.getPassword());

        this.database.insert("USERS", null, contentValues);
        Log.e(TAG, "Insert Successfully");
//        if(this.database.insert("USERS", null, contentValues) ==1){
//            Log.e(TAG, "Insert Successfully");
//        }else{
//            Log.e("erro", "Fail Successfully");
//        }

    }

    //Kiểm tra bảng User có dữ liệu hay chưa
//    public boolean kiemTraUser(){
//        String query = "select * from " + CreateDatabase.TB_USERS;
//        Cursor curor = database.rawQuery(query, null);
//        if(curor.getCount() != 0){
//            return true;
//        }else
//            return false;
//    }
}
