package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;

import java.util.Objects;

public class WorkoutPlans_Subpage_4 extends AppCompatActivity {

    DrawerLayout dl_3;
    private Toolbar tb_1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_subpage4);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_WorkoutPlans_SubPage4);
        Toolbar tb_1 = findViewById(R.id.tb_WorkoutPlansSubpage4);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Yoga / Meditation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void LL_WorkoutPlans_SubPage4_01( View view ) {
        Intent intent1 = new Intent(com.example.fitformula.Workout_Plans.WorkoutPlans_Subpage_4.this, WorkoutPlans_Yoga_Workout_1.class);
        startActivity(intent1);
    }
}
