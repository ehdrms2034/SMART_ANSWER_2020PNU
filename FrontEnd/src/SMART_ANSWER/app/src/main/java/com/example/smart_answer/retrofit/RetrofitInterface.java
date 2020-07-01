package com.example.smart_answer.retrofit;


import com.example.smart_answer.ui.dashboard.DashboardData;
import com.example.smart_answer.ui.dashboard.DashboardPostBody;
import com.example.smart_answer.ui.dashboard.ImageData;
import com.example.smart_answer.ui.home.HomePostBody;
import com.example.smart_answer.ui.login.LoginData;
import com.example.smart_answer.ui.login.LoginPostBody;
import com.example.smart_answer.ui.notifications.NotificationData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RetrofitInterface {

    // smart answer server
    //데이터 받기
    @GET("api/member/")
    Call<LoginData> getLoginData(@Query("username") String userName);

    @POST("api/wrong/getAllInfo")
    Call<DashboardData> getAllInfO(@Body DashboardPostBody dashboardPostBody);

    @POST("api/wrong/getbyidanddate")
    Call<DashboardData> getDashboardData(@Body DashboardPostBody dashboardPostBody);

    @GET("api/upload/files")
    Call<ImageData> getFiles();

    @POST("api/test/getTestWord")
    Call<JsonObject> getTestWord(@Body HomePostBody body);

    //POSTS
    @POST("api/member/createMember")
    Call<JsonObject> postUser(@Body LoginPostBody loginPostBody);

    @Multipart
    @POST("api/upload/")
    Call<ResponseBody> postImage(@Query("date") String date,
                                 //@Part("imgFile") File uploadFile,
                                 @Part MultipartBody.Part uploadFile,
                                 @Query("userID") String userID);

    @GET("api/notify/getNotification")
    Call<NotificationData> getNotification();
}
