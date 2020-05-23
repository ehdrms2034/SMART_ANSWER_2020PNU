package com.example.smart_answer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.ui.friends.FriendFragment;
import com.example.smart_answer.ui.dashboard.DashboardFragment;
import com.example.smart_answer.ui.notifications.NotificationsFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button resultBtn, messageBtn, notificationBtn;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnClick((Button)root.findViewById(R.id.resultBtn));
        btnClick((Button)root.findViewById(R.id.messageBtn));
        btnClick((Button)root.findViewById(R.id.notificationBtn));
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        manager = getActivity().getSupportFragmentManager();

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
            }
        });


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

    private void btnClick(Button btn){
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
