package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientActivity extends AppCompatActivity {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.24:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final ApiAsker apiAsker = retrofit.create(ApiAsker.class);
    private String token;
    private List<Patient> patientList = new ArrayList<>();
    private PatientAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        token += this.getIntent().getStringExtra("token");
        // LISTE DES PATIENTS
        ListView lstPatients = findViewById(R.id.lstPatient);
        Call<List<Patient>> call = apiAsker.getPatients("application/json", token);
        call.enqueue(new Callback<List<Patient>>() {
            @Override
            public void onResponse(Call<List<Patient>> call, Response<List<Patient>> response) {
                patientList = response.body();
                Log.e("check", patientList.toString());

                listViewAdapter = new PatientAdapter(PatientActivity.this, R.layout.activity_item, patientList);

                lstPatients.setAdapter(listViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {

            }
        });


        // BOUTON DECONNEXION
        Button btnDeco = findViewById(R.id.btndecop);
        Intent intentLogin = new Intent(PatientActivity.this, LoginActivity.class);

        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentLogin);
            }
        });

        // BOUTON RETOUR
        //Bouton Liste Patient
        Button btnRetourPatient = findViewById(R.id.btnretourp);
        btnRetourPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}