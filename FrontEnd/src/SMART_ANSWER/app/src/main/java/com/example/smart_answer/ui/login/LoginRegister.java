package com.example.smart_answer.ui.login;

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
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://54.180.175.238:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static String userID = "";
    private static String userPWD = "";
    public static String messageDebug = "";
    public static String inputID = "";
    public static String inputPWD = "";

    RetrofitInterface service = retrofit.create(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_rester);
        final EditText ID = (EditText)findViewById(R.id.ID);
        final EditText PWD = (EditText)findViewById(R.id.password);
        Button register = (Button)findViewById(R.id.button_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputID = ID.getText().toString();
                inputPWD = PWD.getText().toString();
                buttonRegisterClick(inputID, inputPWD);
            }
        });
    }

    public void buttonRegisterClick(String inputID, String inputPWD) {
        LoginPostBody loginPostBody = new LoginPostBody(inputID, inputID, inputPWD);
        Call<JsonObject> responseID = service.postUser(loginPostBody);
        responseID.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    messageDebug = response.body().toString();
                    registerSuccess();
                }
                else {
                    messageDebug = "Response failed\nError code: " + Integer.toString(response.code());
                    registerFailed();
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                messageDebug = t.toString();
                registerFailed();
            }
        });
    }

    public void registerSuccess() {
        Toast.makeText(getApplicationContext(), messageDebug,
                Toast.LENGTH_SHORT).show();
        //finish();
    }

    public void registerFailed() {
        Toast.makeText(getApplicationContext(), messageDebug,
                Toast.LENGTH_SHORT).show();
    }

}
