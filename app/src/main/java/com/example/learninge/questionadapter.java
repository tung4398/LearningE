package com.example.learninge;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.List;

public class questionadapter extends FragmentStateAdapter {
    List<questions> questionsList;

    public questionadapter(@NonNull FragmentActivity fragmentActivity, List<questions> questionsList) {
        super(fragmentActivity);
        this.questionsList = questionsList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        questions question = this.questionsList.get(position);
        return new Questions_test(question);

    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}

