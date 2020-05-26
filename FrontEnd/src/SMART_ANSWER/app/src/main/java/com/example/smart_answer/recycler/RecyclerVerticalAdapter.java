package com.example.smart_answer.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerVerticalAdapter extends RecyclerView.Adapter<RecyclerVerticalAdapter.ItemViewHolder> {

    private ArrayList<ItemRecyclerVertical> listData = new ArrayList<>();
    public RecyclerVerticalAdapter() {

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
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(ItemRecyclerVertical ItemRecyclerVertical) {
        listData.add(ItemRecyclerVertical);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView date;

        ItemViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
        }

        void onBind(ItemRecyclerVertical data) {
//            date.setText(data.getTitle());
//            if (data.getTitle().length() > 15) {
//                String first = data.getTitle().substring(0, 15);
//                String second = data.getTitle().substring(15, data.getTitle().length());
//                data.setTitle(first + "\n" + second);
//            }
//            if (data.getDate() != "") {
//                data.setTitle(data.getTitle() + "\n" + data.getDate());
//            }
            title.setText(data.getTitle());
            date.setText(data.getDate());
        }
    }
}
