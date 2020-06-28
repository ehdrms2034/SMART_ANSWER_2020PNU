package com.example.smart_answer.retrofit;


import com.example.smart_answer.ui.dashboard.DashboardData;
import com.example.smart_answer.ui.dashboard.DashboardPostBody;
import com.example.smart_answer.ui.login.LoginData;
import com.example.smart_answer.ui.login.LoginPostBody;
import com.example.smart_answer.ui.notifications.NotificationsData;
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
    @GET("api/member/") // LoginData로 RestApi 받기 -> 최종 목표
    Call<LoginData> getLoginData(@Query("username") String userName);

    @POST("api/wrong/getbyidanddate")
    Call<DashboardData> getDashboardData(@Body DashboardPostBody dashboardPostBody);

    @GET("api/notify/getNotification")
    Call<NotificationsData> getNotifications();

    @GET("api/upload/getImageOfUser")
    Call<JsonObject> getImageOfUser(@Query("date") String date,
                                    @Query("id") String id);

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
