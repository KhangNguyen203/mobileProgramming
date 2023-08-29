package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class InsertData extends AppCompatActivity {
    EditText eTxtTitle, eTxtMessage;
    TextView txtDate;
    Button btnInsert, btnQuery, btnClickDate;
    ListView lv;
    ArrayAdapter myAdapter;
    ArrayList<String> myList;


    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        addControl();
        clickShowDate();
    }

    private void addControl() {
        eTxtTitle = findViewById(R.id.eTxtTitle);
        eTxtMessage = findViewById(R.id.eTxtMessage);
        btnInsert = findViewById(R.id.btnInsert);
        btnQuery = findViewById(R.id.btnQuery);
        btnClickDate = findViewById(R.id.btnClickDate);
        myList = new ArrayList<>();
        lv = findViewById(R.id.lv);
        txtDate = findViewById(R.id.txtDate);
        databaseHelper = new DatabaseHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String title = eTxtTitle.getText().toString();
                    String message = eTxtMessage.getText().toString();
                    Data data = new Data(title, message);
                    databaseHelper.insertData(data);

//                Intent intent = new Intent(InsertData.this, listViewTest.class);
//                startActivity(intent);
            }
        });
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList = databaseHelper.fetchData();
                myAdapter = new ArrayAdapter(InsertData.this, android.R.layout.simple_list_item_1,myList);
                lv.setAdapter(myAdapter);

            }

        });
    }

    private void clickShowDate() {
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        btnClickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertData.this, new DatePickerDialog.OnDateSetListener() {
                    @Override                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String show = String.format("%d/%d/%d", dayOfMonth, month, year);
                        txtDate.setText(show);
                    }
                },year, month, date);
                datePickerDialog.show();
            }
        });
    }
}