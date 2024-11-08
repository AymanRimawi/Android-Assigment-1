package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DaysActivity extends AppCompatActivity {
Button Logout_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.days);
        Logout_bt=findViewById(R.id.Logout_bt);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {

                    Intent intent = new Intent(DaysActivity.this, practicesActivity.class);
                    intent.putExtra("day",position);
                    intent.putExtra("username",getIntent().getStringExtra("username"));
                    startActivity(intent);

            }
        };
        ListView listView = (ListView)findViewById(R.id.days_list);
        listView.setOnItemClickListener(itemClickListener);


        Logout_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaysActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });

    }
}
