package com.example.fitformula.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitformula.Onboarding.AccountRegister;
import com.example.fitformula.R;

public class GetStarted extends AppCompatActivity {

    private ImageView iv_1;
    private TextView tv_1, tv_2;
    private Button btn_1;
    Animation anim_1, anim_2, anim_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        /*--------------------Hooks--------------------*/
        iv_1 = findViewById(R.id.iv_GetStarted_Splash);
        tv_1 = findViewById(R.id.tv_GetStarted_Logo);
        tv_2 = findViewById(R.id.tv_GetStarted_Caption);
        btn_1 = findViewById(R.id.btn_GetStarted);

        /*--------------------Get Animations--------------------*/
        anim_1 = AnimationUtils.loadAnimation(this, R.anim.getstarted_anim_1);
        anim_2 = AnimationUtils.loadAnimation(this, R.anim.getstarted_anim_2);
        anim_3 = AnimationUtils.loadAnimation(this, R.anim.getstarted_anim_3);

        /*--------------------Set Animations--------------------*/
        iv_1.startAnimation(anim_1);
        tv_1.startAnimation(anim_2);
        tv_2.startAnimation(anim_3);

        /*--------------------Event Listeners--------------------*/
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AccountLogin.class);
                startActivity(intent);
            }
        });
    }
}