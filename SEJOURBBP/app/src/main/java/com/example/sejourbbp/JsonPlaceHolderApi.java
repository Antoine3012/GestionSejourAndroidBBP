package com.example.sejourbbp;

import com.example.sejourbbp.ui.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/patients")
    Call<List<Patient>> getPatients();


    @POST("/api/login_check")
    Call<String> getToken(@Body String username, String password);
}
