package com.example.test;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.model.ChapterEducation;
import com.example.classes.DatabaseFactory;

import java.util.ArrayList;
import java.util.List;

public class SpecificLessonActivity extends AppCompatActivity {

    ImageView imageLesson;
    TextView titleLesson;
    String title, url, id;
    ProgressBar progressBar;
    List<ChapterEducation> listLessonsByChapter = new ArrayList<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_lesson);

        // set color in status bar
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusBarNew));

        imageLesson = findViewById(R.id.imageLesson);
        titleLesson = findViewById(R.id.titleLesson);

        intent = getIntent();
        id = intent.getStringExtra("id");
        title = intent.getStringExtra("titleLesson");
        url = intent.getStringExtra("url");
        String chapter = intent.getStringExtra("chapter");

        for (int i = 0; i < DatabaseFactory.listAllLessons.size(); i++) {
            if (intent.hasExtra("chapter")) {
                if (chapter.equals(DatabaseFactory.listAllLessons.get(i).getNameOfChapter())) {
                    listLessonsByChapter.add(DatabaseFactory.listAllLessons.get(i));
                }
            }
            else {
                listLessonsByChapter.add(DatabaseFactory.listAllLessons.get(i));
            }
        }

        setResources(url, title);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        if (!intent.hasExtra("chapter")) {
            progressBar.setVisibility(View.INVISIBLE);
        } else {
            progressBar.setMax(listLessonsByChapter.size());
            progressBar.setProgress(0);
            for (int i = 0; i < listLessonsByChapter.size(); i++) {
                if (listLessonsByChapter.get(i).getIsImageCorrect() != 0) {
                    progressBar.setProgress(progressBar.getProgress() + 1);
                }
            }
        }

        clickOnLesson();
    }

    public void setResources(String url, String title) {
        titleLesson.setText(title);
        Glide.with(this)
                .asGif()
                .load(url)
                .skipMemoryCache(true)
                .into(imageLesson);
    }

    public void clickOnLesson() {
        Button btn = findViewById(R.id.continueBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                ChapterEducation item = listLessonsByChapter.get(listLessonsByChapter.size() - 1);
                for (int i = 0; i < listLessonsByChapter.size(); i++) {
                    if ((listLessonsByChapter.get(i).getId() + "").equals(id)){
                        if (item == listLessonsByChapter.get(i)) {
                            finish();
                            return;
                        }
                        item = listLessonsByChapter.get(++i);
                        if (intent.hasExtra("chapter")) {
                            progressBar.setProgress(progressBar.getProgress() + 1);
                        }
                    }
                }

                title = item.getNameOfLesson();
                url = item.getUrl();
                id = item.getId() + "";
                setResources(url, title);
            }
        });
    }
}