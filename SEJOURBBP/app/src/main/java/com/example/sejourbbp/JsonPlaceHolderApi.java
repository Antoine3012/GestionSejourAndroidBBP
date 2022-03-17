package com.example.sejourbbp;

import com.example.sejourbbp.ui.Patient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("api/patients")
    Call<List<Patient>> getPatients();

    @FormUrlEncoded
    @POST("api/login_check")
    Call<String> getToken(@Field("username") String username, @Field("password") String password);
}
