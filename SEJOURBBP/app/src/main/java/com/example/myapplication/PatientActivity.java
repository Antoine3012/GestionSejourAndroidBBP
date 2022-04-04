package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
    private static final int MENU_ITEM_EDIT=111;
    private static final int MENU_ITEM_DELETE = 222;
    private static final int MY_REQUEST_CODE = 1000;
    private final ApiAsker apiAsker = retrofit.create(ApiAsker.class);
    private String token;
    private List<Patient> patientList = new ArrayList<>();
<<<<<<< Updated upstream
    private PatientAdapter listViewAdapter;

=======
    private ArrayAdapter<Patient> listViewAdapter;
    private ListView lstPatients = findViewById(R.id.lstPatient);
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        token += this.getIntent().getStringExtra("token");
        // LISTE DES PATIENTS

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
        Button btnRetourPatient = findViewById(R.id.btnretourp);
        btnRetourPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
//    public void onCreateContextMenu(ContextMenu menu, View view,
//                                    ContextMenu.ContextMenuInfo menuInfo)    {
//
//        super.onCreateContextMenu(menu, view, menuInfo);
//        menu.setHeaderTitle("Choisir l'action");
//
//        // groupId, itemId, order, title
//        menu.add(0, MENU_ITEM_EDIT , 0, "Modifier");
//        menu.add(0, MENU_ITEM_DELETE , 1, "Supprimer");
//    }
//    public boolean onContextItemSelected(MenuItem item){
//        AdapterView.AdapterContextMenuInfo
//                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//
//        final Patient selectedPatient = (Patient) this.lstPatients.getItemAtPosition(info.position);
//
//        if(item.getItemId() == MENU_ITEM_EDIT){
//            Intent intent = new Intent(this, EditPatientActivity.class);
//            intent.putExtra("patient", selectedPatient);
//
//            // Start AddEditNoteActivity, (with feedback).
//            //this.startActivityForResult(intent,MY_REQUEST_CODE);
//        }
//        else if(item.getItemId() == MENU_ITEM_DELETE){
//            // Ask before deleting.
//            new AlertDialog.Builder(this)
//                    .setMessage(selectedPatient.getNom()+". Supprimer?")
//                    .setCancelable(false)
//                    .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            apiAsker.delPatients(selectedPatient.getId(), "application/json", token);
//                        }
//                    })
//                    .setNegativeButton("Non", null)
//                    .show();
//        }
//        else {
//            return false;
//        }
//        return true;
//    }
}