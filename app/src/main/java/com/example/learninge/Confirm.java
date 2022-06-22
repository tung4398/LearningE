package com.example.learninge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = this.getIntent();
        String level = intent.getStringExtra("level");
        String leveldata = intent.getStringExtra("leveldata");
        TextView textconfirm = findViewById(R.id.textconfirm);
        textconfirm.setText(String.format("Bài kiểm tra gồm 20 câu với trình độ %s. Bạn có muốn làm không ?",level));
        Button button = findViewById(R.id.buttonconfirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Confirm.this,Test.class);
                intent1.putExtra("leveldata",leveldata);
                startActivity(intent1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}