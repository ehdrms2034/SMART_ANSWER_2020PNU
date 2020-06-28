package com.example.smart_answer.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class NotificationView extends AppCompatActivity {
    ArrayList<String> context = new ArrayList<>();
    private int pos;
    private TextView noticontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent = getIntent();
        context = intent.getExtras().getStringArrayList("context");
        pos = intent.getExtras().getInt("pos");
        noticontext = (TextView) findViewById(R.id.noticontext);
        try {
            noticontext.setText(context.get(pos));
        } catch(NullPointerException e) {
            noticontext.setText("no context");
        } catch(IndexOutOfBoundsException e) {
            noticontext.setText("bound over");
        }
    }
}
