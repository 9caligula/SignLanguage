package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // set color in status bar
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.statusBarNew));

        findViewById(R.id.info).setOnClickListener(this);
        findViewById(R.id.search).setOnClickListener(this);

        findViewById(R.id.cardViewAlphabet).setOnClickListener(this);
        findViewById(R.id.cardViewPronouns).setOnClickListener(this);
        findViewById(R.id.cardViewAdjectives).setOnClickListener(this);
        findViewById(R.id.cardViewPolite_words).setOnClickListener(this);
        findViewById(R.id.cardViewMoney).setOnClickListener(this);
        findViewById(R.id.cardViewPeople).setOnClickListener(this);
        findViewById(R.id.cardViewDocuments).setOnClickListener(this);
        findViewById(R.id.cardViewColors).setOnClickListener(this);
        findViewById(R.id.cardViewFamily).setOnClickListener(this);
        findViewById(R.id.cardViewQuestions).setOnClickListener(this);

        ImageView home = findViewById(R.id.home);
        home.setImageResource(R.drawable.homelight);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.info:
                Intent intent = new Intent(MainMenuActivity.this, InfoActivity.class);
                startActivity(intent);
                break;
            case R.id.search:
                intent = new Intent(MainMenuActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.cardViewAlphabet:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Алфавит");
                startActivity(intent);
                break;
            case R.id.cardViewPronouns:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Местоимения");
                startActivity(intent);
                break;
            case R.id.cardViewAdjectives:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Прилагательные");
                startActivity(intent);
                break;
            case R.id.cardViewPolite_words:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Вежливые слова");
                startActivity(intent);
                break;
            case R.id.cardViewMoney:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Деньги");
                startActivity(intent);
                break;
            case R.id.cardViewPeople:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Люди");
                startActivity(intent);
                break;
            case R.id.cardViewDocuments:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Документы");
                startActivity(intent);
                break;
            case R.id.cardViewColors:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Цвета");
                startActivity(intent);
                break;
            case R.id.cardViewFamily:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Семья");
                startActivity(intent);
                break;
            case R.id.cardViewQuestions:
                intent = new Intent(MainMenuActivity.this, LessonsActivity.class);
                intent.putExtra("idActivity", "Вопросы");
                startActivity(intent);
                break;
        }
    }
}