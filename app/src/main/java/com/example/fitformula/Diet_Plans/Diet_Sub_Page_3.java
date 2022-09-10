package com.example.fitformula.Diet_Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Diet_Sub_Page_3 extends AppCompatActivity {
    DrawerLayout dl_5;
    NavigationView nv_5;
    Toolbar tb_5;
    Button btnmain3;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_sub_page3);

        /*--------------------Hooks--------------------*/
        dl_5 = findViewById(R.id.dl_Diet_Plans_SubPage3);
        nv_5 = findViewById(R.id.nv_DietPlans_SubPage3);
        tb_5 = findViewById(R.id.tb_DietPlans_SubPage3);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_5);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet Plans");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*--------------------Button-----------------*/
        btnmain3 = (Button) findViewById(R.id.btnMain3);
        btnmain3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainPage2();
            }
        });
    }

    public void openMainPage2(){
        Intent intent = new Intent(this, Diet_Plans.class);
        startActivity(intent);
    }
}
