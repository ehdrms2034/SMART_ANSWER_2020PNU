
        package com.example.smart_answer.ui.login;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
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

public class LoginSignIn extends AppCompatActivity {
    // Retrofit Connection

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://15.164.212.98:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    /*
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
     */
    public static String userID = "";
    public static String userPWD = "";

    RetrofitInterface service = retrofit.create(RetrofitInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        Button loginButton = (Button)findViewById(R.id.button_sign_in);

        final EditText ID = (EditText)findViewById(R.id.ID);
        final EditText PWD = (EditText)findViewById(R.id.password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String ID.getText().toString();
                Call<LoginData> responseData = service.getUserData(ID.getText().toString());
                responseData.enqueue(new Callback<LoginData>() {
                    @Override
                    public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                        if (response.isSuccessful()) {
//                    Log.i(TAG, "onResponse(): " + response.body().toString());

                            userID = response.body().getData().getUsername();
                            userPWD = response.body().getData().getPassword();
                            /* RestApi recieve as JsonObject
                            userID = response.body().getAsJsonObject("data")
                                .get("username").getAsString();
                            userPWD = response.body().getAsJsonObject("data")
                                    .get("password").getAsString();
                            // Git Api
                            userID = response.body().get("login").getAsString() ;
                            userPWD = response.body().get("id").getAsString() ;
                             */
                        }
                        // JsonArray로 받을때 이렇게 했었다.
                        // textView.setText(response.body().get(0).getAsJsonObject().get("id").getAsString());
                    }
                    @Override
                    public void onFailure(Call<LoginData> call, Throwable t) {
                        loginFailed();
//                Log.e(TAG, "onFailure(): " + t.getMessage());
                    }
                });

                if(userID.equals(ID.getText().toString()) && userPWD.equals(PWD.getText().toString())) {
                    //로그인 성공!!
                    loginSuccess();
                    finish();
                }
                else{
                    //로그인 실패!!
                    loginFailed();
                }
            }
        });
    }
    /*
    public boolean isLoginSuccess() {

    }
    
     */

    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "로그인 성공!",
                Toast.LENGTH_SHORT).show();
    }

    public void loginFailed() {
        Toast.makeText(getApplicationContext(), "아이디 패스워드 확인바람",
                Toast.LENGTH_SHORT).show();
    }

}