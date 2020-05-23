package com.example.smart_answer;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.smart_answer.ui.dashboard.DashboardFragment;

import com.example.smart_answer.ui.chatting.ChattingView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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
    Toolbar toolbar;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //fragment manage 설정
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        //action bar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.

        navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_friends)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

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

//커스텀 액션바
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        ActionBar actionBar = getSupportActionBar();
//
//        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
//        actionBar.setDisplayShowTitleEnabled(true);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
//        actionBar.setDisplayShowHomeEnabled(true);            //홈 아이콘을 숨김처리합니다.
//
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_cloud); // 뒤로가기 버튼 아이콘
//        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
//        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
//        View actionbar = inflater.inflate(R.layout.custom_actionbar, null);
//
//        actionBar.setCustomView(actionbar);
//
//        //액션바 양쪽 공백 없애기
//        Toolbar parent = (Toolbar)actionbar.getParent();
//        parent.setContentInsetsAbsolute(0,0);
//
        /*
            이부분 코드를 로딩전에 띄어야함
            fragment마다 위에 bar title 이 달라야하는데
            fragment에서 title 바꾸는 코드를 넣으려면 actionbar를 불러와야함
            그치만 fragment가 activity보다 빨리 생성되어서 null로떠서 오류
            따라서 로딩전에 넣으면 fragment가 뜨기전에 actionbar부터 생성함.
         */
        return true;
    }

    public void setActiobarTitle(String title)
    {
        //fragment마다 actionbar제목
        TextView titleTxtView = (TextView) toolbar.findViewById(R.id.titleMain);
        titleTxtView.setText(title);
    }

    @Override
    public void onBackPressed() {
        // 뒤로가기버튼 누를 시 액션바,네비바 홈으로 초기화
        setActiobarTitle("홈");
        for(int i=0;i<4;i++){
            navView.getMenu().getItem(i).setChecked(false);
        }
        navView.getMenu().getItem(0).setChecked(true);
        super.onBackPressed();
    }
}