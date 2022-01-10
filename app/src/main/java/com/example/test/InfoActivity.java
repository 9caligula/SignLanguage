package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.classes.DatabaseFactory;

public class InfoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // set color in status bar
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusBarNew));

        ImageView info = findViewById(R.id.info);
        info.setImageResource(R.drawable.infolight);

        TextView numberOfGestures = findViewById(R.id.numberOfGestures);
        numberOfGestures.setText("Всего жестов: " + DatabaseFactory.listAllLessons.size());

        TextView numberLearned = findViewById(R.id.numberLearned);
        long count = MainActivity.factory.getList()
                .stream()
                .filter((item) -> item.getIsImageCorrect() == 1)
                .count();
        numberLearned.setText("Выучено жестов: " + count);

        ImageView home = (ImageView) findViewById(R.id.home);
        ImageView search = findViewById(R.id.search);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}