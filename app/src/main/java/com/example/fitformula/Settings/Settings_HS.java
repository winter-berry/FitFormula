package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.fitformula.R;

import java.util.Objects;

public class Settings_HS extends AppCompatActivity {
    Toolbar tb_support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_hs);

        /*--------------------Hooks--------------------*/
        tb_support = findViewById(R.id.tb_support);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_support);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Help & Support");
    }
}