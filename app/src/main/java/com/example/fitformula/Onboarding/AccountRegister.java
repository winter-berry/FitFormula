package com.example.fitformula.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitformula.R;
import com.example.fitformula.Session.SessionManager;

public class AccountRegister extends AppCompatActivity {

    EditText email,password,repassword;
    Button btnSignUp,btnHaveAccount;
    DBHelper myDB;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_register);

        sessionManager = new SessionManager(getApplicationContext());

        /*--------------------Hooks--------------------*/
        email = (EditText)findViewById(R.id.tb_Register_Email);
        password = (EditText)findViewById(R.id.tb_Register_Password);
        repassword = (EditText)findViewById(R.id.tb_Register_Repass);
        btnSignUp = (Button)findViewById(R.id.btnRegister);
        btnHaveAccount = (Button)findViewById(R.id.btn_Register_HaveAccount);

        //btnHaveAccount.setPaintFlags(btnHaveAccount.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        myDB = new DBHelper(this);

        /*--------------------Sign Up Button Listener--------------------*/
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_add = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (email_add.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(AccountRegister.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email_add).matches()) {
                        Toast.makeText(AccountRegister.this,"Invalid Email Address",Toast.LENGTH_SHORT).show();
                    }
                    else if (pass.equals(repass))
                    {
                        Boolean usercheckResult = myDB.checkEmail(email_add);
                        if (usercheckResult == false)
                        {
                            Boolean regResult = myDB.insertData(email_add,pass);
                            if (regResult == true){
                                sessionManager.setLogin(true);
                                sessionManager.setEmail(email_add);
                                Toast.makeText(AccountRegister.this, "Registration success", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),CreateProfile.class);
                                intent.putExtra("keyname",email_add);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(AccountRegister.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(AccountRegister.this, "Account already exists, please sign in", Toast.LENGTH_SHORT).show();
                        }


                    }
                    else
                    {
                        Toast.makeText(AccountRegister.this, "Passwords did not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        /*--------------------Have Account Button Listener--------------------*/
        btnHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AccountLogin.class);
                startActivity(intent);
            }
        });
    }
}
