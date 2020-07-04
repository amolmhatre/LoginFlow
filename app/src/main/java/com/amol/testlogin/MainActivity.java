package com.amol.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by amolmhatre on 7/4/20
 */

public class MainActivity extends AppCompatActivity {

    String TAG = "com.amol.testlogin/MainActivity";
    EditText etUsername,etPassword;
    CheckBox checkRememberMe;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("MySharedPreference", Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("preference",false)){
            Login(sharedPreferences.getString("username","amol!"), sharedPreferences.getString("password","1234!"));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        checkRememberMe = (CheckBox)findViewById(R.id.checkRememberMe);
    }

    public void LoginButton(View view){
        /**Checking if user have selected Remember me option*/
        if (checkRememberMe.isChecked())
            saveUserCredentials();
        Login(etUsername.getText().toString(), etPassword.getText().toString());
    }

    private void Login(String username, String password){
        if("amol".equals(username) && "1234".equals(password)){
            /** Starting new actiity */
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            intent.putExtra("root","toor"); /**We are adding this security feature to prevent backdoor entry to homepage*/
            intent.putExtra("username","amol mhatre");
            startActivity(intent);
        } else {
            Toast.makeText(this,"Wrong Credentials", Toast.LENGTH_LONG).show();
        }
    }
    private void saveUserCredentials(){
        /**Check if user have checked remember me box. If yes, store details in shared preferences*/
            Log.d(TAG,"User details saved to shared preference");
            MySharedPreference mySharedPreference = new MySharedPreference(this);
            mySharedPreference.setSharedPreferences(etUsername.getText().toString(),etPassword.getText().toString(),true);
    }
}