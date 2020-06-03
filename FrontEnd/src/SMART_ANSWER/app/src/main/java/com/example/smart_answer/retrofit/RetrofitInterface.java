package com.example.smart_answer.retrofit;


import com.example.smart_answer.ui.login.LoginData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
    // Git server
    @GET("users/{user}/repos")
    Call<JsonArray> getUserRepositories(@Path("user") String userName);
    @GET("users/{user}")
    Call<JsonObject> getUserID(@Path("user") String userID);
    @GET("users/{user}/node_id")
    Call<JsonObject> getUserPWD(@Path("user") String userPWD);

    // smart answer server
    @GET("api/member/")
    Call<LoginData> getUserData(@Query("username") String userName);
    @GET("users/{user}")
    Call<LoginData> getLoginData(@Path("user") String userID);
    @POST("api/member/createMember")
    Call<LoginData> postUser(   @Field("name") String name,
                                @Field("password") String password,
                                @Field("username") String username);

}
