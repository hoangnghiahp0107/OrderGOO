package com.example.appbanthucannhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbanthucannhanh.classes.ProgressHelper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button btnRegister;
    EditText edtAccount, edtName, edtPhone, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        addControls();
        addEvents();
    }
    private void addEvents()
    {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput() == true)
                {
                    ProgressHelper.showDialog(RegisterActivity.this,"Loading...");
                    firebaseRegisterNewUser();
                }
            }
        });
    }
    boolean checkInput() {
        if (edtAccount.getText().toString().length() < 6) {
            edtAccount.setError("Tài khoản phải chứa ít nhất 6 ký tự");
            return false;
        }

        if (edtName.getText().toString().length() < 5) {
            edtName.setError("Họ tên phải chứa ít nhất 5 ký tự.");
            return false;
        }

        if (edtPhone.getText().toString().length() < 10) {
            edtPhone.setError("Số điện thoại phải ít nhất 10 ký tự");
            return false;
        }

        if (edtPassword.getText().toString().length() < 6) {
            edtPassword.setError("Mật khẩu phải chứa ít nhất 6 ký tự.");
            return false;
        }
        return true;
    }
    private void addControls()
    {
        btnRegister = findViewById(R.id.btnRegister);
        edtAccount = findViewById(R.id.edtAccount);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
    }
    void firebaseRegisterNewUser() {
        final String account = edtAccount.getText().toString().trim();

        // Kiểm tra xem tài khoản đã tồn tại hay chưa
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .whereEqualTo("user_account", account)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {
                            // Tài khoản chưa tồn tại, thêm người dùng mới
                            Map<String, Object> user = new HashMap<>();
                            user.put("user_account", account);
                            user.put("user_name", edtName.getText().toString().trim());
                            user.put("user_phone", edtPhone.getText().toString().trim());
                            user.put("user_password", edtPassword.getText().toString().trim());
                            user.put("user_address", "");
                            user.put("user_role", "user");

                            db.collection("users")
                                    .add(user)
                                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                        @Override
                                        public void onSuccess(DocumentReference documentReference) {
                                            ProgressHelper.dismissDialog();
                                            Log.d("SignUpActivity", "DocumentSnapshot added with ID: " + documentReference.getId());

                                            // Chuyển đến màn hình đăng nhập hoặc thực hiện các bước khác
                                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                            startActivity(i);
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            ProgressHelper.dismissDialog();
                                            Log.w("SignUpActivity", "Error adding document", e);
                                        }
                                    });
                        } else {
                            // Tài khoản đã tồn tại, hiển thị thông báo hoặc xử lý theo ý muốn
                            ProgressHelper.dismissDialog();
                            Toast.makeText(RegisterActivity.this, "Tài khoản đã tồn tại. Vui lòng chọn tài khoản khác.", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        ProgressHelper.dismissDialog();
                        Log.w("SignUpActivity", "Error checking account existence", e);
                    }
                });
    }
}