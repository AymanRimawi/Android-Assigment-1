package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class practicesActivity extends AppCompatActivity {
    TextView emptyMessage_txt;
    Button addPractice_bt ,back_bt;
    ListView practices_lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.practices);
        emptyMessage_txt = findViewById(R.id.emptyMessage_txt);
        addPractice_bt = findViewById(R.id.addPractice_bt);
        back_bt=findViewById(R.id.back_bt);
        System.out.println(getIntent().getIntExtra("day", 0));
        practices_lst = (ListView) findViewById(R.id.practices_lst);
        ArrayAdapter<practice> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, (List) MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day",0)].getPractices());
        practices_lst.setAdapter(adapter);
        if (MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().isEmpty()) {
            emptyMessage_txt.setVisibility(View.VISIBLE);
        } else {
            AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent,
                                        View view,
                                        int position,
                                        long id) {

                    Intent intent = new Intent(practicesActivity.this, DetailsActivity.class);
                    intent.putExtra("day",getIntent().getIntExtra("day",0));
                    intent.putExtra("username",getIntent().getStringExtra("username"));
                    intent.putExtra("position",position);
                    startActivity(intent);

                }
            };

            practices_lst.setOnItemClickListener(itemClickListener);
        }

        addPractice_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(practicesActivity.this, AddActivity.class);
                intent.putExtra("day",getIntent().getIntExtra("day",0));

                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
            }
        });


        back_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(practicesActivity.this, DaysActivity.class);
                intent.putExtra("username",getIntent().getStringExtra("username"));
                startActivity(intent);
            }
        });

    }
}
