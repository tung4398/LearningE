package com.example.learninge;

import static com.example.learninge.MainActivity.result;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mainadapter extends RecyclerView.Adapter<mainadapter.ViewHolder> {
    private List<String> level;
    private Context context;
    public mainadapter(Context context,List<String> level){
        this.context = context;
        this.level = level;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View levelview = inflater.inflate(R.layout.activity_main3,parent,false);
        ViewHolder viewHolder = new ViewHolder(levelview);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String stringlevel = level.get(position);
        holder.levelstring.setText(stringlevel);

    }

    @Override
    public int getItemCount() {
        return level.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView levelstring;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            levelstring = itemView.findViewById(R.id.level);
            button = itemView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition() == 0){
                    Intent intent = new Intent(context,Confirm.class);
                    intent.putExtra("level","cơ bản");
                    intent.putExtra("leveldata","easy");
                    result.clear();
                    context.startActivity(intent);

                    }
                    if (getAdapterPosition() == 1){
                    Intent intent = new Intent(context,Confirm.class);
                    intent.putExtra("level","trung bình - khá");
                    intent.putExtra("leveldata","medium");
                    result.clear();
                    context.startActivity(intent);

                    }
                    if (getAdapterPosition() == 2) {
                    Intent intent = new Intent(context,Confirm.class);
                    intent.putExtra("level","giỏi");
                    intent.putExtra("leveldata","hard");
                    result.clear();
                    context.startActivity(intent);
                    }
                }
            });


        }
    }

}