package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Signup_bt, Login_bt;
    EditText Password_edt, Username_edt;
    static Accounts accounts = new Accounts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Signup_bt = findViewById(R.id.Signup_bt);
        Login_bt = findViewById(R.id.Login_bt);
        Password_edt = findViewById(R.id.Password_edt);
        Username_edt = findViewById(R.id.Username_edt);
        Signup_bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, signupActivity.class);
                startActivity(intent);

            }
        });

        Login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (accounts.FoundByUsername(Username_edt.getText().toString()) != null) {
                    if (accounts.FoundByUsername(Username_edt.getText().toString()).getPassword().equals(Password_edt.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, DaysActivity.class);
                        intent.putExtra("username",Username_edt.getText().toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Username not found", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}