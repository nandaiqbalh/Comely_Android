package com.nandaiqbalh.comely.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nandaiqbalh.comely.MainActivity;
import com.nandaiqbalh.comely.R;
import com.nandaiqbalh.comely.fragment.AkunFragment;
import com.nandaiqbalh.comely.helper.SharedPrefs;
import com.nandaiqbalh.comely.model.register.RegisterRequest;
import com.nandaiqbalh.comely.model.register.RegisterResponse;
import com.nandaiqbalh.comely.model.userlogin.LoginRequest;
import com.nandaiqbalh.comely.model.userlogin.LoginResponse;
import com.nandaiqbalh.comely.rest.ApiConfig;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    SharedPrefs s;
    Button loginButton;

    TextView tv_register;

    EditText edtEmailLogin, edtPasswordLogin;
    TextView tvErrorTextLogin;
    ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // inisiasi shared prefs
        s = new SharedPrefs(this);

        // inisiasi button
        loginButton = (Button) findViewById(R.id.btn_login);

        // inisiasi textview
        tv_register = (TextView) findViewById(R.id.tv_register);

        // inisiasi edittext
        edtEmailLogin = (EditText) findViewById(R.id.edt_email_login);
        edtPasswordLogin = (EditText) findViewById(R.id.edt_password_login);

        tvErrorTextLogin = (TextView) findViewById(R.id.tv_errortext_login);

        mainButton();


    }

    private void mainButton(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setEmail(edtEmailLogin.getText().toString());
                loginRequest.setPassword(edtPasswordLogin.getText().toString());

                login(loginRequest);
            }
        });

        // btn register
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void login(LoginRequest loginRequest){

        String emailInput = edtEmailLogin.getText().toString().trim(); // untuk validasi email
        String passwordInput = edtPasswordLogin.getText().toString().trim(); // untuk validasi password
        final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        "(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        // "(?=\\S+$)" +           //no white spaces
                        ".{8,}" +               //at least 8 characters
                        "$");

        if (emailInput.isEmpty()) {
            tvErrorTextLogin.setText("Email field is required!");
            edtEmailLogin.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            tvErrorTextLogin.setText("The email address you entered is not valid!");
            edtEmailLogin.requestFocus();
            return;
        } else if (passwordInput.isEmpty()) {
            tvErrorTextLogin.setText("Password field is required!");
            edtPasswordLogin.requestFocus();
            return;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            tvErrorTextLogin.setText("The password must have at least 8 digits with number and char!");
            edtPasswordLogin.requestFocus();
            return;
        }

        // PROGRESS BAR
        progressBarLogin = (ProgressBar) findViewById(R.id.pb_login);
        progressBarLogin.setVisibility(View.VISIBLE);

        Call<LoginResponse> loginResponseCall = ApiConfig.getService().loginUser(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                progressBarLogin.setVisibility(View.GONE);

                LoginResponse respon = response.body();

                if (respon.getSuccess() == 1) {
                    // berhasil
                    Toast.makeText(LoginActivity.this, "Welcome " + respon.getUser().getName() + "! Successfully Login!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(intent);

                    // set status login
                    s.setStatusLogin(true);

                } else {
                    // gagal
                    Toast.makeText(LoginActivity.this, "Error : " + respon.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressBarLogin.setVisibility(View.GONE);

                String message = t.getLocalizedMessage();
                Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}