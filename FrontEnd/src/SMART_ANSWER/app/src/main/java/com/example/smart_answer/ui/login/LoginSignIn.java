
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

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class LoginSignIn extends AppCompatActivity {
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
        setContentView(R.layout.sign_in);

        Button loginButton = (Button)findViewById(R.id.button_sign_in);
        Button registerButton= (Button)findViewById(R.id.button_register);
        final EditText ID = (EditText)findViewById(R.id.ID);
        final EditText PWD = (EditText)findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputID = ID.getText().toString();
                inputPWD = PWD.getText().toString();
                Call<LoginData> responseData = service.getLoginData(inputID);
                responseData.enqueue(new Callback<LoginData>() {
                    @Override
                    public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                        try{
                            if (response.isSuccessful()) {
                                messageDebug = "ID, password를 확인 해 주세요";
                                userID = response.body().getData().getUsername();
                                userPWD = response.body().getData().getPassword();
                                loginSuccess(inputID, inputPWD);
                            } else {
                                messageDebug = "response failed";
                                loginFailed();
                            }
                        }
                        catch(Exception e) {
                            Log.d("My Tag", response.body().toString());
                        }
                    }
                    @Override
                    public void onFailure(Call<LoginData> call, Throwable t) {
                        messageDebug = t.toString();
                        loginFailed();
                    }
                });
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginRegister.class);
                startActivity(intent);
            }
        });
    }

    public void loginSuccess(String inputID, String inputPWD) {
        if (userID.equals(inputID) && userPWD.equals(inputPWD)) {
            messageDebug = userID +"님 로그인 하였습니다.";
            Toast.makeText(getApplicationContext(), messageDebug,
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        else
            loginFailed();
    }

    public void loginFailed() {
        Toast.makeText(getApplicationContext(), messageDebug,
                Toast.LENGTH_SHORT).show();
    }
}