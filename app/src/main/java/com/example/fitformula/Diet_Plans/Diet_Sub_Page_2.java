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

public class Diet_Sub_Page_2 extends AppCompatActivity {
    DrawerLayout dl_4;
    NavigationView nv_4;
    Toolbar tb_4;
    Button btnmain2;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_sub_page2);

        /*--------------------Hooks--------------------*/
        dl_4 = findViewById(R.id.dl_Diet_Plans_SubPage2);
        nv_4 = findViewById(R.id.nv_DietPlans_SubPage2);
        tb_4 = findViewById(R.id.tb_DietPlans_SubPage2);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_4);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet Plans");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*--------------------Button-----------------*/
        btnmain2 = (Button) findViewById(R.id.btnMain2);
        btnmain2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainPage1();
            }
        });
    }

    public void openMainPage1(){
        Intent intent = new Intent(this, Diet_Plans.class);
        startActivity(intent);
    }
}
