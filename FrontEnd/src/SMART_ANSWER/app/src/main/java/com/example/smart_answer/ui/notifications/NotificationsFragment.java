package com.example.smart_answer.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.R;
import com.example.smart_answer.recycler.ItemRecyclerVertical;
import com.example.smart_answer.recycler.RecyclerVerticalAdapter;

public class NotificationsFragment extends Fragment {

//    private NotificationsViewModel notificationsViewModel;
////
////    public View onCreateView(@NonNull LayoutInflater inflater,
////            ViewGroup container, Bundle savedInstanceState) {
////        notificationsViewModel =
////                ViewModelProviders.of(this).get(NotificationsViewModel.class);
////        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
////        final TextView textView = root.findViewById(R.id.text_notifications);
////        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
////        return root;
////    }
    private RecyclerView notificationRecycler;
    private RecyclerVerticalAdapter notificationAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        notificationRecycler = (RecyclerView)root.findViewById(R.id.NotificationRecycler);
        notificationRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        notificationRecycler.setLayoutManager(linearLayoutManager);

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
