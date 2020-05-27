package com.example.smart_answer.retrofit;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitInterface {
    @GET("users/{user}/repos")
    Call<JsonArray> getUserRepositories(@Path("user") String userName);
    @GET("users/{user}")
    Call<JsonObject> getUserID(@Path("user") String userID);
    @GET("users/{user}/node_id")
    Call<JsonObject> getUserPWD(@Path("user") String userPWD);

    @POST("users/{user}")
    Call<JsonObject> postUserID(@Field("user") String userID);
}
