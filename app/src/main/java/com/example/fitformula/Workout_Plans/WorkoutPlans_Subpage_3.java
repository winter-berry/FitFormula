package com.example.fitformula.Workout_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;

import java.util.Objects;

public class WorkoutPlans_Subpage_3 extends AppCompatActivity {

    DrawerLayout dl_3;
    private Toolbar tb_1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans_subpage3);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_WorkoutPlans_SubPage3);
        Toolbar tb_1 = findViewById(R.id.tb_WorkoutPlansSubpage3);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upper Body Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void LL_WorkoutPlans_SubPage3_01( View view ) {
        Intent intent1 = new Intent(com.example.fitformula.Workout_Plans.WorkoutPlans_Subpage_3.this, WorkoutPlans_Upper_Body_Workout_1.class);
        startActivity(intent1);
    }
}
