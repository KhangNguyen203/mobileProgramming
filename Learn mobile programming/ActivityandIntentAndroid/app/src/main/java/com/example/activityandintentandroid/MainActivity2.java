package com.example.activityandintentandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }


    public void xuLySKCheToanBoMH(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
        startActivity(intent);
    }

    public void xuLýKCheMotPhanMH(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        startActivity(intent);
    }

    public void xuLySKHienTT(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity4.class);

        //Đưa dữ liệu vào
        intent.putExtra("String", "Welcome to my application");
        intent.putExtra("int", 2002);

        startActivity(intent);
    }





    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

//    public MainActivity2() {
//        super();
//    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }


}