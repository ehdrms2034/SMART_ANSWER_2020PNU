package com.example.smart_answer.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smart_answer.R;
import com.example.smart_answer.retrofit.RetrofitInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRegister extends AppCompatActivity {
    // Retrofit Connection
    /*
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
     */
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("3.34.124.52:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static String userID = "";
    public static String userPWD = "";

    RetrofitInterface service = retrofit.create(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Button check = (Button)findViewById(R.id.button_sign_in);
        Button register = (Button)findViewById(R.id.button_register);
        final EditText ID = (EditText)findViewById(R.id.ID);
        final EditText PWD = (EditText)findViewById(R.id.password);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String ID.getText().toString();
                Call<JsonObject> responseID = service.getUserID(ID.getText().toString());
                responseID.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
//                    Log.i(TAG, "onResponse(): " + response.body().toString());
                            userID = response.body().get("login").getAsString() ;
                            userPWD = response.body().get("id").getAsString() ;

                        }
                        // JsonArray로 받을때 이렇게 했었다.
                        // textView.setText(response.body().get(0).getAsJsonObject().get("id").getAsString());
                    }
                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        registerFailed();
//                Log.e(TAG, "onFailure(): " + t.getMessage());
                    }
                });

                if(userID.equals(ID.getText().toString()) && userPWD.equals(PWD.getText().toString())) {
                    //회원가입 성공!!
                    registerSuccess();
                    finish();
                }
                else{
                    //회원가입 실패!!
                    registerFailed();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginRegister.class);
                startActivity(intent);
            }
        });
    }
    /*
    public boolean isLoginSuccess() {

    }

     */

    public void registerSuccess() {
        Toast.makeText(getApplicationContext(), "로그인 성공!",
                Toast.LENGTH_SHORT).show();
    }

    public void registerFailed() {
        Toast.makeText(getApplicationContext(), "아이디 패스워드 확인바람",
                Toast.LENGTH_SHORT).show();
    }

}
