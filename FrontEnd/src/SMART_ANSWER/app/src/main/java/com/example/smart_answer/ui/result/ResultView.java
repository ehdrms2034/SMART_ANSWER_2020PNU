package com.example.smart_answer.ui.result;

import android.os.Bundle;

import com.example.smart_answer.MainActivity;
import com.example.smart_answer.R;
import com.example.smart_answer.recycler.ItemRecyclerVertical;
import com.example.smart_answer.recycler.RecyclerRecommand;
import com.example.smart_answer.recycler.RecyclerRecommandAdapter;
import com.example.smart_answer.recycler.RecyclerResult;
import com.example.smart_answer.recycler.RecyclerResultAdapter;
import com.example.smart_answer.recycler.RecyclerVerticalAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ResultView extends AppCompatActivity {
    private RecyclerView resultRecycler;
    private RecyclerResultAdapter resultRecyclerAdapter;

    private RecyclerView recommandRecycler;
    private RecyclerRecommandAdapter recommandRecyclerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //getSupportActionBar().setTitle("결과");
        //결과
        resultRecycler = findViewById(R.id.ResultRecycler);
        resultRecycler.addItemDecoration(new DividerItemDecoration(resultRecycler.getContext(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        resultRecycler.setLayoutManager(linearLayoutManager);

        resultRecyclerAdapter = new RecyclerResultAdapter();
        resultRecycler.setAdapter(resultRecyclerAdapter);

        for(int i=0; i<8; i++) {
            RecyclerResult data = new RecyclerResult("정답단어"+i, "내단어"+i);
            resultRecyclerAdapter.addItem(data);
        }
        /*RecyclerResult data1 = new RecyclerResult("정답단어1","내단어1");
        RecyclerResult data2 = new RecyclerResult("정답단어2","내단어2");
        RecyclerResult data3 = new RecyclerResult("정답단어3","내단어3");
        RecyclerResult data4 = new RecyclerResult("정답단어4","내단어4");
        RecyclerResult data5 = new RecyclerResult("정답단어5","내단어5");
        RecyclerResult data6 = new RecyclerResult("정답단어6","내단어6");
        RecyclerResult data7 = new RecyclerResult("정답단어7","내단어7");
        RecyclerResult data8 = new RecyclerResult("정답단어8","내단어8");

        resultRecyclerAdapter.addItem(data1);
        resultRecyclerAdapter.addItem(data2);
        resultRecyclerAdapter.addItem(data3);
        resultRecyclerAdapter.addItem(data4);
        resultRecyclerAdapter.addItem(data5);
        resultRecyclerAdapter.addItem(data6);
        resultRecyclerAdapter.addItem(data7);
        resultRecyclerAdapter.addItem(data8);*/

        //추천
        recommandRecycler = findViewById(R.id.ResultRecommand);
        recommandRecycler.addItemDecoration(new DividerItemDecoration(recommandRecycler.getContext(),DividerItemDecoration.VERTICAL));
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        recommandRecycler.setLayoutManager(linearLayoutManager2);

        recommandRecyclerAdapter = new RecyclerRecommandAdapter();
        recommandRecycler.setAdapter(recommandRecyclerAdapter);

        for(int i=0; i<8; i++) {
            RecyclerRecommand data = new RecyclerRecommand("추천단어"+i);
            recommandRecyclerAdapter.addItem(data);
        }
        /*RecyclerRecommand data11 = new RecyclerRecommand("추천단어1");
        RecyclerRecommand data22 = new RecyclerRecommand("추천단어2");
        RecyclerRecommand data33 = new RecyclerRecommand("추천단어3");
        RecyclerRecommand data44 = new RecyclerRecommand("추천단어4");
        RecyclerRecommand data55 = new RecyclerRecommand("추천단어5");
        RecyclerRecommand data66 = new RecyclerRecommand("추천단어6");
        RecyclerRecommand data77 = new RecyclerRecommand("추천단어7");
        RecyclerRecommand data88 = new RecyclerRecommand("추천단어8");

        recommandRecyclerAdapter.addItem(data11);
        recommandRecyclerAdapter.addItem(data22);
        recommandRecyclerAdapter.addItem(data33);
        recommandRecyclerAdapter.addItem(data44);
        recommandRecyclerAdapter.addItem(data55);
        recommandRecyclerAdapter.addItem(data66);
        recommandRecyclerAdapter.addItem(data77);
        recommandRecyclerAdapter.addItem(data88);
*/
    }
}
