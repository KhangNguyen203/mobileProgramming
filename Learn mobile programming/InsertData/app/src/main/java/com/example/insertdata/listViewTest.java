package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listViewTest extends AppCompatActivity {
    int[] image = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six };
    String[] name = {"One", "Two", "Three", "Four", "Five", "Six"};
    ArrayList<Phone> myList;
    MyArrayAdapter myArrayAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);

        lv = findViewById(R.id.lv);
        myList = new ArrayList<>(); //Tạo mới mảng rỗng

        for (int i = 0; i < name.length; i++) {
            myList.add(new Phone(image[i], name[i]));
        }
        myArrayAdapter = new MyArrayAdapter(listViewTest.this, R.layout.layout_item, myList);

        lv.setAdapter(myArrayAdapter);

//        //Set sự kiện onClick
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(listViewTest.this, subAct.class);
                startActivity(intent);
            }
        });
    }
}