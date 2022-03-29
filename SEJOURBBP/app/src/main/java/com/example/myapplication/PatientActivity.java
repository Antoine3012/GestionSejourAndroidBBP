package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.ui.login.LoginActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientActivity extends AppCompatActivity {
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.24:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final ApiAsker apiAsker = retrofit.create(ApiAsker.class);
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        // LISTE DES PATIENTS
        ListView lstPatients = findViewById(R.id.lstPatient);
        Call<List<Patient>> call = apiAsker.getPatients("application/json", token);


        // BOUTON DECONNEXION
        Button btnDeco = findViewById(R.id.btndecop);
        Intent intentLogin = new Intent(PatientActivity.this, LoginActivity.class);

        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentLogin);
            }
        });
    }
}