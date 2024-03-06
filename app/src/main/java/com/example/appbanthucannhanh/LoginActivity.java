package com.example.appbanthucannhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbanthucannhanh.classes.ProgressHelper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    EditText edtAccount, edtPassword;
    Button btnLogin, btnSignUp;
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
                if (!account.isEmpty() && !password.isEmpty()) {
                    firebaseLogin(account, password);
                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
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
        btnSignUp = findViewById(R.id.btnSignUp);
    }
    void firebaseLogin(final String account, final String password) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .whereEqualTo("user_account", account)
                .whereEqualTo("user_password", password)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // Đăng nhập thành công
                            ProgressHelper.dismissDialog();
                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

                            // TODO: Chuyển sang màn hình chính hoặc màn hình mong muốn
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Đăng nhập thất bại
                            ProgressHelper.dismissDialog();
                            Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        ProgressHelper.dismissDialog();
                        Toast.makeText(LoginActivity.this, "Đăng nhập thất bại. Vui lòng thử lại sau.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}