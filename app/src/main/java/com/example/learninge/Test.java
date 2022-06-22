package com.example.learninge;


import static com.example.learninge.MainActivity.result;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Test extends AppCompatActivity {
    public DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);



        Button next = findViewById(R.id.Next);
        Button previous = findViewById(R.id.Previous);
        Button submit = findViewById(R.id.submit);
        Intent intent = this.getIntent();
        String leveldata = intent.getStringExtra("leveldata");
        List<questions> questionsList = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child(leveldata).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot i : snapshot.getChildren()) {


                    String question = i.child("question").getValue().toString();
                    String answers = i.child("answers").getValue().toString();
                    String true_answer = i.child("true_answer").getValue().toString();
                    questions ques = new questions(question, answers, true_answer);

                    questionsList.add(ques);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Test.this,"123",Toast.LENGTH_LONG).show();
            }
        });
        ViewPager2 test = findViewById(R.id.test);
        questionadapter questionadapter = new questionadapter(this,questionsList);
        test.setAdapter(questionadapter);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view =test.getChildAt(test.getCurrentItem());
                test.setCurrentItem(test.getCurrentItem() + 1);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test.setCurrentItem(test.getCurrentItem() - 1);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point;
                if (result.size() == 0){
                    point = 0;
                }
                else{
                    point = 5*result.size();
                }
                String point1 = String.valueOf(point);
                Intent intent1 = new Intent(getApplicationContext(),Result.class);
                intent1.putExtra("point",point1);
                startActivity(intent1);
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