package com.example.classes;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView nameOfChapter, nameOfLesson;
    ImageView mCorrectImage;
    ItemClickListener itemClickListener;
    Button btn;

    public MyHolder(@NonNull View itemView) {
        super(itemView);

        this.nameOfLesson = itemView.findViewById(R.id.nameOfLesson);
        this.nameOfChapter = itemView.findViewById(R.id.nameOfChapter);
        this.mCorrectImage = itemView.findViewById(R.id.correctResultIcon);
        this.btn = itemView.findViewById(R.id.continueBtn);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}