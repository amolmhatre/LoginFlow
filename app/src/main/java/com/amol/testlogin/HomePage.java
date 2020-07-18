package com.amol.testlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.SearchView;
import android.widget.Toast;

import com.amol.testlogin.controller.ProductController;
import com.amol.testlogin.controller.RequestInterface;
import com.amol.testlogin.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amolmhatre on 7/4/20
 */
public class HomePage extends AppCompatActivity {

    private static final String TAG = "HomePage";
    //Retrofit model
    private ArrayList<OrderModel> list_productModel = new ArrayList<>();
    // Variables for recyclerview
    private ArrayList<String> list_productImageURL = new ArrayList<String>();
    private ArrayList<String> list_productNames = new ArrayList<String>();
    private ArrayList<String> list_productPrice = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        String passcode = extras.getString("root");
        if (!passcode.equals("toor")){ /**Checking if user accessing homepage is valid user and not a hacker*/
            finish();
        } else {
            Log.d(TAG,getString(R.string.welcome)+" "+username+" !!");
        }
        // By this time login is successfull, lets load recyclerview
        getProductResponse();
    }

    private void getProductResponse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://nirvaacls.com/bombill_pages/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface = retrofit.create(RequestInterface.class);
        Call<List<OrderModel>> call = requestInterface.getProductJson();

        call.enqueue(new Callback<List<OrderModel>>() {
            @Override
            public void onResponse(Call<List<OrderModel>> call, Response<List<OrderModel>> response) {
                list_productModel = new ArrayList<>(response.body());
                Log.d(TAG, "Success"+response.body().toString());
            }

            @Override
            public void onFailure(Call<List<OrderModel>> call, Throwable t) {
                Log.d(TAG, "Fail");
            }
        });
    }
    /**Initiate Image URLS*/
    private void initImageBitmaps(){
        Log.d(TAG, "Preparing images");
        list_productNames.add("Dry Bombill");
        list_productPrice.add("200/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/dry-bombil-fish-250x250.jpg");
        list_productNames.add("Paplet");
        list_productPrice.add("900/Kilogram");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/whole-seller-of-sea-fish-500x500.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("1000/Gram");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/five-spices.jpg");
        list_productNames.add("Kardi Sukat");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/sukat.jpg");
        list_productNames.add("Kolbi");
        list_productPrice.add("250/Bar");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Agari masla");
        list_productPrice.add("250/Other");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/download.jpg");
        list_productNames.add("Tikhat masla");
        list_productPrice.add("600/Kilogram");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/five-spices.jpg");
        list_productNames.add("chimbori");
        list_productPrice.add("200/Kilogram");
        list_productImageURL.add("http://nirvaacls.com/admin.bombill.com/vendor/Product/bangade.png");
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_productList);
        //Recyclerview adapter object
        ProductListAdapter productListAdapter = new ProductListAdapter(this,list_productImageURL, list_productNames, list_productPrice);
        // Attaching adapter to recyclerview
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

    /**Listener for menu options*/
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
        Log.d(TAG,"Current time is: "+time);
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
                        Log.d(TAG,"Welcome Back");
                    }
                }).show();

    }
}