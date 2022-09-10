package com.example.fitformula;

import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

//<<<<<<< HEAD
import com.example.fitformula.CustomUser.For_you;
import com.example.fitformula.Diet_Plans.Diet_Plans;
import com.example.fitformula.Onboarding.AccountLogin;
import com.example.fitformula.Onboarding.DBHelper;
//=======
//>>>>>>> 655cf670de911c6abfa298723deebc146c9a66ba
import com.example.fitformula.Session.SessionManager;
import com.example.fitformula.Settings.Settings;
import com.example.fitformula.Workout_Plans.WorkoutPlans;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.Objects;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout dl_1;
    NavigationView nv_1;
    Toolbar tb_1;
    LinearLayout LL_1, LL_2, LL_3;
    SliderView home_slider;
    DBHelper myDB;
    SharedPreferences sp;
    String email, username;
    Long icon;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*--------------------Display Username--------------------*/
        sessionManager = new SessionManager(getApplicationContext());
        email = sessionManager.getEmail();
        displayUsername();

        /*--------------------Hooks--------------------*/
        dl_1 = findViewById(R.id.dl_Home);
        nv_1 = findViewById(R.id.nv_Home);
        tb_1 = findViewById(R.id.tb_Home);
        LL_1 = findViewById(R.id.LL_Home_Workouts);
        LL_2 = findViewById(R.id.LL_Home_Diets);
        LL_3 = findViewById(R.id.LL_Home_Rewards);
        home_slider = findViewById(R.id.Home_Slider);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_1);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Welcome, " + username);

        /*--------------------Navigation Drawer Menu--------------------*/
        nv_1.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl_1, tb_1, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl_1.addDrawerListener(toggle);
        toggle.syncState();

        nv_1.setNavigationItemSelectedListener(this);

        /*--------------------Image Slider--------------------*/
        int[] slider_images =
        {
            R.drawable.home_slider_01,
            R.drawable.home_slider_03,
            R.drawable.home_slider_04
        };

        HomeSliderAdapter sliderAdapter = new HomeSliderAdapter(slider_images);
        home_slider.setSliderAdapter(sliderAdapter);
        home_slider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        home_slider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        home_slider.startAutoCycle();

        /*--------------------On-click Listeners--------------------*/
        LL_1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent(Home.this, WorkoutPlans.class);
                startActivity(intent1);
            }
        });

        LL_2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent(Home.this, Diet_Plans.class);
                startActivity(intent2);
            }
        });

        LL_3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Intent intent3 = new Intent(Home.this, RewardsStoreHome.class);
//                startActivity(intent3);
            }
        });
    }

    public void displayUsername() {
        /*--------------------Get Name--------------------*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv_Home);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.tv_Header_Name);
        ImageView navIcon = (ImageView) headerView.findViewById(R.id.tv_Header_Profile);

        myDB = new DBHelper(Home.this);
        Cursor c = myDB.getUsername(email);
        Cursor c2 = myDB.getIcon(email);

        if (c.moveToFirst()) {
            username = c.getString(0);
            navUsername.setText(username);
        }

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

        sessionManager.setUser(username);
    }

    @Override
    public void onBackPressed() {

        if(dl_1.isDrawerOpen(GravityCompat.START))
        {
            dl_1.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menu(menuItem);
        return true;
    }

    public void menu(MenuItem itemMenu)
    {
        switch (itemMenu.getItemId()) {
            case R.id.nv_Menu_Home:
                Intent intent_home = new Intent(Home.this,Home.class);
                intent_home.putExtra("keyemail",email);
                startActivity(intent_home);
                finish();
                break;
            case R.id.nv_Menu_Workout:
                Intent intent_workout = new Intent(Home.this, WorkoutPlans.class);
                startActivity(intent_workout);
                break;
            case R.id.nv_Menu_Diet:
                Intent intent_diet = new Intent(Home.this, Diet_Plans.class);
                startActivity(intent_diet);
                break;
            case R.id.nv_Menu_Logout:
                sessionManager.setLogin(false);
                sessionManager.setEmail("");
                Intent intent_logout = new Intent(Home.this, AccountLogin.class);
                startActivity(intent_logout);
                finish();
                break;
//            case R.id.nv_Menu_Rewards:
//                Intent intent_rewards = new Intent(Home.this, RewardsStoreHome.class);
//                startActivity(intent_rewards);
//                break;
//            case R.id.nv_Menu_Orders:
//                Intent intent_my_orders = new Intent(Home.this, MyOrders.class);
//                startActivity(intent_my_orders);
//                break;
            case R.id.nv_Menu_Settings:
                Intent intent_my_settings = new Intent(Home.this, Settings.class);
                startActivity(intent_my_settings);
                break;
            case R.id.nv_Menu_ForYou:
                Intent intent_fyp = new Intent(Home.this, For_you.class);
                startActivity(intent_fyp);
                break;
        }
    }

    public void onClick(View view) {
        Intent intent_fyp = new Intent(Home.this, For_you.class);
        startActivity(intent_fyp);
    }
}
