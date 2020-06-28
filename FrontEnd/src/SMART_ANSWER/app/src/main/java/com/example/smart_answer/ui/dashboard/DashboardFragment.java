package com.example.smart_answer.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.RecyclerDashboard;
import com.example.smart_answer.recycler.RecyclerDashboardAdapter;
import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private ArrayList<RecyclerDashboard> arrayList;
    private RecyclerDashboardAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String messageDebug = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_dashboard) ;
        adapter = new RecyclerDashboardAdapter();
        ((MainActivity)getActivity()).setActiobarTitle("채점결과");

        RecyclerDashboard data1 = new RecyclerDashboard(R.drawable.lion1, "2020 05 17", "1","2","3");
        RecyclerDashboard data2 = new RecyclerDashboard(R.drawable.lion1, "2020 05 17", "1","2","3");
        RecyclerDashboard data3 = new RecyclerDashboard(R.drawable.lion1, "2020 05 17", "1","2","3");
        RecyclerDashboard data4 = new RecyclerDashboard(R.drawable.lion1, "2020 05 17", "1","2","3");
        RecyclerDashboard data5 = new RecyclerDashboard(R.drawable.lion1, "2020 05 17", "1","2","3");


        adapter.addItem(data1);
        adapter.addItem(data2);
        adapter.addItem(data3);
        adapter.addItem(data4);
        adapter.addItem(data5);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return root;

    }

}