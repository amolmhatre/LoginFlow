package com.amol.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "testLogin";
    EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
    }

    public void Login(View view){
        if("amol".equals(etUsername.getText().toString()) && "1234".equals(etPassword.getText().toString())){
//          if (true){
            Intent intent = new Intent(getApplicationContext(),HomePage.class);
            intent.putExtra("root","toor");
            intent.putExtra("username","amol mhatre");
            startActivity(intent);
        } else {
            Toast.makeText(this,"Wrong Credentials", Toast.LENGTH_LONG).show();
        }
    }
}