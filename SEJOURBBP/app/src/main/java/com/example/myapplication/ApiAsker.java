package com.example.myapplication;

import com.example.myapplication.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiAsker {
    
    @GET("api/patients")
    Call<List<Patient>> getPatients(@Header("Accept") String header, @Header("Authorization") String token);

    @POST("api/patients")
    Call<List<Patient>> postPatients(@Header("Accept") String header, @Header("Authorization") String token ,@Body Patient patient);

    @PUT("api/patients/{id}")
    Call<List<Patient>> putPatients(@Path ("id")int id, @Header("Accept") String header, @Header("Authorization") String token , @Body Patient patient);

    @DELETE("api/patients/{id}")
    Call<List<Patient>> delPatients(@Path ("id")int id, @Header("Accept") String header, @Header("Authorization") String token , @Body Patient patient);

    @POST("api/login_check")
    Call<Object> getToken(@Header("Accept") String header,@Body User user);

    @GET("api/sejours")
    Call<List<Sejour>> getSejours(@Header("Accept") String header, @Header("Authorization") String token);

}


