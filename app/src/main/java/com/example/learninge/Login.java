package com.example.learninge;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    public  static boolean isValid(String email) {
        String regex = "^(.+)@(.+)$";
        return email.matches(regex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView loginwarning = findViewById(R.id.loginwarning);
        loginwarning.setVisibility(View.INVISIBLE);
        TextView inputemail = findViewById(R.id.LoginEmail);
        TextView inputpw = findViewById(R.id.loginpw);
        Button login = findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (isValid(inputemail.getText().toString())){
//                    loginwarning.setText("Địa chỉ email không hợp lệ");
//                    loginwarning.setVisibility(View.VISIBLE);
//                }
//                else
                    if(inputpw.getText().toString().isEmpty()||inputpw.getText().toString().length()<6){
                    loginwarning.setText("Password của bạn quá ngắn");
                    loginwarning.setVisibility(View.VISIBLE);
                }
                else {
                    mAuth = FirebaseAuth.getInstance();
                    mAuth.signInWithEmailAndPassword(inputemail.getText().toString(),inputpw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent = new Intent(Login.this,MainActivity2.class);
                                startActivity(intent);
                            }
                            else {
                                loginwarning.setText("Email hoặc password của bạn đã sai");
                                loginwarning.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        });
        Button register = findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
    }
}