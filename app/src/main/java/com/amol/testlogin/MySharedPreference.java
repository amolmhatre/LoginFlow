package com.amol.testlogin;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by amolmhatre on 7/4/20
 */

public class MySharedPreference {
    SharedPreferences sharedPreferences;

    public MySharedPreference(Context context) {
        this.sharedPreferences = context.getSharedPreferences("MySharedPreference",Context.MODE_PRIVATE);
    }

    public void setSharedPreferences(String username, String password, Boolean preference){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.putBoolean("preference", preference);
        editor.commit();
    }

    public SharedPreferences getSharedPreferences() {

        return sharedPreferences;
    }

}
