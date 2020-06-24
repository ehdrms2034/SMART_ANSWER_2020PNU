package com.example.smart_answer.retrofit;


import com.example.smart_answer.ui.login.LoginData;
import com.example.smart_answer.ui.login.PostData;
import com.example.smart_answer.ui.notifications.NotificationData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {

    // smart answer server
    @GET("api/member/") // LoginData로 RestApi 받기 -> 최종 목표
    Call<LoginData> getLoginData(@Query("username") String userName);

    @POST("api/member/createMember")
    Call<JsonObject> postUser(@Body PostData postData);

    @GET("api/notify/getNotification")
    Call<NotificationData> getNotification();
}
