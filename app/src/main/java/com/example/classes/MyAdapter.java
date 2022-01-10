package com.example.classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.ChapterEducation;
import com.example.test.LessonsActivity;
import com.example.test.R;
import com.example.test.SpecificLessonActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> implements Filterable {

    Context c;
    List<ChapterEducation> chapterEducations, filterList;
    CustomFilter filter;

    public MyAdapter(Context c, List<ChapterEducation> chapterEducations) {
        this.c = c;
        this.chapterEducations = chapterEducations;
        filterList = chapterEducations;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.nameOfChapter.setText(chapterEducations.get(position).getNameOfChapter());
        holder.nameOfLesson.setText(chapterEducations.get(position).getNameOfLesson());
        if (chapterEducations.get(position).getIsImageCorrect() == 1) {
            holder.mCorrectImage.setImageResource(R.drawable.tick);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String id = chapterEducations.get(position).getId() + "";
                String chapter = chapterEducations.get(position).getNameOfChapter();
                String titleLesson = chapterEducations.get(position).getNameOfLesson();
                String url = chapterEducations.get(position).getUrl();

                // TODO добавить описание + ренейм полей в холдере ибо они пересекаются и кофликтуют

                Intent intent = new Intent(c, SpecificLessonActivity.class);
                if (c.getClass().getName().equals(LessonsActivity.class.getName())){
                    intent.putExtra("chapter", chapter);
                }
                intent.putExtra("id", id);
                intent.putExtra("url", url);
                intent.putExtra("titleLesson", titleLesson);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterEducations.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter(filterList, this);
        }
        return filter;
    }
}