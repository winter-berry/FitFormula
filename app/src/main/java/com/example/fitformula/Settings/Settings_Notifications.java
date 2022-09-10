package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.fitformula.R;

import java.util.Objects;

public class Settings_Notifications extends AppCompatActivity {
    Toolbar tb_notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_notifications);

        /*--------------------Hooks--------------------*/
        tb_notifications = findViewById(R.id.tb_notifications);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_notifications);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Custom Notifications");
    }
}