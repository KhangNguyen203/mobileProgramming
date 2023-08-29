package com.example.quanlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    //Khai báo các biến giao diện
    Button btnInsert, btnDelete, btnUpdate, btnQuery;
    EditText etxtMa, etxtTen, etxtSiSo;

    //Khai báo biến ListView
    ListView lv;
    ArrayList<String> mylist;
//    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addcontrol();
    }

    public void addcontrol() {
        btnInsert = findViewById(R.id.btnInsert);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnQuery = findViewById(R.id.btnQuery);
        etxtMa = findViewById(R.id.etxtMa);
        etxtTen = findViewById(R.id.etxtTen);
        etxtSiSo = findViewById(R.id.etxtSiSo);

        //tạo listView
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
//        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
//        lv.setAdapter(myadapter);

        //Tạo và mở CSDl SQLite
        mydatabase = openOrCreateDatabase("QuanLySV.db", MODE_PRIVATE, null);

        //Tạo table
        try {
            String sql = "Create table TB_LOP(maLop TEXT primary key , tenLop TEXT, siSo INTEGER)";
            mydatabase.execSQL(sql);
        }
        catch(Exception e){
            Log.e("java.lang.Error", "Table đã tồn tại");
        }

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = etxtMa.getText().toString();
                String tenLop = etxtTen.getText().toString();
                int siSo = Integer.parseInt(etxtSiSo.getText().toString());

                ContentValues myValue = new ContentValues();
                myValue.put("maLop", maLop);
                myValue.put("tenLop", tenLop);
                myValue.put("siSo", siSo);

                String msg;
                if(mydatabase.insert("TB_LOP",null, myValue) == -1){
                    msg = "fail to Insert Record!";
                }
                else {
                    msg = "Insert record Sucessfully";
                }
                Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = etxtMa.getText().toString();
                int n = mydatabase.delete("TB_LOP","maLop = ?", new String[]{maLop} );
                String msg = "";
                if (n == 0){
                    msg = "No record to Delete";
                }else {
                    msg = n+ " record is deleted";
                }
                Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maLop = etxtMa.getText().toString();
                int siSo = Integer.parseInt(etxtSiSo.getText().toString());
                ContentValues myValue = new ContentValues();
                myValue.put("siSo", siSo);
                int n = mydatabase.update("TB_LOP", myValue,"maLop = ?", new String[]{maLop});
                String msg = "";
                if (n == 0){
                    msg = "No record to Update";
                }else {
                    msg = n+ " record is Updated";
                }
                Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.clear();
                Cursor c = mydatabase.query("TB_LOP", null,null, null, null, null, null);
                c.moveToNext();
                String data = "";
                while(c.isAfterLast() == false ){
                    data = c.getString(0) + "-"+ c.getString(1)+ "-"+ c.getString(2);
//                    Log.e(TAG, c.getString(0) + "-"+ c.getString(1)+ "-"+ c.getString(2));
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
//              myadapter.notifyDataSetChanged();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1, mylist);
                lv.setAdapter(adapter);
            }
        });

    }
}