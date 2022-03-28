package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.ui.login.LoginActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListeSejourActivity extends AppCompatActivity {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.24:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final ApiAsker apiAsker = retrofit.create(ApiAsker.class);

    private List<Sejour> sejourList = new ArrayList<>();
    private ArrayAdapter<Sejour> listViewAdapter;

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sejour);

        token = this.getIntent().getStringExtra("token");

        ListView lstSejour = findViewById(R.id.lstviewSejour);

        Call<List<Sejour>> call = apiAsker.getSejours("application/json", token);
        call.enqueue(new Callback<List<Sejour>>() {
            @Override
            public void onResponse(Call<List<Sejour>> call, Response<List<Sejour>> response) {
                sejourList = response.body();
                Log.e("check", sejourList.toString());

                listViewAdapter = new ArrayAdapter<Sejour>(ListeSejourActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, sejourList);

                lstSejour.setAdapter(listViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Sejour>> call, Throwable t) {

            }
        });




        //Bouton Retour
        Button btnRetour = findViewById(R.id.btnRetour);
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}