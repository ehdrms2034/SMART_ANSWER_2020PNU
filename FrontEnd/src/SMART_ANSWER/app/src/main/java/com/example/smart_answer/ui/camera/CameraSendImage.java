/*
package com.example.smart_answer.ui.camera;


import android.util.Log;
import android.widget.Toast;

import com.example.smart_answer.retrofit.RetrofitInterface;
import com.example.smart_answer.ui.login.LoginData;
import com.google.gson.JsonObject;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CameraSendImage {
    String photoUri = "";
    File fileImage;
    String messageDebug = "초기값";


    public CameraSendImage(String _photoUri) {
        photoUri = _photoUri;
        fileImage = new File(photoUri);
    }

    public CameraSendImage(File _fileImage) {
        fileImage = _fileImage;
    }

    public String RetrofitConnect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.175.238:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), fileImage);
        MultipartBody.Part body = MultipartBody.Part.createFormData("data", fileImage.getName(), requestFile);
        String check2 = fileImage.getName();
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<JsonObject> responseData = service.postImage("hi",body,"hi");

        responseData.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful()) {
                        messageDebug = "채점 결과를 기다려 주세요";
                    } else {
                        messageDebug = "채점 실패, 다시 시도 해 주세요";
                    }
                } catch (Exception e) {
                    Log.d("My Tag", response.body().toString());
                    messageDebug  = "연결 실패";
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                messageDebug = t.toString();
            }
        });
        messageDebug = responseData.request().toString();
        return messageDebug;
    }

}


 */