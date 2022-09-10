package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;


public class WorkoutPlans_Subpage extends AppCompatActivity {

    DrawerLayout dl_3;
    private Toolbar tb_1;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_subpage);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_WorkoutPlans_SubPage);
        Toolbar tb_1 = findViewById(R.id.tb_WorkoutPlansSubpage);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        getSupportActionBar().setTitle("Core Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void LL_WorkoutPlans_SubPage_01( View view ) {
        Intent intent_logout = new Intent(WorkoutPlans_Subpage.this, WorkoutPlans_Core_Workout_1.class);
        startActivity(intent_logout);
    }
}
