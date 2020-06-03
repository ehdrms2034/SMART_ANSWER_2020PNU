package com.example.smart_answer.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static String userID = "";
    public static String userPWD = "";

    RetrofitInterface service = retrofit.create(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_rester);
        final EditText ID = (EditText)findViewById(R.id.ID);
        final EditText PWD = (EditText)findViewById(R.id.password);
        Button check = (Button)findViewById(R.id.button_ID_check);
        Button register = (Button)findViewById(R.id.button_register);


        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputID = ID.getText().toString();
                if(!inputID.equals(""))
                    buttonCheckClick(inputID);
                else
                    ;
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputID = ID.getText().toString();
                String inputPWD = PWD.getText().toString();
                buttonRegisterClick(inputID, inputPWD);
            }
        });
    }

    public void buttonCheckClick(String inputID) {
        Call<LoginData> responseID = service.getLoginData(inputID);
        responseID.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                if (response.isSuccessful()) {
                    LoginData body = response.body();
                    if (body != null) {
                        userID = body.getData().getPassword();
                        userPWD = body.getData().getPassword();
                        registerSuccess();
                    }
                    else
                        registerFailed();
                }
                else
                    responseFailed();
            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                responseFailed();
//                Log.e(TAG, "onFailure(): " + t.getMessage());
            }
        });
    }

    public void buttonRegisterClick(String inputID, String inputPWD) {
        Call<LoginData> responseID = service.postUser(inputID, inputID, inputPWD);
        responseID.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                if (response.isSuccessful()) {

                }
                else
                    responseFailed();
            }
            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                responseFailed();
//                Log.e(TAG, "onFailure(): " + t.getMessage());
            }
        });
    }

    public void registerSuccess() {
        Toast.makeText(getApplicationContext(), userID + " " + userPWD,
                Toast.LENGTH_SHORT).show();
    }

    public void registerFailed() {
        Toast.makeText(getApplicationContext(), "아이디 확인바람",
                Toast.LENGTH_SHORT).show();
    }

    public void responseFailed() {
        Toast.makeText(getApplicationContext(), "연결 실패",
                Toast.LENGTH_SHORT).show();
    }
}
