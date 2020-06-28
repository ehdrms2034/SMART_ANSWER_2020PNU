package com.example.smart_answer.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.ItemRecyclerVertical;
import com.example.smart_answer.recycler.RecyclerVerticalAdapter;
import com.example.smart_answer.retrofit.RetrofitInterface;
<<<<<<< HEAD
import com.example.smart_answer.ui.login.LoginData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
=======
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
>>>>>>> d51f72621cf15293d536ec17851b1a8eb5188132

public class NotificationsFragment extends Fragment {

    private RecyclerView notificationRecycler;
    private RecyclerVerticalAdapter notificationAdapter;
<<<<<<< HEAD
    private int counter = 0;
    private ArrayList<String> date = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<String> context = new ArrayList<>();
    public String messageDebug = "초기값";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://54.180.175.238:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

=======
    public ArrayList<String> title = new ArrayList<String>();
    public ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> context = new ArrayList<String>();
    NotificationData notidata;
    private int itemSize;
>>>>>>> d51f72621cf15293d536ec17851b1a8eb5188132
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        ((MainActivity)getActivity()).setActiobarTitle("공지사항");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.175.238:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);

        Call<NotificationData> responseData = service.getNotification();
        responseData.enqueue(new Callback<NotificationData>() {
            @Override
            public void onResponse(Call<NotificationData> call, Response<NotificationData> response) {
                try{
                    if (response.isSuccessful()) {
                        Toast.makeText((getActivity()).getApplicationContext(), "response success",
                                Toast.LENGTH_SHORT).show();
                        notidata = response.body();
                        itemSize = notidata.getData().size();
                        for(int i=0; i<itemSize; i++) {
                            title.add(notidata.getData().get(i).getTitle());
                            date.add(notidata.getData().get(i).getDate());
                            context.add(notidata.getData().get(i).getContext());
                        }
                    } else {
                        Toast.makeText((getActivity()).getApplicationContext(), "response failed",Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e) {
                    Log.d("My Tag", response.body().toString());
                    Toast.makeText((getActivity()).getApplicationContext(), "exception",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<NotificationData> call, Throwable t) {
                t.printStackTrace();
            }
        });

        notificationRecycler = (RecyclerView)root.findViewById(R.id.NotificationRecycler);
        notificationRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notificationRecycler.setLayoutManager(linearLayoutManager);

        notificationAdapter = new RecyclerVerticalAdapter();

<<<<<<< HEAD
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
=======
        /*title.add("t1"); date.add("d1"); context.add("c1");
        title.add("t2"); date.add("d2"); context.add("c2");
        title.add("t3"); date.add("d3"); context.add("c3");
        title.add("t4"); date.add("d4"); context.add("c4");*/
        try {
            if(itemSize == 0) {
                ItemRecyclerVertical data = new ItemRecyclerVertical("공지사항이 없습니다", "");
                notificationAdapter.addItem(data);
            }
            else {
                for (int i = 0; i < itemSize; i++) {
>>>>>>> d51f72621cf15293d536ec17851b1a8eb5188132
                    ItemRecyclerVertical data = new ItemRecyclerVertical(title.get(i), date.get(i));
                    notificationAdapter.addItem(data);
                }
            }
<<<<<<< HEAD
            @Override
            public void onFailure(Call<NotificationsData> call, Throwable t) {
                messageDebug = "연결 실패";
            }

        });
=======
        } catch (NullPointerException e) {
            ItemRecyclerVertical data = new ItemRecyclerVertical("널포인터", "");
            notificationAdapter.addItem(data);
        } catch (IndexOutOfBoundsException e) {
            ItemRecyclerVertical data = new ItemRecyclerVertical("범위밖", "");
            notificationAdapter.addItem(data);
        }

>>>>>>> d51f72621cf15293d536ec17851b1a8eb5188132
        return root;
    }
}
