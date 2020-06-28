package com.example.smart_answer.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.ItemRecyclerVertical;
import com.example.smart_answer.recycler.RecyclerVerticalAdapter;
import com.example.smart_answer.retrofit.RetrofitInterface;
import com.example.smart_answer.ui.login.LoginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NotificationsFragment extends Fragment {

    private RecyclerView notificationRecycler;
    private RecyclerVerticalAdapter notificationAdapter;
    private int counter = 0;
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> context = new ArrayList<>();
    public String messageDebug = "초기값";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://54.180.175.238:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        ((MainActivity)getActivity()).setActiobarTitle("공지사항");

        notificationRecycler = (RecyclerView)root.findViewById(R.id.NotificationRecycler);
        notificationRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notificationRecycler.setLayoutManager(linearLayoutManager);

        notificationAdapter = new RecyclerVerticalAdapter();

        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<NotificationsData> responseData = service.getNotifications();
        responseData.enqueue(new Callback<NotificationsData>() {
            @Override
            public void onResponse(Call<NotificationsData> call, Response<NotificationsData> response) {
                try{
                    if (response.isSuccessful()) {
                        messageDebug = "공지사항 받기 성공";
                        counter = response.body().getData().size();
                        for(int i=0; i< counter; ++i) {
                            date.add(response.body().getData().get(i).getDate());
                            title.add(response.body().getData().get(i).getTitle());
                            context.add(response.body().getData().get(i).getContext());
                        }
                        notificationRecycler.setAdapter(notificationAdapter);
                    } else {
                        messageDebug = "공지사항 받기 실패";
                    }
                }
                catch(Exception e) {
                    Log.d("My Tag", response.body().toString());
                    messageDebug = "에러 발생, 연결 양호";
                }

                for(int i=0;i < counter;i++) {
                    ItemRecyclerVertical data = new ItemRecyclerVertical(title.get(i), date.get(i));
                    notificationAdapter.addItem(data);
                }
            }
            @Override
            public void onFailure(Call<NotificationsData> call, Throwable t) {
                messageDebug = "연결 실패";
            }

        });
        return root;
    }
}
