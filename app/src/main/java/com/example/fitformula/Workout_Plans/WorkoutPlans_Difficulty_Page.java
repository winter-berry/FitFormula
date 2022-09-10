package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitformula.R;

public class WorkoutPlans_Difficulty_Page extends AppCompatActivity {

    Button btnBeginner;
    Button btnMedium;
    Button btnAdvanced;
    Button btnSkip;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_difficulty_page);

        btnBeginner = (Button) findViewById(R.id.btnBeginner);
        btnMedium= (Button) findViewById(R.id.btnMedium);
        btnAdvanced = (Button) findViewById(R.id.btnAdvanced);
        btnSkip = (Button) findViewById(R.id.skip_button);

        btnBeginner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openIntensity();
            }
        });
        btnMedium.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openIntensity();
            }
        });
        btnAdvanced.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openIntensity();
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) { openMainWorkoutPage();}
        });
    }

    public void openIntensity(){
        Intent intent = new Intent(this, WorkoutPlans_Intensity_Page.class);
        startActivity(intent);
    }
    public void openMainWorkoutPage(){
        Intent intent = new Intent(this, WorkoutPlans.class);
        startActivity(intent);
    }
}
