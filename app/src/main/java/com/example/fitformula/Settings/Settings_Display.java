package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fitformula.R;

import java.util.Objects;

public class Settings_Display extends AppCompatActivity {
    Toolbar tb_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_display);

        /*--------------------Hooks--------------------*/
        tb_Display = findViewById(R.id.tb_Settings_Display);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_Display);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Display Settings");
    }
}