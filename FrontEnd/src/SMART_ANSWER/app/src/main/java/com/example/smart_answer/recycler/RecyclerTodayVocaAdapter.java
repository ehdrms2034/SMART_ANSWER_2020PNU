package com.example.smart_answer.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerTodayVocaAdapter extends RecyclerView.Adapter<RecyclerTodayVocaAdapter.ItemViewHolder>{
    RecyclerTodayVoca recyclerTodayVoca = new RecyclerTodayVoca();
    private ArrayList<RecyclerTodayVoca> listData = new ArrayList<>();
    public RecyclerTodayVocaAdapter() {

    }
    public RecyclerTodayVocaAdapter(ArrayList<RecyclerTodayVoca> listData) {
        this.listData = listData;
    }
    @NonNull
    @Override
    public RecyclerTodayVocaAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_today_voca, parent, false);
        return new RecyclerTodayVocaAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerTodayVocaAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(RecyclerTodayVoca recyclerTodayVoca) {
        listData.add(recyclerTodayVoca);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView todayVoca;

        ItemViewHolder(View itemView) {
            super(itemView);

            todayVoca = itemView.findViewById(R.id.today_voca_words);
        }

        void onBind(RecyclerTodayVoca data) {
            todayVoca.setText(data.getVocaWord());
        }
    }
}
