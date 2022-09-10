package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.fitformula.R;

import java.util.Objects;

public class Settings_ContactUs extends AppCompatActivity {
    Toolbar tb_contactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_contact_us);

        /*--------------------Hooks--------------------*/
        tb_contactUs = findViewById(R.id.tb_contactUs);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_contactUs);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Contact Us");
    }
}