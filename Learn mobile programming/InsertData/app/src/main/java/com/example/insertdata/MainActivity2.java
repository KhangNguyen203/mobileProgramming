package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup rbGroup;
    RadioButton rb;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbGroup = findViewById(R.id.rbGroup);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = findViewById(rbGroup.getCheckedRadioButtonId());

                Toast.makeText(MainActivity2.this, "you clicked "+ rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}