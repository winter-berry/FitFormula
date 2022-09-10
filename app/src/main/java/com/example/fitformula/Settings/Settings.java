package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fitformula.Home;
import com.example.fitformula.R;

import java.util.Objects;


public class Settings extends AppCompatActivity {

    Toolbar tb_settings;
    LinearLayout LL_editProfile, LL_display, LL_notifications,
                LL_dataPrivacy, LL_helpSupport, LL_contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        /*--------------------Hooks--------------------*/
        tb_settings = findViewById(R.id.tb_Settings);
        LL_editProfile = findViewById(R.id.LL_EditProfile);
        LL_display = findViewById(R.id.LL_Display);
        LL_notifications = findViewById(R.id.LL_Notifications);
        LL_dataPrivacy = findViewById(R.id.LL_DataPrivacy);
        LL_helpSupport = findViewById(R.id.LL_HelpSupport);
        LL_contact = findViewById(R.id.LL_Contact);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_settings);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Settings");

        /*--------------------Listeners--------------------*/
        LL_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_editProfile = new Intent(getApplicationContext(),Settings_EditProfile.class);
                startActivity(intent_editProfile);
            }
        });

        LL_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_display = new Intent(getApplicationContext(),Settings_Display.class);
                startActivity(intent_display);
            }
        });

        LL_notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_notifications = new Intent(getApplicationContext(),Settings_Notifications.class);
                startActivity(intent_notifications);
            }
        });

        LL_dataPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_dp = new Intent(getApplicationContext(),Settings_DP.class);
                startActivity(intent_dp);
            }
        });

        LL_helpSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_hs = new Intent(getApplicationContext(),Settings_HS.class);
                startActivity(intent_hs);
            }
        });

        LL_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_contactus = new Intent(getApplicationContext(),Settings_ContactUs.class);
                startActivity(intent_contactus);
            }
        });
    }
}