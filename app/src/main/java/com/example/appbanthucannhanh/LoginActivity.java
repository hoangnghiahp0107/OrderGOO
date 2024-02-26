package com.example.appbanthucannhanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addControls();
        addEvents();
    }
    private void addEvents(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = edtAccount.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if(account.isEmpty())
                {
                    edtAccount.setError("Vui lòng nhập tài khoản");
                }
                if(password.isEmpty())
                {
                    edtPassword.setError("Vui lòng nhập mật khẩu");
                }
                if(!account.isEmpty() && !password.isEmpty())
                {
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
    private void addControls(){
        edtAccount = findViewById(R.id.edtAccount);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }
}