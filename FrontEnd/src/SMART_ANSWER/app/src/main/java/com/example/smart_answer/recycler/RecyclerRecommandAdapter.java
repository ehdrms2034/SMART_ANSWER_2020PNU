package com.example.smart_answer.recycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerRecommandAdapter extends RecyclerView.Adapter<RecyclerRecommandAdapter.ItemViewHolder>{
    RecyclerRecommand recyclerRecommand = new RecyclerRecommand();
    private ArrayList<RecyclerRecommand> listData = new ArrayList<>();
    public RecyclerRecommandAdapter() {

    }
    public RecyclerRecommandAdapter(ArrayList<RecyclerRecommand> listData) {
        this.listData = listData;
    }
    @NonNull
    @Override
    public RecyclerRecommandAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommand, parent, false);
        return new RecyclerRecommandAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRecommandAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(RecyclerRecommand recyclerRecommand) {
        listData.add(recyclerRecommand);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView word;

        ItemViewHolder(View itemView) {
            super(itemView);

            word = itemView.findViewById(R.id.result_recommand);
        }

        void onBind(RecyclerRecommand data) {
            word.setText(data.getWord());
        }
    }

}

