package com.example.smart_answer.recycler;

import android.app.Activity;
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
import com.example.smart_answer.ui.chatting.ChattingView;

import java.util.ArrayList;

public class RecyclerFriendAdapter extends RecyclerView.Adapter<RecyclerFriendAdapter.ViewHolder> {

    public MainActivity activity;
    RecyclerFriend recyclerFriend = new RecyclerFriend();
    private ArrayList<RecyclerFriend> arrayList = new ArrayList<>();

    public RecyclerFriendAdapter(){

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView  name ;
        TextView  talks;

        ViewHolder(View itemView){
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            image = itemView.findViewById(R.id.friend_image) ;
            name  = itemView.findViewById(R.id.friend_name) ;
            talks = itemView.findViewById(R.id.friend_talks) ;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Intent intent = new Intent(v.getContext(), ChattingView.class);
                    if(pos != RecyclerView.NO_POSITION) {
                        v.getContext().startActivity(intent);
                    }

                }
            });
        }
    }
    @Override
    public RecyclerFriendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.item_friends, parent, false) ;
        RecyclerFriendAdapter.ViewHolder vh = new RecyclerFriendAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(RecyclerFriendAdapter.ViewHolder holder, int position) {

        RecyclerFriend item = arrayList.get(position) ;

        holder.image.setImageResource(item.getImage()) ;
        holder.name.setText(item.getName()) ;
        holder.talks.setText(item.getTalks()) ;
    }

    public void addItem(RecyclerFriend recyclerFriend) {
        arrayList.add(recyclerFriend);
    }
    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return arrayList.size() ;
    }
}
