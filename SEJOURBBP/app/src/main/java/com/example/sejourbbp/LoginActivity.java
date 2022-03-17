package com.example.sejourbbp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sejourbbp.ui.Patient;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.24:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        EditText InUsername = findViewById(R.id.InUsername);
        EditText InPassword = findViewById(R.id.InPassword);
        TextView output = findViewById(R.id.outputlogin);

        Button btnConnexion = findViewById(R.id.btnConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = InUsername.getText().toString();
                String password = InPassword.getText().toString();

                Call<String> call = jsonPlaceHolderApi.getToken(username, password);

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {

                        output.setText(response.toString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        output.setText("erreur");
                    }
                });
            }
        });

    }
}