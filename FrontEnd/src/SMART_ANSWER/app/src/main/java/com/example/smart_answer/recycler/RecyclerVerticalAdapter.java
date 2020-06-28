package com.example.smart_answer.recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;
import com.example.smart_answer.ui.chatting.ChattingView;
import com.example.smart_answer.ui.notifications.NotificationView;
import com.example.smart_answer.ui.notifications.NotificationsFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerVerticalAdapter extends RecyclerView.Adapter<RecyclerVerticalAdapter.ItemViewHolder> {

    private ArrayList<ItemRecyclerVertical> listData = new ArrayList<>();
    private ArrayList<String> context = new ArrayList<>();
    public RecyclerVerticalAdapter() {

    }
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView date;

        ItemViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    NotificationsFragment NF = new NotificationsFragment();
                    context = NF.context;
                    Intent intent = new Intent(v.getContext(), NotificationView.class);
                    intent.putExtra("context",context);
                    intent.putExtra("pos",pos);
                    if(pos != RecyclerView.NO_POSITION) {
                        v.getContext().startActivity(intent);
                    }

                }
            });
        }

//        void onBind(ItemRecyclerVertical data) {
//            date.setText(data.getTitle());
//            if (data.getTitle().length() > 15) {
//                String first = data.getTitle().substring(0, 15);
//                String second = data.getTitle().substring(15, data.getTitle().length());
//                data.setTitle(first + "\n" + second);
//            }
//            if (data.getDate() != "") {
//                data.setTitle(data.getTitle() + "\n" + data.getDate());
//            }
//            title.setText(data.getTitle());
//            date.setText(data.getDate());
//       }
    }

    public RecyclerVerticalAdapter(ArrayList<ItemRecyclerVertical> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemRecyclerVertical item = listData.get(position);

        holder.title.setText(item.getTitle());
        holder.date.setText(item.getDate());
        //holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(ItemRecyclerVertical ItemRecyclerVertical) {
        listData.add(ItemRecyclerVertical);
    }

}
