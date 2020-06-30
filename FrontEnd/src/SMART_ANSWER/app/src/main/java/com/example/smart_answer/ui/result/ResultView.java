package com.example.smart_answer.ui.result;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.ItemRecyclerVertical;
import com.example.smart_answer.recycler.RecyclerRecommand;
import com.example.smart_answer.recycler.RecyclerRecommandAdapter;
import com.example.smart_answer.recycler.RecyclerResult;
import com.example.smart_answer.recycler.RecyclerResultAdapter;
import com.example.smart_answer.recycler.RecyclerVerticalAdapter;
import com.example.smart_answer.retrofit.RetrofitInterface;
import com.example.smart_answer.ui.dashboard.DashboardConnect;
import com.example.smart_answer.ui.dashboard.DashboardData;
import com.example.smart_answer.ui.dashboard.DashboardPostBody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultView extends AppCompatActivity {

    private ArrayList<String> correct_words = new ArrayList<>();
    private ArrayList<String> mean_words = new ArrayList<>();
    private ArrayList<String> my_words = new ArrayList<>();
    private int wrongCount = 0;
    private RecyclerView resultRecycler;
    private RecyclerResultAdapter resultRecyclerAdapter;

    private RecyclerView recommandRecycler;
    private RecyclerRecommandAdapter recommandRecyclerAdapter;


    private String date = "string";
    private String id = "string";
    String messageDebug = "";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://54.180.175.238:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    DashboardPostBody dashboardPostBody = new DashboardPostBody(id);
    RetrofitInterface service = retrofit.create(RetrofitInterface.class);
    Call<DashboardData> responseData = service.getDashboardData(dashboardPostBody);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //getSupportActionBar().setTitle("결과");
        //결과
        resultRecycler = findViewById(R.id.ResultRecycler);
        resultRecycler.addItemDecoration(new DividerItemDecoration(resultRecycler.getContext(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        resultRecycler.setLayoutManager(linearLayoutManager);

        resultRecyclerAdapter = new RecyclerResultAdapter();

        recommandRecycler = findViewById(R.id.ResultRecommand);
        recommandRecycler.addItemDecoration(new DividerItemDecoration(recommandRecycler.getContext(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recommandRecycler.setLayoutManager(linearLayoutManager2);

        recommandRecyclerAdapter = new RecyclerRecommandAdapter();

        responseData.enqueue(new Callback<DashboardData>() {
            @Override
            public void onResponse(Call<DashboardData> call, Response<DashboardData> response) {
                try {
                    if (response.isSuccessful()) {
                        messageDebug = "채점 결과 가져오기 성공!!";
                        /*
                        correct_words.addAll(response.body().getData().getCorrect_word());
                        mean_words.addAll(response.body().getData().getMean_word());
                        my_words.addAll(response.body().getData().getMy_word());
                        wrongCount = Integer.parseInt(response.body().getData().getWrong_count());
                         */

                    } else {
                        messageDebug = response.errorBody().toString();
                    }
                } catch (Exception e) {
                    Log.d("My Tag", response.body().toString());
                    messageDebug  = "연결 실패";
                }
                Toast.makeText(getApplicationContext(), messageDebug,
                        Toast.LENGTH_SHORT).show();
                for(int i=0; i< wrongCount; i++) {
                    RecyclerResult data = new RecyclerResult(correct_words.get(i), my_words.get(i));
                    resultRecyclerAdapter.addItem(data);

                    RecyclerRecommand recommandData = new RecyclerRecommand(mean_words.get(i));
                    recommandRecyclerAdapter.addItem(recommandData);
                }
                resultRecycler.setAdapter(resultRecyclerAdapter);
                recommandRecycler.setAdapter(recommandRecyclerAdapter);
            }

            @Override
            public void onFailure(Call<DashboardData> call, Throwable t) {
                messageDebug = t.toString();
                Toast.makeText(getApplicationContext(), messageDebug,
                        Toast.LENGTH_SHORT).show();
            }
        });
        //retrofit connection end;
    }
}
