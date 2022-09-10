package com.example.fitformula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fitformula.Onboarding.GetStarted;
import com.example.fitformula.Session.SessionManager;

public class MainActivity extends AppCompatActivity {
    Handler h = new Handler();
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                SessionManager sessionManager = new SessionManager(getApplicationContext());

                if (sessionManager.getLogin()) {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent i = new Intent(MainActivity.this, GetStarted.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 2000);

    }
}