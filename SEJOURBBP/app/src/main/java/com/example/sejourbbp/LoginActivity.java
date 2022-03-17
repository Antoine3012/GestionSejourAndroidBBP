package com.example.sejourbbp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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

//                JSONObject obj = new JSONObject();
//                try {
//                    obj.put("username", username);
//                    obj.put("password", password);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }


                Call<Object> call = jsonPlaceHolderApi.getToken("application/json", new Login(username, password));



                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        JSONObject token = new JSONObject();
                        output.setText(response.body().toString());

                        try {
                             token = new JSONObject( response.body().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        try {
                            output.setText(token.getString("token"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        try {
                            intent.putExtra("token", token.getString("token"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        output.setText(t.toString());
                    }
                });


            }
        });

    }
}