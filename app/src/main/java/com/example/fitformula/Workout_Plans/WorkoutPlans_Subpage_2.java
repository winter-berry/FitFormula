package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;

public class WorkoutPlans_Subpage_2 extends AppCompatActivity {

    DrawerLayout dl_3;
    private Toolbar tb_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_subpage2);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_WorkoutPlans_SubPage2);
        Toolbar tb_1 = findViewById(R.id.tb_WorkoutPlansSubpage2);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        getSupportActionBar().setTitle("Leg Day Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void LL_WorkoutPlans_SubPage2_01( View view ) {
        Intent intent1 = new Intent(WorkoutPlans_Subpage_2.this, WorkoutPlans_Leg_Day_Workout_1.class);
        startActivity(intent1);
    }

}
