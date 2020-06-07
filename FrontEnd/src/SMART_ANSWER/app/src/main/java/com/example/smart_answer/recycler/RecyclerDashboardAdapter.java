package com.example.smart_answer.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.ui.result.ResultView;

import java.util.ArrayList;

public class RecyclerDashboardAdapter extends RecyclerView.Adapter<RecyclerDashboardAdapter.ViewHolder> {

    public MainActivity activity;
    RecyclerDashboard recyclerDashboard = new RecyclerDashboard();
    private ArrayList<RecyclerDashboard> arrayList = new ArrayList<>();

    public RecyclerDashboardAdapter(){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView  day ;
        TextView  word;
        TextView  answer;
        TextView  wrong_answer;

        ViewHolder(View itemView){
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            image = itemView.findViewById(R.id.test_image) ;
            day  = itemView.findViewById(R.id.test_day) ;
            word = itemView.findViewById(R.id.number_of_word);
            answer = itemView.findViewById(R.id.number_of_answer);
            wrong_answer = itemView.findViewById(R.id.number_of_wrong);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(), ResultView.class);
                    if(pos != RecyclerView.NO_POSITION) {
                        v.getContext().startActivity(intent);
                    }

                }
            });
        }
    }
    @Override
    public RecyclerDashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.item_dashboard, parent, false) ;
        RecyclerDashboardAdapter.ViewHolder vh = new RecyclerDashboardAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerDashboardAdapter.ViewHolder holder, int position) {

        RecyclerDashboard item = arrayList.get(position) ;

        holder.image.setImageResource(item.getImage()) ;
        holder.day.setText(item.getDay()) ;
        holder.word.setText(item.getWord()) ;
        holder.answer.setText(item.getAnswer()) ;
        holder.wrong_answer.setText(item.getWrong_answer()) ;
    }

    public void addItem(RecyclerDashboard recyclerDashboard) {
        arrayList.add(recyclerDashboard);
    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return arrayList.size() ;
    }
}
