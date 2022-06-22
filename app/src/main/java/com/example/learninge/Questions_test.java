package com.example.learninge;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;


public class Questions_test extends Fragment {
    questions question;


    public Questions_test(questions question) {
        // Required empty public constructor
        this.question = question;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view= (ViewGroup) inflater.inflate(
                R.layout.fragment_questions_test, container, false);
        TextView textView = view.findViewById(R.id.question);
        textView.setText(question.question);
        String[] answer = question.answers.split(",");
        RadioButton A = view.findViewById(R.id.A);
        A.setText(answer[0]);
        RadioButton B = view.findViewById(R.id.B);
        B.setText(answer[1]);
        RadioButton C = view.findViewById(R.id.C);
        C.setText(answer[2]);
        RadioButton D = view.findViewById(R.id.D);
        D.setText(answer[3]);
        return view;


    }
    private Bundle questionToBundle(questions question)  {
        Bundle bundle = new Bundle();
        bundle.putString("question", question.question);
        bundle.putString("answers", question.answers);
        bundle.putString("true_answer", question.true_answer);

        return bundle;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Bundle dataBundle = this.questionToBundle(this.question);
        outState.putAll(dataBundle);

        super.onSaveInstanceState(outState);
    }
    private questions bundleToquestion(Bundle savedInstanceState) {
        String question = savedInstanceState.getString("question");
        String answers = savedInstanceState.getString("answers");
        String true_answer = savedInstanceState.getString("true_answer");
        return new questions(question, answers, true_answer);
    }
}