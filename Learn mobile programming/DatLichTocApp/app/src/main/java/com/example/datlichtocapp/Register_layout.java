package com.example.datlichtocapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datlichtocapp.DAO.UsersDAO;
import com.example.datlichtocapp.DTO.UserDTO;

public class Register_layout extends AppCompatActivity {
    EditText eTxtUsername, eTxtPassworld, eTxtEmail;
    Button btnRegister;
    UsersDAO usersDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);
        addControl();
    }

    private void addControl() {
        eTxtUsername = findViewById(R.id.eTxtUsername);
        eTxtEmail = findViewById(R.id.eTxtEmail);
        eTxtPassworld = findViewById(R.id.eTxtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        usersDAO = new UsersDAO(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = eTxtUsername.getText().toString();
                String email = eTxtEmail.getText().toString();
                String matKhau = eTxtPassworld.getText().toString();

                UserDTO userDTO = new UserDTO( username, email, matKhau);
                usersDAO.ThemUser(userDTO);
            }
        });
    }



}