package com.example.fitformula.Onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitformula.Home;
import com.example.fitformula.R;

public class CreateProfile extends AppCompatActivity {
    EditText username, weight, height;
    Button btnSave;
    DBHelper myDB;
    Spinner spinner;
    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        /*--------------------Hooks--------------------*/
        username = findViewById(R.id.tb_Profile_Name);
        weight = findViewById(R.id.tb_Profile_Weight);
        height = findViewById(R.id.tb_Profile_Height);
        btnSave = findViewById(R.id.btn_Create_Save);
        spinner = findViewById(R.id.spinner_Profile);
        ivIcon = findViewById(R.id.iv_Create_Profile);

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String email = getIntent().getStringExtra("keyname");
                if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(weight.getText()) || TextUtils.isEmpty(height.getText()))
                {
                    Toast.makeText(CreateProfile.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String user = username.getText().toString();
                    double w = Double.parseDouble(weight.getText().toString());
                    double h = Double.parseDouble(height.getText().toString());

                    /*--------------------Update Profile Details--------------------*/
                    Long iconId = spinner.getSelectedItemId();
                    myDB = new DBHelper(CreateProfile.this);
                    Boolean regResult = myDB.updateProfileData(email,user,w,h,0, iconId);
                    if (regResult){
                        Toast.makeText(CreateProfile.this, "Profile created", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CreateProfile.this, Home.class);
                        intent.putExtra("keyemail",email);
                        startActivity(intent);
                    }
                }

            }
        });

        /*--------------------Icon Spinner--------------------*/
        String [] icons = { "Select icon", "Man 1", "Man 2", "Woman 1", "Woman 2" };
        ArrayAdapter<String >adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, icons);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ivIcon.setImageResource(R.drawable.blank_profile_picture);
                        break;
                    case 1:
                        ivIcon.setImageResource(R.drawable.ic_31_man);
                        break;
                    case 2:
                        ivIcon.setImageResource(R.drawable.ic__32_man);
                        break;
                    case 3:
                        ivIcon.setImageResource(R.drawable.ic_69_woman);
                        break;
                    case 4:
                        ivIcon.setImageResource(R.drawable.ic__68_woman);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ivIcon.setImageResource(R.drawable.blank_profile_picture);
            }
        });
    }

}
