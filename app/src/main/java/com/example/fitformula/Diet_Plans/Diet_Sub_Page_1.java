package com.example.fitformula.Diet_Plans;

import android.annotation.SuppressLint;
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

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class Diet_Sub_Page_1 extends AppCompatActivity {

    DrawerLayout dl_3;
    NavigationView nv_3;
    Toolbar tb_3;
    Button btnmain1;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_sub_page1);

        /*--------------------Hooks--------------------*/
        dl_3 = findViewById(R.id.dl_Diet_Plans_SubPage1);
        nv_3 = findViewById(R.id.nv_DietPlans_SubPage1);
        tb_3 = findViewById(R.id.tb_DietPlans_SubPage1);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_3);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet Plans");


       /*--------------------Button-----------------*/
        btnmain1 = (Button) findViewById(R.id.btnMain1);
        btnmain1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainPage();
            }
        });
    }

    public void openMainPage(){
        Intent intent = new Intent(this, Diet_Plans.class);
        startActivity(intent);
    }
}
