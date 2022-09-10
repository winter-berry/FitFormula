package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitformula.R;

public class WorkoutPlans_Intensity_Page extends AppCompatActivity {

    Button btnLow;
    Button btnIntermediate;
    Button btnHigh;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_intensity_page);

        btnLow = (Button) findViewById(R.id.btnLow);
        btnIntermediate= (Button) findViewById(R.id.btnIntermediate);
        btnHigh = (Button) findViewById(R.id.btnHigh);

        btnLow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSub();
            }
        });
        btnIntermediate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSub();
            }
        });
        btnHigh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSub();
            }
        });
    }
    public void openSub(){
        Intent intent = new Intent(this, WorkoutPlans.class);
        startActivity(intent);
    }
}