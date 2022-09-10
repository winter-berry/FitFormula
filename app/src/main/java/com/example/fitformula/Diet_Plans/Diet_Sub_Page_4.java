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

public class Diet_Sub_Page_4 extends AppCompatActivity {
    DrawerLayout dl_6;
    NavigationView nv_6;
    Toolbar tb_6;
    Button btnmain4;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_sub_page4);

        /*--------------------Hooks--------------------*/
        dl_6 = findViewById(R.id.dl_Diet_Plans_SubPage4);
        nv_6 = findViewById(R.id.nv_DietPlans_SubPage4);
        tb_6 = findViewById(R.id.tb_DietPlans_SubPage4);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_6);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet Plans");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*--------------------Button-----------------*/
        btnmain4 = (Button) findViewById(R.id.btnMain4);
        btnmain4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainPage3();
            }
        });
    }
   
    public void openMainPage3(){
        Intent intent = new Intent(this, Diet_Plans.class);
        startActivity(intent);
    }

}
