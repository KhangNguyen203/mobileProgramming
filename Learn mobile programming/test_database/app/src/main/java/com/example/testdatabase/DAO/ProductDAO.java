package com.example.testdatabase.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testdatabase.Products;
import com.example.testdatabase.database.DataBase;

import java.util.ArrayList;

    public class ProductDAO {
    private SQLiteDatabase database;
    private DataBase createDatabase;
    private ArrayList myList;

    public ProductDAO (Context context){
        createDatabase = new DataBase(context);
    }

    public ArrayList<Products> getAll(){
        ArrayList<Products> ds = new ArrayList<>();
        this.database = createDatabase.getReadableDatabasee();
        Cursor c =database.rawQuery("Select * from Products ", null, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int id = c.getInt(0);
            String name = c.getString(1);
            double price = c.getDouble(2);
            String imgName = c.getString(3);

            Products p = new Products(id, name, price, imgName);
            ds.add(p);
            c.moveToNext();
        }
        c.close();
        return ds;
    }
}
