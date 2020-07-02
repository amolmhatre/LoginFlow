package com.amol.testlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    TextView tvUsername;
    String TAG = "com.amol.testlogin/HomePage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tvUsername = findViewById(R.id.tvUsername);
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        String passcode = extras.getString("root");
        if (!passcode.equals("toor")){ /**Checking if user accessing homepahe is valid user and not a hacker*/
            finish();
        } else {
            tvUsername.setText(getString(R.string.welcome)+" "+username+" !!");
        }
    }

    /**Options on home screen*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homemenu, menu);
        /**Search bar as additional menu item*/
        SearchView searchView = (SearchView) menu.findItem(R.id.searchBar).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchQuery) {
                Log.d(TAG, searchQuery); /**This query could be use to search through DB/collection/server*/
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item selection
        switch (item.getItemId()) {
            case R.id.home:
                Toast.makeText(this,"You are at home screen", Toast.LENGTH_LONG).show();
                return true;
            case R.id.logout:
                logOutAlert();
                return true;
            case R.id.setting:
                showTimeFragment();
                return true;
            case R.id.aboutUs:
                showUpAboutUs();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**This will show a layout in toast message*/
    void showUpAboutUs(){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.show_about_us,null);
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    /** The whole purpose of this is to show time fragment*/
    void showTimeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        PopTime popTime = new PopTime();
        popTime.show(fragmentManager,"Show Fragment");
    }

    void setTime(String time){
        tvUsername.setText(time);
    }

    /**Asks for confirmation before user logs out*/
    void logOutAlert(){
        //Delete sesion token and stored user credentials
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this,R.style.AlertDialog);
        alertDialog.setTitle("Confirmation")
                .setMessage("Are you sure, you want to Logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tvUsername.setText("Welcome Back");
                    }
                }).show();

    }
}