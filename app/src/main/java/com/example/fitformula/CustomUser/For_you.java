package com.example.fitformula.CustomUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitformula.Diet_Plans.Diet_Plans;
import com.example.fitformula.Home;
import com.example.fitformula.Onboarding.AccountLogin;
import com.example.fitformula.Onboarding.DBHelper;
import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;
import com.example.fitformula.Settings.Settings;
import com.example.fitformula.Workout_Plans.WorkoutPlans;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class For_you extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar tb_1;
    DrawerLayout dl_1;
    NavigationView nv_1;
    SessionManager sessionManager;
    ImageView iv_icon;
    TextView tv_name, tv_weight, tv_height;
    DBHelper myDB;
    String email;
    Long icon;
    float weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_you);

        /*--------------------Hooks--------------------*/
        tb_1 = findViewById(R.id.tb_fyp);
        nv_1 = findViewById(R.id.nv_fyp);
        dl_1 = findViewById(R.id.dl_fyp);
        iv_icon = findViewById(R.id.iv_fyp_icon);
        tv_name = findViewById(R.id.tv_fyp_name);
        tv_weight = findViewById(R.id.tv_Weight);
        tv_height = findViewById(R.id.tv_Height);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("For You");

        /*--------------------Navigation Drawer Menu--------------------*/
        nv_1.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl_1, tb_1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl_1.addDrawerListener(toggle);
        toggle.syncState();
        nv_1.setNavigationItemSelectedListener(this);

        /*--------------------Display Username (Menu)--------------------*/
        sessionManager = new SessionManager(getApplicationContext());
        String user = sessionManager.getUser();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_fyp);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.tv_Header_Name);
        navUsername.setText(user);
        tv_name.setText(user);

        /*--------------------Display Icon (Menu)--------------------*/
        email = sessionManager.getEmail();
        ImageView navIcon = (ImageView) headerView.findViewById(R.id.tv_Header_Profile);
        myDB = new DBHelper(For_you.this);
        Cursor c2 = myDB.getIcon(email);

        if (c2.moveToFirst()) {
            icon = c2.getLong(0);

            if(icon == 1) {
                navIcon.setImageResource(R.drawable.ic_31_man);
                iv_icon.setImageResource(R.drawable.ic_31_man);
            }
            else if (icon == 2) {
                navIcon.setImageResource(R.drawable.ic__32_man);
                iv_icon.setImageResource(R.drawable.ic__32_man);
            }
            else if (icon == 3) {
                navIcon.setImageResource(R.drawable.ic_69_woman);
                iv_icon.setImageResource(R.drawable.ic_69_woman);
            }
            else if (icon == 4) {
                navIcon.setImageResource(R.drawable.ic__68_woman);
                iv_icon.setImageResource(R.drawable.ic__68_woman);
            }
            else {
                navIcon.setImageResource(R.drawable.blank_profile_picture);
                iv_icon.setImageResource(R.drawable.ic_profile);
            }
        }

        /*--------------------Get Weight--------------------*/
        Cursor c3 = myDB.getWeight(email);
        if (c3.moveToFirst()) {
            weight = c3.getFloat(0);
            String strweight = Float.toString(weight);
            tv_weight.setText("Weight: " + strweight);
        }

        /*--------------------Get Height--------------------*/
        Cursor c4 = myDB.getHeight(email);
        if (c4.moveToFirst()) {
            height = c4.getFloat(0);
            String strheight = Float.toString(height);
            tv_height.setText("Height: " + strheight);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nv_Menu_Home:
                Intent intent_home = new Intent(For_you.this, Home.class);
                startActivity(intent_home);
                finish();
                break;
            case R.id.nv_Menu_Workout:
                Intent intent_workout = new Intent(For_you.this, WorkoutPlans.class);
                startActivity(intent_workout);
                break;
            case R.id.nv_Menu_Diet:
                Intent intent_diet = new Intent(For_you.this, Diet_Plans.class);
                startActivity(intent_diet);
                break;
            case R.id.nv_Menu_Logout:
                sessionManager.setLogin(false);
                sessionManager.setEmail("");
                Intent intent_logout = new Intent(For_you.this, AccountLogin.class);
                startActivity(intent_logout);
                finish();
                break;
//            case R.id.nv_Menu_Rewards:
//                Intent intent_rewards = new Intent(for_you.this, RewardsStoreHome.class);
//                startActivity(intent_rewards);
//                break;
//            case R.id.nv_Menu_Orders:
//                Intent intent_my_orders = new Intent(for_you.this, MyOrders.class);
//                startActivity(intent_my_orders);
//                break;
            case R.id.nv_Menu_Settings:
                Intent intent_my_settings = new Intent(For_you.this, Settings.class);
                startActivity(intent_my_settings);
                break;
            case R.id.nv_Menu_ForYou:
                Intent intent_fyp = new Intent(For_you.this, For_you.class);
                startActivity(intent_fyp);
                break;
        }
        return true;
    }

    public void onClick(View view) {
        Intent intent_fyp = new Intent(For_you.this, WorkoutPlans.class);
        startActivity(intent_fyp);
        finish();
    }
}