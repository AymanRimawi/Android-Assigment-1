package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddActivity extends AppCompatActivity {


    //*********************************************************************************************************************************************************************************************************
    static Map<String, Integer> availablePracticesMap = new HashMap<String, Integer>() {{
        put("Deadlift", R.drawable.deadlift);
        put("T-Bar Row", R.drawable.tbarrow);
        put("One-Leg Plank", R.drawable.onelegplank);
        put("30-Degree Lat Pulldown", R.drawable.degreelatpulldown);
        put("Pullups", R.drawable.pullups);
        put("Farmer’s Walk & Trap Bar Carry", R.drawable.farmerswalktrapbarcarry);
        put("Seated Incline Dumbbell Curl", R.drawable.seatedinclinedumbbellcurl);
        put("Standing Barbell Curl", R.drawable.standingbarbellcurl);
        put("Dips", R.drawable.dips);
        put("Diamond Pushups", R.drawable.diamondpushups);
        put("Shrugs", R.drawable.barbellshrug);
        put("Dumbbell Lateral Raises", R.drawable.dumbbelllateralraises);
        put("Rear Delt Raises", R.drawable.reardeltraises);
        put("Half-Kneeling Landmine Press", R.drawable.halfkneelinglandminepress);
        put("Barbell Bench Press", R.drawable.barbellbenchpress);
        put("Cable Crossover", R.drawable.cablecrossover);
        put("Dumbbell Bench Press", R.drawable.dumbbellbenchpress);
        put("BOSU, Puncher’s, and TRX Pushups", R.drawable.muscular);
        put("Incline Flye", R.drawable.mike);
        put("Squat", R.drawable.squat);
        put("Leg Curl", R.drawable.hamstringleg);
        put("Leg Extension", R.drawable.legsextension);
        put("Bulgarian Split Squat", R.drawable.romaniansplitsquats);
        put("Calf Raise", R.drawable.seatedcalfraise);
        put("Planks", R.drawable.plank);
        put("Barbell Ab Rollout", R.drawable.abrollout);
        put("Cable Woodchop", R.drawable.cablewoodchop);
        put("Weighted Decline Situp", R.drawable.declinecrunch);
        put("Jackknife Situp", R.drawable.jackknifesitup);
    }};
//*********************************************************************************************************************************************************************************************************


    Button Ok_bt,back2_bt;
    EditText CountperRound;
    RadioGroup radioGroup;
    Spinner PracticeType_spn;
    RadioButton selectedRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        PracticeType_spn = findViewById(R.id.PracticeType_spn);
        radioGroup = findViewById(R.id.radioGroup);
        CountperRound = findViewById(R.id.CountperRound);
        Ok_bt = findViewById(R.id.Ok_bt);
        back2_bt=findViewById(R.id.back2_bt);



        List<String> practiceNames = new ArrayList<>(availablePracticesMap.keySet());


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, practiceNames);
        PracticeType_spn.setAdapter(adapter);
System.out.println(getIntent().getIntExtra("day", 0));
        Ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() != -1) {
                    selectedRadio = findViewById(radioGroup.getCheckedRadioButtonId());

                    MainActivity.accounts.FoundByUsername(getIntent().getStringExtra("username")).getDays()
                            .getarrayOfDays()[getIntent().getIntExtra("day", 0)].getPractices()
                            .add(new practice(PracticeType_spn.getSelectedItem().toString(), selectedRadio.getText().toString(), Integer.valueOf(CountperRound.getText().toString()),availablePracticesMap.get(PracticeType_spn.getSelectedItem().toString())));
                    Intent intent= new Intent(AddActivity.this , practicesActivity.class);
                    intent.putExtra("day",getIntent().getIntExtra("day",0));
                    intent.putExtra("username",getIntent().getStringExtra("username"));
                    startActivity(intent);
                } else {
                    Toast.makeText(AddActivity.this, "you should select how many rounds", Toast.LENGTH_SHORT).show();

                }
            }
        });

        back2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, practicesActivity.class);
                intent.putExtra("day",getIntent().getIntExtra("day",0));
                intent.putExtra("username",getIntent().getStringExtra("username"));
                startActivity(intent);
            }
        });

    }


}
