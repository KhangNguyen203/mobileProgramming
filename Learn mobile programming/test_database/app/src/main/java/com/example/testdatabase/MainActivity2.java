package com.example.testdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.testdatabase.DAO.ProductDAO;
import com.example.testdatabase.adapter.ProductAdapter;
import com.example.testdatabase.database.DataBase;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    GridView lv;
    Button ntnTest;
    SQLiteDatabase database;
    ArrayList<Products> ds;
    ProductDAO productDAO;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        xuLySKClick();
    }

    private void xuLySKClick() {
        ntnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private void addControl() {
        lv = findViewById(R.id.lv);
        productDAO = new ProductDAO(this);
        ds = productDAO.getAll();
        adapter = new ProductAdapter(MainActivity2.this, ds);
        lv.setAdapter(adapter);
        ntnTest = findViewById(R.id.ntnTest);
    }
}