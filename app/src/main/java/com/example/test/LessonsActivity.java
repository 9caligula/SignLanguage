package com.example.test;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classes.DatabaseFactory;
import com.example.classes.MyAdapter;
import com.example.model.ChapterEducation;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<ChapterEducation> listLessonsByChapter = new ArrayList<>();
    String idActivity;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        // set color in status bar
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusBarNew));

        idActivity = getIntent().getStringExtra("idActivity");
        for (int i = 0; i < DatabaseFactory.listAllLessons.size(); i++){
            if (idActivity.equals(DatabaseFactory.listAllLessons.get(i).getNameOfChapter())){
                listLessonsByChapter.add(DatabaseFactory.listAllLessons.get(i));
            }
        }

        // сетаем текст активити бара
        TextView titleText = findViewById(R.id.titleLesson);
        if (!listLessonsByChapter.isEmpty()) {
            titleText.setText(listLessonsByChapter.get(0).getNameOfChapter());
        }

        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, listLessonsByChapter);
        mRecyclerView.setAdapter(myAdapter);

        returnBackOnActivity();
    }


    public void returnBackOnActivity(){
        ImageView iv = findViewById(R.id.home);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}