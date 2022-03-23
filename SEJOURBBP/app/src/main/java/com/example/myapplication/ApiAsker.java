package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiAsker {
    @GET("api/patients")
    Call<List<Patient>> getPatients(@Header("accept") String header, @Header("Authorization") String token);


    @POST("api/login_check")
    Call<Object> getToken(@Header("Accept") String header,@Body Login login);

}
