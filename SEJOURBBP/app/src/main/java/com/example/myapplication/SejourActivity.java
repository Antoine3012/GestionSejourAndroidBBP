package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.login.LoginActivity;

public class SejourActivity extends AppCompatActivity {

    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        token = this.getIntent().getStringExtra("token");
        setContentView(R.layout.activity_sejour);
        TextView txtLogin = findViewById(R.id.btnLogin);
        String login = this.getIntent().getStringExtra("login");
        txtLogin.setText(login);
        token = this.getIntent().getStringExtra("token");
        setContentView(R.layout.activity_sejour);



        Button btnDeco = findViewById(R.id.btnDeconnexion);
        Intent intentLogin = new Intent(SejourActivity.this, LoginActivity.class);
        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentLogin);
            }
        });
        

        //Bouton En cours
        Button btnEnCours = findViewById(R.id.btnEnCours);
        btnEnCours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SejourActivity.this, ListeSejourActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("login", login);
                startActivity(intent);
            }
        });

        //Bouton A Venir
        Button btnAVenir = findViewById(R.id.btnAVenir);
        Intent intent2 = new Intent(SejourActivity.this, ListeSejourActivity.class);
        btnAVenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

        //Bouton DebutantCeJour
        Button btnDebutantCeJour = findViewById(R.id.btnDebutantCeJour);
        Intent intent3 = new Intent(SejourActivity.this, ListeSejourActivity.class);
        btnDebutantCeJour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

        //Bouton DatePrecise
        Button btnDatePrecise = findViewById(R.id.btnDatePrecise);
        Intent intent4 = new Intent(SejourActivity.this, SejourDateActivity.class);
        btnDatePrecise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });

        //Bouton Patients
        Button btnSejourPatient = findViewById(R.id.btnSejourPatient);
        Intent intent5 = new Intent(SejourActivity.this, SejourPatientActivity.class);
        btnSejourPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent5);
            }
        });

        //Bouton Archives
        Button btnArchiveSejour = findViewById(R.id.btnArchiveSejour);
        Intent intent6 = new Intent(SejourActivity.this, ListeSejourActivity.class);
        btnArchiveSejour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent6);
            }
        });

        //Bouton Liste Patient
        Button btnListePatient = findViewById(R.id.btnlstpatient);
        Intent intent7 = new Intent(SejourActivity.this, PatientActivity.class);
        btnListePatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent7.putExtra("token", token);
                startActivity(intent7);
            }
        });
    }
}