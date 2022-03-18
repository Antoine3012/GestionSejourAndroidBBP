package com.example.sejourbbp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sejourbbp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView erreur;


    private List<Patient> listpatients = new ArrayList<>();
    private ArrayAdapter<Patient> listViewAdapter;

    private ActivityMainBinding binding;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        token = intent.getStringExtra("token");
        setContentView(R.layout.fragment_home);
        // Get ListView object from xml
        // Initializing a new String Array

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.24:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Patient>> call = jsonPlaceHolderApi.getPatients("application/json", this.token);

        call.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                if(!response.isSuccessful()){
                    erreur = findViewById(R.id.textView);
//                    A voir pourquoi ce n'est pas successful
                      erreur.setText("Code: "+ response.code());
////                    this.listView
                    return;
                }

                List<Patient> patients = response.body();

            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                erreur = findViewById(R.id.textView);
                erreur.setText(t.getMessage());
            }
        });
    }


}