package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import android.view.View;
import android.widget.Button;

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

    private String token= "Bearer ";
    private String context;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sejour);

        token += this.getIntent().getStringExtra("token");
        context = this.getIntent().getStringExtra("context");

        ListView lstSejour = findViewById(R.id.lstviewSejour);

        //Récupération date du jour
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());

        Call<List<Sejour>> call = apiAsker.getSejours("application/json", token);
        call.enqueue(new Callback<List<Sejour>>() {
            @Override
            public void onResponse(Call<List<Sejour>> call, Response<List<Sejour>> response) {

                //En cours
                if(!response.isSuccessful()){
                    Log.e("Code ", String.valueOf(response.code()));
                    Log.e("message", response.message());
                    return;
                }else {
                sejourList = response.body();
                ArrayList<Sejour> lesSejourEnCours = new ArrayList<>();
                for(Sejour unSejour:sejourList){
                    try {
                        java.util.Date date = df.parse(formattedDate);
                        if(unSejour.getDateArrivee().compareTo(date)<=0){
                            lesSejourEnCours.add(unSejour);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                listViewAdapter = new ArrayAdapter<Sejour>(ListeSejourActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, lesSejourEnCours);

                lstSejour.setAdapter(listViewAdapter);

                //A venir
                //Ce jour
                //DatePrecise
                //Patients
                //Archives

                }
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