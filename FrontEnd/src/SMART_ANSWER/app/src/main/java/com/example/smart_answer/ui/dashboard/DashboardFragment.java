package com.example.smart_answer.ui.dashboard;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.RecyclerDashboard;
import com.example.smart_answer.recycler.RecyclerDashboardAdapter;
import com.example.smart_answer.retrofit.RetrofitInterface;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardFragment extends Fragment {
    private ArrayList<RecyclerDashboard> arrayList;
    private RecyclerDashboardAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String id = "front";
    private String messageDebug = "";
    private ArrayList<String> images = new ArrayList<>();
    public static ArrayList<Data> results = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        ((MainActivity)getActivity()).setActiobarTitle("채점결과");
        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_dashboard) ;
        adapter = new RecyclerDashboardAdapter();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("http://54.180.175.238:8080/")
                .addConverterFactory(GsonConverterFactory.create());

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(logInterceptor);

        OkHttpClient client = builder.build();
        retrofitBuilder.client(client);

        Retrofit retrofit = retrofitBuilder.build();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<DashboardData> responseData = service.getAllInfO(new DashboardPostBody(id));
        responseData.enqueue(new Callback<DashboardData>() {
            @Override
            public void onResponse(Call<DashboardData> call, Response<DashboardData> response) {
                try {
                    if (response.isSuccessful()) {
                        messageDebug = "채점 결과를 기다려 주세요";
                        if(response.body().getData().size() != results.size())
                            results.addAll(response.body().getData());
                    } else {
                        messageDebug = "채점 실패, 다시 시도 해 주세요";
                    }
                } catch (Exception e) {
                    Log.d("My Tag", response.body().toString());
                    messageDebug  = "연결 실패";
                }
                for(int i=0; i<results.size(); ++i) {
                    //int length = images.get(i).length();
                    String name = results.get(i).getDate();
                    RecyclerDashboard data = new RecyclerDashboard(R.drawable.lion1, name,
                            Integer.toString(Integer.parseInt(results.get(i).getWrong_count()) + Integer.parseInt(results.get(i).getAnswer_count())),
                            results.get(i).getAnswer_count(), results.get(i).getWrong_count());
                    adapter.addItem(data);
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DashboardData> call, Throwable t) {
                messageDebug = t.toString();
            }
        });


        return root;
    }

}