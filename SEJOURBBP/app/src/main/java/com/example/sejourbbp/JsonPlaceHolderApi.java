package com.example.sejourbbp;

import com.example.sejourbbp.ui.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/patients")
    Call<List<Patient>> getPatients();
}
