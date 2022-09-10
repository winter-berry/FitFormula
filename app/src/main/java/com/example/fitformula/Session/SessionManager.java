package com.example.fitformula.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.fitformula.Onboarding.AccountLogin;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    public static String PREF_NAME = "session";
    public static String SESSION_KEY= "session_user";


    public SessionManager (Context context){
        pref = context.getSharedPreferences(PREF_NAME, 0);
        editor = pref.edit();
        editor.apply();
    }

    //Create set login
    public void setLogin(boolean login) {
        editor.putBoolean("KEY_LOGIN", login);
        editor.commit();
    }

    //Create get login
    public boolean getLogin() {
        return pref.getBoolean("KEY_LOGIN", false);
    }

    public void setEmail(String email) {
        editor.putString("KEY_EMAIL", email);
        editor.commit();
    }

    public String getEmail() {
        return pref.getString("KEY_EMAIL", "");
    }

    public void setUser(String user) {
        editor.putString("KEY_USER", user);
        editor.commit();
    }

    public String getUser() {
        return pref.getString("KEY_USER", "");
    }

}
