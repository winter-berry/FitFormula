package com.example.fitformula.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fitformula.Onboarding.DBHelper;
import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;

import java.util.Objects;

public class Settings_EditProfile extends AppCompatActivity {
    EditText et_editname,et_editheight,et_editweight;
    Button btn_editprofile;
    DBHelper myDB;
    String email;
    SessionManager sessionManager;
    Toolbar tb_EP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_edit_profile);

        /*--------------------Hooks--------------------*/
        et_editname = (EditText) findViewById(R.id.et_editname);
        et_editheight = (EditText) findViewById(R.id.et_editheight);
        et_editweight = (EditText) findViewById(R.id.et_editweight);
        btn_editprofile = (Button) findViewById(R.id.btn_editprofile);
        tb_EP = findViewById(R.id.tb_EP);

        /*--------------------Tool Bar--------------------*/
        setSupportActionBar(tb_EP);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit Profile");

        /*--------------------Listeners--------------------*/
        btn_editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager = new SessionManager(getApplicationContext());
                email = sessionManager.getEmail();

                if (TextUtils.isEmpty(et_editname.getText()) || TextUtils.isEmpty(et_editweight.getText()) || TextUtils.isEmpty(et_editheight.getText()))
                {
                    Toast.makeText(Settings_EditProfile.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String user = et_editname.getText().toString();
                    double w = Double.parseDouble(et_editweight.getText().toString());
                    double h = Double.parseDouble(et_editheight.getText().toString());

                    /*--------------------Update Profile Details--------------------*/
                    myDB = new DBHelper(Settings_EditProfile.this);
                    Boolean regResult = myDB.editProfileData(email,user,w,h);
                    if (regResult){
                        Toast.makeText(Settings_EditProfile.this, "Profile updated", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Settings.class));
                    }
                    else {
                        Toast.makeText(Settings_EditProfile.this, "Update fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}