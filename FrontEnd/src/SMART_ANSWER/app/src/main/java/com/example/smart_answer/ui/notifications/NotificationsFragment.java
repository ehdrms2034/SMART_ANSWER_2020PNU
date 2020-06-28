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
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    ////    }
    private RecyclerView notificationRecycler;
    private RecyclerVerticalAdapter notificationAdapter;
    public ArrayList<String> title = new ArrayList<String>();
    public ArrayList<String> date = new ArrayList<String>();
    public static ArrayList<String> context = new ArrayList<String>();
    NotificationData notidata;
    private int itemSize;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ((MainActivity)getActivity()).setActiobarTitle("공지사항");
        notificationRecycler = (RecyclerView)root.findViewById(R.id.NotificationRecycler);
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
        notificationAdapter = new RecyclerVerticalAdapter();
        notificationRecycler.setAdapter(notificationAdapter);

            ItemRecyclerVertical data1 = new ItemRecyclerVertical("공지1","20200428 운영자");
            ItemRecyclerVertical data2 = new ItemRecyclerVertical("공지2","20200427 운영자");
            ItemRecyclerVertical data3 = new ItemRecyclerVertical("공지3","20200426 운영자");
            ItemRecyclerVertical data4 = new ItemRecyclerVertical("공지4","20200425 운영자");
            ItemRecyclerVertical data5 = new ItemRecyclerVertical("공지5","20200424 운영자");
            ItemRecyclerVertical data6 = new ItemRecyclerVertical("공지6","20200423 운영자");
            ItemRecyclerVertical data7 = new ItemRecyclerVertical("공지7","20200423 운영자");
            ItemRecyclerVertical data8 = new ItemRecyclerVertical("공지8","20200423 운영자");
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
                        ItemRecyclerVertical data = new ItemRecyclerVertical(title.get(i), date.get(i));
                        notificationAdapter.addItem(data);
                    }
                }
            } catch (NullPointerException e) {
                ItemRecyclerVertical data = new ItemRecyclerVertical("널포인터", "");
                notificationAdapter.addItem(data);
            } catch (IndexOutOfBoundsException e) {
                ItemRecyclerVertical data = new ItemRecyclerVertical("범위밖", "");
                notificationAdapter.addItem(data);
            }

        notificationAdapter.addItem(data1);
        notificationAdapter.addItem(data2);
        notificationAdapter.addItem(data3);
        notificationAdapter.addItem(data4);
        notificationAdapter.addItem(data5);
        notificationAdapter.addItem(data6);
        notificationAdapter.addItem(data7);
        notificationAdapter.addItem(data8);
        return root;
        }
    }