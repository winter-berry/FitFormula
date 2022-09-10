package com.example.fitformula.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitformula.Home;
import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;

public class AccountLogin extends AppCompatActivity {
    EditText email,password;
    Button btnLogin, btnNoAccount;
    String email_add;
    DBHelper myDB;
    SessionManager sessionManager;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);

        /*--------------------Hooks--------------------*/
        email = (EditText)findViewById(R.id.tb_Login_Email);
        password = (EditText)findViewById(R.id.tb_Login_Password);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnNoAccount = (Button)findViewById(R.id.btnNoAccount);

        myDB = new DBHelper(this);
        sessionManager = new SessionManager(getApplicationContext());

//        if (sessionManager.getLogin()) {
//            Intent intent = new Intent(getApplicationContext(), Home.class);
//            startActivity(intent);
//            finish();
//        }

        /*--------------------Login Button Listener--------------------*/
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_add = email.getText().toString();
                String pass = password.getText().toString();

                if(email_add.equals("") || pass.equals("")){
                    Toast.makeText(AccountLogin.this, "Please enter your credentials", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkEmailPassword(email_add,pass);
                    if (result==true){
                        //Session
                        sessionManager.setLogin(true);
                        sessionManager.setEmail(email_add);

                        //Move to Home page
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("keyemail",email_add);
                        startActivity(intent);
                        Toast.makeText(AccountLogin.this, "Login success", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else{
                        Toast.makeText(AccountLogin.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /*--------------------No Account Button Listener--------------------*/
        btnNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AccountRegister.class);
                startActivity(intent);
            }
        });
    }

}