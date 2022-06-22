package com.example.learninge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    public  static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        TextView loginwarning = findViewById(R.id.registerwarning);
        loginwarning.setVisibility(View.INVISIBLE);
        TextView inputemail = findViewById(R.id.register_email);
        TextView repeatpw = findViewById(R.id.repeatpw);
        TextView registerpw = findViewById(R.id.registerpw);
        Button Register = findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid(inputemail.getText().toString())){
                    loginwarning.setText("Địa chỉ email không hợp lệ");
                    loginwarning.setVisibility(View.VISIBLE);
                }
                else if(registerpw.getText().toString().isEmpty()||registerpw.getText().toString().length()<6){
                    loginwarning.setText("Password của bạn quá ngắn");
                    loginwarning.setVisibility(View.VISIBLE);
                }
                else if(repeatpw.getText() == registerpw.getText()){
                    loginwarning.setText("Password của bạn không trùng khớp");
                    loginwarning.setVisibility(View.VISIBLE);
                }
                else {
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.createUserWithEmailAndPassword(inputemail.getText().toString(),registerpw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Tạo tài khoản thành công",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Register.this,Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Tạo tài khoản không thành công",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
        Button login = findViewById(R.id.register_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
    }
}