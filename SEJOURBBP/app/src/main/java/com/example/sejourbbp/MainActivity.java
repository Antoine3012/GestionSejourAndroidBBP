package com.example.sejourbbp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sejourbbp.ui.Patient;
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


    private ListView listpatients;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        // Get ListView object from xml
        this.listpatients = (ListView) findViewById(R.id.listpatient);
        // Initializing a new String Array
        Patient[] patienttab = new Patient[] {};
        final List<Patient> patientList = new ArrayList<Patient>(Arrays.asList(patienttab));
        final ArrayAdapter<Patient> PatientAdapter= new ArrayAdapter<Patient>(this, android.R.layout.simple_list_item_1, patientList);

        // Bind des items pour l'adapter
        listpatients.setAdapter(PatientAdapter);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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

        Call<List<Patient>> call = jsonPlaceHolderApi.getPatients();

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
                for (Patient patient : patients){
//                    String content ="";
//                    content+="ID: "+ patient.getId()+ "\n";
//                    content+="Nom: "+ patient.getNom()+ "\n";
//                    content+="Prenom: "+ patient.getPrenom()+ "\n";
//                    content+="Date de naissance: "+ patient.getDatenaissance()+ "\n\n";

                    patientList.add(patient);
                }
            }

            @Override
            public void onFailure(Call<List<Patient>> call, Throwable t) {
                erreur = findViewById(R.id.textView);
                erreur.setText(t.getMessage());
            }
        });
    }


}