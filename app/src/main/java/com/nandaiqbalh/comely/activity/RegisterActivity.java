package com.nandaiqbalh.comely.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nandaiqbalh.comely.R;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    // TODO: DEKLARASI MEMBER VARIABEL
    TextView tv_sign_in;
    Button btn_sign_up;

    TextView edtNama, edtEmail, edtPhone, edtPassword;

    TextView tvErrorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // TODO: INISIASI VARIABEL
        tv_sign_in = (TextView) findViewById(R.id.tv_sign_in);
        btn_sign_up = (Button) findViewById(R.id.btn_sign_up);
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtEmail = (EditText) findViewById(R.id.edt_email);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        tvErrorText = (TextView) findViewById(R.id.tv_errortext);

        // function button
        mainButton();
    }

    private void mainButton(){
        tv_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register(){

        String emailInput = edtEmail.getText().toString().trim(); // untuk validasi email
        int phoneInput = edtPhone.getText().length(); // untuk validasi nomor telepon
        String passwordInput = edtPassword.getText().toString().trim(); // untuk validasi password
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

        if (edtNama.getText().toString().isEmpty()) {
            tvErrorText.setText("Name field is required!");
            edtNama.requestFocus();
            return;
        } else if (emailInput.isEmpty()) {
            tvErrorText.setText("Email field is required!");
            edtEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            tvErrorText.setText("The email address you entered is not valid!");
            edtEmail.requestFocus();
            return;
        } else if (edtPhone.getText().toString().isEmpty()) {
            tvErrorText.setText("Phone number field is required!");
            edtPhone.requestFocus();
            return;
        } else if (phoneInput < 10 || phoneInput > 13) {
            tvErrorText.setText("The phone number you entered is not valid!");
            edtPhone.requestFocus();
            return;
        } else if (passwordInput.isEmpty()) {
            tvErrorText.setText("Password field is required!");
            edtPassword.requestFocus();
            return;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            tvErrorText.setText("The password must have at least 8 digits with number and char!");
            edtPassword.requestFocus();
            return;
        }


    }
}