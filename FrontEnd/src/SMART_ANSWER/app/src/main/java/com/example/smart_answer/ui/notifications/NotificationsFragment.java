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
    public int itemSize;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ((MainActivity)getActivity()).setActiobarTitle("공지사항");

        notificationRecycler = (RecyclerView)root.findViewById(R.id.NotificationRecycler);
        notificationRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notificationAdapter = new RecyclerVerticalAdapter();

        notificationRecycler.setLayoutManager(linearLayoutManager);

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
                        notidata = response.body();
                        itemSize = notidata.getData().size();
                        for(int i=0; i<itemSize; i++) {
                            title.add(notidata.getData().get(i).getTitle().toString());
                            date.add(notidata.getData().get(i).getDate().substring(0,10));
                            context.add(notidata.getData().get(i).getContext().toString());
                        }
                        //Toast.makeText((getActivity()).getApplicationContext(), itemSize+"", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText((getActivity()).getApplicationContext(), "response failed",Toast.LENGTH_SHORT).show();
                    }
                }
                catch(Exception e) {
                    //Log.d("My Tag", response.body().toString());
                    Toast.makeText((getActivity()).getApplicationContext(), "exception",Toast.LENGTH_SHORT).show();
                }

                try {
                    if(itemSize == 0) {
                        ItemRecyclerVertical data = new ItemRecyclerVertical("공지사항이 없습니다", "");
                        notificationAdapter.addItem(data);
                    }
                    else {
                        for (int i = 0; i < itemSize; i++) {
                            ItemRecyclerVertical data = new ItemRecyclerVertical(title.get(i)+"", date.get(i)+"");
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
                notificationRecycler.setAdapter(notificationAdapter);
            }
            @Override
            public void onFailure(Call<NotificationData> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return root;
        }
    }