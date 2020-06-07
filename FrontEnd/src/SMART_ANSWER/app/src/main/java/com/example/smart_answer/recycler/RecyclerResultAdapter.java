package com.example.smart_answer.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerResultAdapter extends RecyclerView.Adapter<RecyclerResultAdapter.ItemViewHolder>{
    RecyclerResult recyclerResult = new RecyclerResult();
    private ArrayList<RecyclerResult> listData = new ArrayList<>();
    public RecyclerResultAdapter() {

    }
    public RecyclerResultAdapter(ArrayList<RecyclerResult> listData) {
        this.listData = listData;
    }
    @NonNull
    @Override
    public RecyclerResultAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new RecyclerResultAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerResultAdapter.ItemViewHolder holder, int position) {
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void addItem(RecyclerResult recyclerResult) {
        listData.add(recyclerResult);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView date;

        ItemViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.result_answer);
            date = itemView.findViewById(R.id.result_my_answer);
        }

        void onBind(RecyclerResult data) {
            title.setText(data.getCorrect());
            date.setText(data.getMyAnswer());
        }
    }

}
