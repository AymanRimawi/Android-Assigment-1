package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupActivity extends AppCompatActivity {

    Button signup2_bt;
    EditText signup_confirmPassword_edt, signup_Password_edt, signup_Username_edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(MainActivity.accounts.getAccounts().get(0).getUsername());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        signup2_bt = findViewById(R.id.signup2_bt);
        signup_confirmPassword_edt = findViewById(R.id.signup_confirmPassword_edt);
        signup_Password_edt = findViewById(R.id.signup_Password_edt);
        signup_Username_edt = findViewById(R.id.signup_Username_edt);

        signup2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (signup_Password_edt.getText().toString().equals(signup_confirmPassword_edt.getText().toString())) {
                    MainActivity.accounts.getAccounts().add(new User(signup_Username_edt.getText().toString(), signup_Password_edt.getText().toString()));
                    Intent intent = new Intent(signupActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(signupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
