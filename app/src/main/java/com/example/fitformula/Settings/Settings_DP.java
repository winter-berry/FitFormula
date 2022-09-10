package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.fitformula.R;

import java.util.Objects;

public class Settings_DP extends AppCompatActivity {
    Toolbar tb_dataPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_dp);

        /*--------------------Hooks--------------------*/
        tb_dataPrivacy = findViewById(R.id.tb_DataPrivacy);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_dataPrivacy);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Data & Privacy");
    }
}