package com.example.smart_answer.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerRecentWrongAdapter extends RecyclerView.Adapter<RecyclerRecentWrongAdapter.ItemViewHolder>{
    RecyclerRecentWrong recyclerRecentWrong = new RecyclerRecentWrong();
    private ArrayList<RecyclerRecentWrong> listData = new ArrayList<>();
    public RecyclerRecentWrongAdapter() {

            }
    public RecyclerRecentWrongAdapter(ArrayList<RecyclerRecentWrong> listData) {
            this.listData = listData;
            }
    @NonNull
    @Override
    public RecyclerRecentWrongAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent_wrong, parent, false);
            return new RecyclerRecentWrongAdapter.ItemViewHolder(view);
            }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRecentWrongAdapter.ItemViewHolder holder, int position) {
            holder.onBind(listData.get(position));
            }

    @Override
    public int getItemCount() {
            return listData.size();
            }

    public void addItem(RecyclerRecentWrong recyclerRecentWrong) {
            listData.add(recyclerRecentWrong);
            }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView recentWrongWord;

        ItemViewHolder(View itemView) {
            super(itemView);

            recentWrongWord = itemView.findViewById(R.id.recent_wrong_words);
        }

        void onBind(RecyclerRecentWrong data) {
            recentWrongWord.setText(data.getWord());
        }
    }
}

