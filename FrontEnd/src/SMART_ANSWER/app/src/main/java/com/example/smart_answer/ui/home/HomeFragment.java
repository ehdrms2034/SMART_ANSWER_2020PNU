package com.example.smart_answer.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.RecyclerRecentWrong;
import com.example.smart_answer.recycler.RecyclerRecentWrongAdapter;
import com.example.smart_answer.recycler.RecyclerTodayVoca;
import com.example.smart_answer.recycler.RecyclerTodayVocaAdapter;
import com.example.smart_answer.retrofit.RetrofitInterface;
import com.example.smart_answer.ui.camera.CameraView;
import com.example.smart_answer.ui.friends.FriendFragment;
import com.example.smart_answer.ui.dashboard.DashboardFragment;
import com.example.smart_answer.ui.login.LoginData;
import com.example.smart_answer.ui.notifications.NotificationsFragment;
import com.google.gson.JsonObject;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button resultBtn, messageBtn, notificationBtn;
    private ImageButton photoBtn;
    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 672;
    private String imageFilePath;
    private Uri photoUri;

    private TextView userName;
    private TextView userInfo;

    private RecyclerView recentWrongRecycler;
    private RecyclerRecentWrongAdapter recentWrongAdapter;
    private RecyclerView todayVocaRecycler;
    private RecyclerTodayVocaAdapter todayVocaAdapter;

    private ArrayList<String> recent = new ArrayList<>();
    private ArrayList<String> today = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        ((MainActivity)getActivity()).setActiobarTitle("홈");
        btnClick((ImageButton)root.findViewById(R.id.photoBtn));

//유저정보
        userName = (TextView)root.findViewById(R.id.usernameInHome);
        userName.setText("John Doe");
        userInfo = (TextView)root.findViewById(R.id.userinfo);
        userInfo.setText("San Francisco");


        //TodayVoca   todayVocaAdapter;todayVocaRecycler
        todayVocaRecycler = (RecyclerView)root.findViewById(R.id.recycler_today_voca);
        todayVocaRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        todayVocaRecycler.setLayoutManager(linearLayoutManager2);

        todayVocaAdapter = new RecyclerTodayVocaAdapter();


        //최근틀린단어
        recentWrongRecycler = (RecyclerView)root.findViewById(R.id.recentWrong);
        recentWrongRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recentWrongRecycler.setLayoutManager(linearLayoutManager);
        recentWrongAdapter = new RecyclerRecentWrongAdapter();

        HomePostBody homePostBody = new HomePostBody("2020-07-01", "front");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.180.175.238:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        Call<JsonObject> responseData = service.getTestWord(homePostBody);
        responseData.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try{
                    if (response.isSuccessful()) {
                        for(int i=0;i<response.body().get("data").getAsJsonObject().get("testWord")
                                .getAsJsonArray().size(); ++i) {
                            today.add(response.body().get("data").getAsJsonObject()
                                    .get("testWord").getAsJsonArray().get(i).toString().replace('"', ' '));

                            RecyclerTodayVoca data = new RecyclerTodayVoca(today.get(i));
                            todayVocaAdapter.addItem(data);
                        }
                        for(int i=0;i<response.body().get("data").getAsJsonObject().get("wrongWord")
                                .getAsJsonArray().size(); ++i) {
                            recent.add(response.body().get("data").getAsJsonObject()
                                    .get("wrongWord").getAsJsonArray().get(i).toString().replace('"', ' '));

                            RecyclerRecentWrong data = new RecyclerRecentWrong(recent.get(i));
                            recentWrongAdapter.addItem(data);
                        }
                    } else {
                    }
                    recentWrongRecycler.setAdapter(recentWrongAdapter);
                    todayVocaRecycler.setAdapter(todayVocaAdapter);

                }
                catch(Exception e) {
                    Log.d("My Tag", response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
        //btnClick((Button)root.findViewById(R.id.resultBtn));
        //btnClick((Button)root.findViewById(R.id.messageBtn));
        //btnClick((Button)root.findViewById(R.id.notificationBtn));
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        manager = getActivity().getSupportFragmentManager();
        //imageView = (ImageView)root.findViewById(R.id.camera_view);

        photoBtn = (ImageButton)root.findViewById(R.id.photoBtn);
        photoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), CameraView.class);
                startActivity(intent1);
            }
        });
/*
        //각 버튼 클릭 시 해당 fragment로 이동
        resultBtn = (Button)root.findViewById(R.id.resultBtn);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(0).setChecked(false);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(1).setChecked(true);
                replaceFragment(dashboardFragment);
            }
        });
        notificationBtn = (Button)root.findViewById(R.id.notificationBtn);
        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationsFragment notificationsFragment = new NotificationsFragment();
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(0).setChecked(false);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(2).setChecked(true);
                replaceFragment(notificationsFragment);
            }
        });
        messageBtn = (Button)root.findViewById(R.id.messageBtn);
        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FriendFragment friendFragment = new FriendFragment();
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(0).setChecked(false);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(3).setChecked(true);
                replaceFragment(friendFragment);
            }recentWrongRecycler; recentWrongAdapter;
        });*/

        return root;
    }

    /*@Override
    public void onStart() {
        ((MainActivity)getActivity()).setActiobarTitle("홈"); // 타이틀 변경
        super.onStart();
    }*/

    //fragment 이동
    private void replaceFragment(@NonNull Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }

    private void btnClick(ImageButton btn){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(0).setChecked(false);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(1).setChecked(true);
                replaceFragment(dashboardFragment);
            }
        });
    }
}
