package com.example.smart_answer.ui.friends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.RecyclerFriend;
import com.example.smart_answer.recycler.RecyclerDashboardAdapter;
import com.example.smart_answer.recycler.RecyclerFriendAdapter;

import java.util.ArrayList;

public class FriendFragment extends Fragment {
    private ArrayList<RecyclerFriend> arrayList;
    private RecyclerFriendAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_friends, container, false);

        ((MainActivity)getActivity()).setActiobarTitle("메세지");

        recyclerView = (RecyclerView)root.findViewById(R.id.recycler_friends) ;
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter = new RecyclerFriendAdapter();


        RecyclerFriend data1 = new RecyclerFriend(R.drawable.lion1, "tjr", "Beautiful Day");
        //RecyclerFriend data2 = new RecyclerFriend(R.drawable.lion1, "Lee", "Bad Day");
        //RecyclerFriend data3 = new RecyclerFriend(R.drawable.lion1, "Park", "Nice Day");
        //RecyclerFriend data4 = new RecyclerFriend(R.drawable.lion1, "Choi", "Sad Day");


        adapter.addItem(data1);
        //adapter.addItem(data2);
        //adapter.addItem(data3);
        //adapter.addItem(data4);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return root;
    }
}
