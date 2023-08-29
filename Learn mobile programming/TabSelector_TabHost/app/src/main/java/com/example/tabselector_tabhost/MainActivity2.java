package com.example.tabselector_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    EditText eTxtA, eTxtB;
    Button btnCong;
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addConTrol();
        addEvent();
    }

    private void addEvent() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCong();
            }
        });
    }
    private void xuLyCong() {
        int a =Integer.parseInt( eTxtA.getText().toString());
        int b =Integer.parseInt( eTxtB.getText().toString());

//        String s = ""+ a +"+" +b +" = "+ (a+b);
        String s =String.format("%s + %s = %s", a,b,(a+b));
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

        myList.add(s);
        myAdapter.notifyDataSetChanged();

        eTxtA.setText("");
        eTxtB.setText("");
        eTxtA.requestFocus();
    }

    private void addConTrol() {
        eTxtA = findViewById(R.id.eTxtA);
        eTxtB = findViewById(R.id.eTxtB);
        btnCong = findViewById(R.id.btnCong);
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myAdapter);

        //Tạo tabHost
        TabHost tabHost = findViewById(R.id.tabHost);
        //Cài đặt cho tabHost
        tabHost.setup();
        //Tạo Tab Cộng
            //Tạo các tabButton và đặt id
            TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
            //Tạo nhãn cho button
            tab1.setIndicator("1. Phép cộng");
    //        //Nếu muốn đưa hình vào button
    //        tab1.setIndicator("",getResources().getDrawable());
            tab1.setContent(R.id.tabCong);
            tabHost.addTab(tab1);
        //Tạo Tab Lịch Sử
            TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
            tab2.setIndicator("2. Lịch Sử");
            tab2.setContent(R.id.tabLichSu);
            tabHost.addTab(tab2);


    }
}