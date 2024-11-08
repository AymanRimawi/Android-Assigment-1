package com.example.project1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {
    ImageView Details_img;
    TextView PracticeName_txt, round_txt, Count_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        Details_img = findViewById(R.id.Details_img);
        PracticeName_txt = findViewById(R.id.PracticeName_txt);
        round_txt = findViewById(R.id.round_txt);
        Count_txt = findViewById(R.id.Count_txt);


        System.out.println((int) MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().get(getIntent().getIntExtra("position", 0)).getImadeID());
        Details_img.setImageResource((int) MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().get(getIntent().getIntExtra("position", 0)).getImadeID());
        PracticeName_txt.setText(MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().get(getIntent().getIntExtra("position", 0)).getName());
        round_txt.setText(MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().get(getIntent().getIntExtra("position", 0)).getRounds());
        Count_txt.setText(String.valueOf(MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays().getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices().get(getIntent().getIntExtra("position", 0)).getCountperRound()));

    }


}
