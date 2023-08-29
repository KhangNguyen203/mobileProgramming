package com.example.listbasedwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        addConTrol();
        xuLySKLV();
    }

    private void xuLySKLV() {
        String[]  items = {"Cơ sở lập trình", "Cơ sở dữ liệu", "Cấu dữ liệu", "Lập trình hướng đối tượng"};
        ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        gv.setAdapter(myAdapter);
    }

    private void addConTrol() {
        gv = findViewById(R.id.gv);
    }
}