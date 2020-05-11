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
import com.example.smart_answer.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnClick((Button)root.findViewById(R.id.resultBtn),1);
        btnClick((Button)root.findViewById(R.id.scoreBtn),2);
        btnClick((Button)root.findViewById(R.id.messageBtn),3);
        btnClick((Button)root.findViewById(R.id.notificationBtn),4);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();


        return root;
    }
    private void replaceFragment(@NonNull Fragment fragment) {
        transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }
    private void btnClick(Button btn,final int page){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DashboardFragment dashboardFragment = new DashboardFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("page",page);
                dashboardFragment.setArguments(bundle);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(0).setChecked(false);
                ((MainActivity)getActivity()).getNavView().getMenu().getItem(1).setChecked(true);
                replaceFragment(dashboardFragment);
            }
        });
    }
}
