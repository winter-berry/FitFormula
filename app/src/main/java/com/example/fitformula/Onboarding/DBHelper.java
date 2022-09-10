package com.example.fitformula.Onboarding;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(email Text primary key,password Text, username Text, weight Real, height Real, coins Integer, icon Long)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String email,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long result = myDB.insert("users",null,contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getUsername(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c = myDB.rawQuery("select username from users where email = ?", new String[] {email});
        return c;
    }

    public Cursor getIcon(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c2 = myDB.rawQuery("select icon from users where email = ?", new String[] {email});
        return c2;
    }

    public Cursor getWeight(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c3 = myDB.rawQuery("select weight from users where email = ?", new String[] {email});
        return c3;
    }

    public Cursor getHeight(String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor c3 = myDB.rawQuery("select height from users where email = ?", new String[] {email});
        return c3;
    }

    public Boolean updateProfileData(String email, String username, double weight, double height, int coins, long icon){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("weight",weight);
        contentValues.put("height",height);
        contentValues.put("coins",coins);
        contentValues.put("icon",icon);
        Cursor c = myDB.rawQuery("Select * from users where email = ?", new String[] {email});
        if (c.getCount()>0) {
            long result = myDB.update("users", contentValues, "email=?", new String[]{email});


            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Boolean editProfileData(String email, String username, double weight, double height){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("weight",weight);
        contentValues.put("height",height);
        Cursor c = myDB.rawQuery("Select * from users where email = ?", new String[] {email});
        if (c.getCount()>0) {
            long result = myDB.update("users", contentValues, "email=?", new String[]{email});


            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Boolean checkEmail(String email)
    {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ?", new String[] {email});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email,String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from users where email = ? and password = ?", new String[] {email,password});
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
