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



        Button btnDeco = findViewById(R.id.btnDeconnexion);
        Intent intentLogin = new Intent(SejourActivity.this, LoginActivity.class);



        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentLogin);
            }
        });
        




    }
}