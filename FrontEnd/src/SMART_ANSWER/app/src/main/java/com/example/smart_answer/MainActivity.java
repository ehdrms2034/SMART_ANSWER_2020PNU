package com.example.smart_answer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smart_answer.ui.dashboard.DashboardFragment;

import com.example.smart_answer.ui.chatting.ChattingView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    FragmentTransaction transaction;
    BottomNavigationView navView;
    ChattingView chattingFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //fragment manage 설정
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_friends)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        /*dashboardBtn = (Button)findViewById(R.id.resultBtn);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dashboardFragment = new DashboardFragment();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, dashboardFragment);
                transaction.addToBackStack("fragment");
                transaction.commit();
            }
        });*/
    }
    public BottomNavigationView getNavView(){
        return navView;
    }
    /*public void replaceFragment(@NonNull Fragment fragment) {
        //fragment stack에 기존에 있던 fragment 제거
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.commit();
    }*/

    @Override
    public void onBackPressed() {
        // 뒤로가기버튼 누를 시 네비바 홈으로 초기화
        for(int i=0;i<4;i++){
            navView.getMenu().getItem(i).setChecked(false);
        }
        navView.getMenu().getItem(0).setChecked(true);
        super.onBackPressed();
    }
}
