package com.example.fitformula.Diet_Plans;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.fitformula.CustomUser.For_you;
import com.example.fitformula.Home;
import com.example.fitformula.Onboarding.AccountLogin;
import com.example.fitformula.Onboarding.DBHelper;
import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;
import com.example.fitformula.Settings.Settings;
import com.example.fitformula.Workout_Plans.WorkoutPlans;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Diet_Plans extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout dl_2;
    NavigationView nv_2;
    Toolbar tb_2;
    String email;
    SessionManager sessionManager;
    DBHelper myDB;
    Long icon;

    private CardView card1, card2, card3, card4;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plans);
        /*--------------------Hooks--------------------*/
        dl_2 = findViewById(R.id.dl_Diet_Plans);
        nv_2 = findViewById(R.id.nv_DietPlans);
        tb_2 = findViewById(R.id.tb_DietPlans);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_2);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Diet Plans");

        /*--------------------Navigation Drawer Menu--------------------*/
        nv_2.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl_2, tb_2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl_2.addDrawerListener(toggle);
        toggle.syncState();
        nv_2.setNavigationItemSelectedListener(this);
        
        /*--------------Card View-----------------*/
        card1 = (CardView)findViewById(R.id.cv_DietPlans_01);
        card2 = (CardView)findViewById(R.id.cv_DietPlans_02);
        card3 = (CardView)findViewById(R.id.cv_DietPlans_03);
        card4 = (CardView)findViewById(R.id.cv_DietPlans_04);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);

        /*--------------------Display Username (Menu)--------------------*/
        sessionManager = new SessionManager(getApplicationContext());
        String user = sessionManager.getUser();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_DietPlans);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.tv_Header_Name);
        navUsername.setText(user);

        /*--------------------Display Icon (Menu)--------------------*/
        email = sessionManager.getEmail();
        ImageView navIcon = (ImageView) headerView.findViewById(R.id.tv_Header_Profile);
        myDB = new DBHelper(Diet_Plans.this);
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

        if(dl_2.isDrawerOpen(GravityCompat.START))
        {
            dl_2.closeDrawer(GravityCompat.START);
        }

        else
        {
            Intent intent_home = new Intent(Diet_Plans.this, Home.class);
            intent_home.putExtra("keyemail",email);
            startActivity(intent_home);
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nv_Menu_Home:
                Intent intent_home = new Intent(Diet_Plans.this, Home.class);
                intent_home.putExtra("keyemail",email);
                startActivity(intent_home);
                finish();
                break;
            case R.id.nv_Menu_Workout:
                Intent intent_workout = new Intent(Diet_Plans.this, WorkoutPlans.class);
                startActivity(intent_workout);
                break;
            case R.id.nv_Menu_Diet:
                Intent intent_diet = new Intent(Diet_Plans.this,Diet_Plans.class);
                startActivity(intent_diet);
                break;
            case R.id.nv_Menu_Logout:
                sessionManager.setLogin(false);
                sessionManager.setEmail("");
                Intent intent_logout = new Intent(Diet_Plans.this, AccountLogin.class);
                startActivity(intent_logout);
                finish();
                break;
//            case R.id.nv_Menu_Rewards:
//                Intent intent_rewards = new Intent(Diet_Plans.this, RewardsStoreHome.class);
//                startActivity(intent_rewards);
//                break;
//            case R.id.nv_Menu_Orders:
//                Intent intent_my_orders = new Intent(Diet_Plans.this, MyOrders.class);
//                startActivity(intent_my_orders);
//                break;
            case R.id.nv_Menu_Settings:
                Intent intent_my_settings = new Intent(Diet_Plans.this, Settings.class);
                startActivity(intent_my_settings);
                break;
            case R.id.nv_Menu_ForYou:
                Intent intent_fyp = new Intent(Diet_Plans.this, For_you.class);
                startActivity(intent_fyp);
                break;
        }
        return true;

    }

    @Override
    public void onClick( View view ) {
        Intent i;

        switch(view.getId()){
            case R.id.cv_DietPlans_01:
                i=new Intent(this,Diet_Sub_Page_1.class);
                startActivity(i);
                break;
            case R.id.cv_DietPlans_02:
                i=new Intent(this,Diet_Sub_Page_2.class);
                startActivity(i);
                break;
            case R.id.cv_DietPlans_03:
                i=new Intent(this,Diet_Sub_Page_3.class);
                startActivity(i);
                break;
            case R.id.cv_DietPlans_04:
                i=new Intent(this,Diet_Sub_Page_4.class);
                startActivity(i);
                break;


        }
    }


}
