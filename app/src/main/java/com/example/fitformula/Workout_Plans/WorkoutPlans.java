package com.example.fitformula.Workout_Plans;

import static com.example.fitformula.R.id.cv_WorkoutPlans_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.CustomUser.For_you;
import com.example.fitformula.Diet_Plans.Diet_Plans;
import com.example.fitformula.Home;
import com.example.fitformula.Onboarding.AccountLogin;
import com.example.fitformula.Onboarding.DBHelper;
import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;
import com.example.fitformula.Settings.Settings;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class WorkoutPlans extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener  {

    //Variables
    DrawerLayout dl_1;
    NavigationView nv_1;
    Toolbar tb_1;
    LinearLayout LL_1, LL_2;
    SessionManager sessionManager;
    DBHelper myDB;
    String email;
    Long icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans);

        /*--------------------Hooks--------------------*/
        dl_1 = findViewById(R.id.dl_WorkoutPlans);
        nv_1 = findViewById(R.id.nv_WorkoutPlans);
        tb_1 = findViewById(R.id.tb_WorkoutPlans);
        LL_1 = findViewById(R.id.LL_WorkoutPlans_01);
        LL_2 = findViewById(R.id.LL_WorkoutPlans_02);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Workout Plans");

        /*--------------------Navigation Drawer Menu--------------------*/
        nv_1.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl_1, tb_1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl_1.addDrawerListener(toggle);
        toggle.syncState();
        nv_1.setNavigationItemSelectedListener(this);

        /*--------------Card View-----------------*/
        CardView set1 = findViewById(cv_WorkoutPlans_01);
        CardView set2 = findViewById(R.id.cv_WorkoutPlans_02);
        CardView set3 = findViewById(R.id.cv_WorkoutPlans_03);
        CardView set4 = findViewById(R.id.cv_WorkoutPlans_04);
        CardView set5 = findViewById(R.id.cv_WorkoutPlans_05);

        set1.setOnClickListener(this);
        set2.setOnClickListener(this);
        set3.setOnClickListener(this);
        set4.setOnClickListener(this);
        set5.setOnClickListener(this);

        /*--------------------Display Username (Menu)--------------------*/
        sessionManager = new SessionManager(getApplicationContext());
        String user = sessionManager.getUser();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_WorkoutPlans);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.tv_Header_Name);
        navUsername.setText(user);

        /*--------------------Display Icon (Menu)--------------------*/
        email = sessionManager.getEmail();
        ImageView navIcon = (ImageView) headerView.findViewById(R.id.tv_Header_Profile);
        myDB = new DBHelper(WorkoutPlans.this);
        Cursor c2 = myDB.getIcon(email);

        if (c2.moveToFirst()) {
            icon = c2.getLong(0);

            if(icon == 1) {
                navIcon.setImageResource(R.drawable.ic_31_man);
            }
            else if (icon == 2) {
                navIcon.setImageResource(R.drawable.ic__32_man);
            }
            else if (icon == 3) {
                navIcon.setImageResource(R.drawable.ic_69_woman);
            }
            else if (icon == 4) {
                navIcon.setImageResource(R.drawable.ic__68_woman);
            }
            else {
                navIcon.setImageResource(R.drawable.blank_profile_picture);
            }
        }
    }

    @Override
    public void onBackPressed() {

        if(dl_1.isDrawerOpen(GravityCompat.START))
        {
            dl_1.closeDrawer(GravityCompat.START);
        }

        else
        {
            Intent intent_home = new Intent(WorkoutPlans.this, Home.class);
            intent_home.putExtra("keyemail",email);
            startActivity(intent_home);
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nv_Menu_Home:
                Intent intent_home = new Intent(WorkoutPlans.this, Home.class);
                intent_home.putExtra("keyemail",email);
                startActivity(intent_home);
                finish();
                break;
            case R.id.nv_Menu_Workout:
                Intent intent_workout = new Intent(WorkoutPlans.this, WorkoutPlans.class);
                startActivity(intent_workout);
                finish();
                break;
            case R.id.nv_Menu_Diet:
                Intent intent_diet = new Intent(WorkoutPlans.this, Diet_Plans.class);
                startActivity(intent_diet);
                finish();
                break;
            case R.id.nv_Menu_Logout:
                sessionManager.setLogin(false);
                sessionManager.setEmail("");
                Intent intent_logout = new Intent(WorkoutPlans.this, AccountLogin.class);
                startActivity(intent_logout);
                finish();
                break;
//            case R.id.nv_Menu_Rewards:
//                Intent intent_rewards = new Intent(WorkoutPlans.this, RewardsStoreHome.class);
//                startActivity(intent_rewards);
//                finish();
//                break;
//            case R.id.nv_Menu_Orders:
//                Intent intent_my_orders = new Intent(WorkoutPlans.this, MyOrders.class);
//                startActivity(intent_my_orders);
//                finish();
//                break;
            case R.id.nv_Menu_Settings:
                Intent intent_my_settings = new Intent(WorkoutPlans.this, Settings.class);
                startActivity(intent_my_settings);
                finish();
                break;
            case R.id.nv_Menu_ForYou:
                Intent intent_fyp = new Intent(WorkoutPlans.this, For_you.class);
                startActivity(intent_fyp);
                finish();
                break;
        }
        return true;
    }

    public void LL_WorkoutPlans_01( View view) {
        Intent intent_logout = new Intent(WorkoutPlans.this, WorkoutPlans_Subpage.class);
        startActivity(intent_logout);
    }

    @Override
    public void onClick( View view ) {
        Intent i;

        switch(view.getId()) {
            case R.id.cv_WorkoutPlans_01:
                i = new Intent(this, WorkoutPlans_Subpage.class);
                startActivity(i);
                break;
            case R.id.cv_WorkoutPlans_02:
                i = new Intent(this, WorkoutPlans_Subpage_2.class);
                startActivity(i);
                break;
            case R.id.cv_WorkoutPlans_03:
                i = new Intent(this, WorkoutPlans_Subpage_3.class);
                startActivity(i);
                break;
            case R.id.cv_WorkoutPlans_04:
                i = new Intent(this, WorkoutPlans_Subpage_4.class);
                startActivity(i);
                break;
            case R.id.cv_WorkoutPlans_05:
                i = new Intent(this, WorkoutPlans_Subpage_5.class);
                startActivity(i);
                break;
        }
    }
}
