package com.example.fitformula.Workout_Plans;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;

public class WorkoutPlans_Amputees_Special_Workouts_1 extends AppCompatActivity {

    DrawerLayout dl_3;
    private Toolbar tb_1;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_amputees_special_workouts1);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_WorkoutPlans_Amputees_Special_Workouts_1);
        Toolbar tb_1 = findViewById(R.id.tb_WorkoutPlans_Amputees_Special_Plan_1);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        getSupportActionBar().setTitle("Amputees Special Workout Plan 1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}