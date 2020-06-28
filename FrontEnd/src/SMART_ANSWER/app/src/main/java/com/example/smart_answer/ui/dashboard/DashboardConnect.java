package com.example.smart_answer.ui.dashboard;

import android.util.Log;

import com.example.smart_answer.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardConnect {
    private String date;
    private String id;
    String messageDebug = "";

    public DashboardConnect(String _date, String _id) {
        date = _date;
        id = _id;
        messageDebug = "초기값";
    }

    public String RetrofitConnect() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.175.238:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DashboardPostBody dashboardPostBody = new DashboardPostBody("test", "test");
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<DashboardData> responseData = service.getDashboardData(dashboardPostBody);

        responseData.enqueue(new Callback<DashboardData>() {
            @Override
            public void onResponse(Call<DashboardData> call, Response<DashboardData> response) {
                try {
                    if (response.isSuccessful()) {
                        messageDebug = "채점 결과 가져오기 성공!!";
                    } else {
                        messageDebug = "채점 결과 못가져옴 ㅠㅜㅠㅜ";
                    }
                } catch (Exception e) {
                    Log.d("My Tag", response.body().toString());
                    messageDebug  = "연결 실패";
                }
            }

            @Override
            public void onFailure(Call<DashboardData> call, Throwable t) {
                messageDebug = t.toString();
            }
        });
        //messageDebug = responseData.request().toString();
        return messageDebug;
    }

}
