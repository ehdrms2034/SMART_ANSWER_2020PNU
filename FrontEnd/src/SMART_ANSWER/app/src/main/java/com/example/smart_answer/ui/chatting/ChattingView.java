package com.example.smart_answer.ui.chatting;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;

public class ChattingView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final ChattingAdapter m_Adapter = new ChattingAdapter();
        // Xml에서 추가한 ListView 연결
        final ListView m_ListView = (ListView)findViewById(R.id.chatListView);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        m_Adapter.add("내일 뭐할래?",0);
        /*
        m_Adapter.add("이건 뭐지",1);
        m_Adapter.add("쿨쿨",1);
        m_Adapter.add("재미있게",1);
        m_Adapter.add("놀자라구나힐힐 감사합니다. 동해물과 백두산이 마르고 닳도록 놀자 놀자 우리 놀자",1);
        m_Adapter.add("재미있게",1);
        m_Adapter.add("재미있게",0);
        m_Adapter.add("2015/11/20",2);
        m_Adapter.add("재미있게",1);
        m_Adapter.add("재미있게",1);

         */

        m_ListView.setAdapter(m_Adapter);

        final EditText editText = (EditText)findViewById(R.id.chat_editText);

        Button button_send = (Button)findViewById(R.id.button_chat_send);
        button_send.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( editText.getText().toString().length() == 0)
                    ;
                else {
                    m_Adapter.add(editText.getText().toString(), 1);
                    m_ListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(),0);
                    editText.setText(null);
                }
            }
        });

    }

}
