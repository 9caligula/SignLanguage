package com.example.model;

public class ChapterEducation {
    private int id;
    private String nameOfChapter;
    private String nameOfLesson;
    private int isImageCorrect;
    private String url;

    public ChapterEducation(){}

    public ChapterEducation(int id, String nameOfChapter, String nameOfLesson, int isImageCorrect,
                            String url) {
        this.id = id;
        this.nameOfChapter = nameOfChapter;
        this.nameOfLesson = nameOfLesson;
        this.isImageCorrect = isImageCorrect;
        this.url = url;
    }

    public void setIsImageCorrect(int isImageCorrect) {
        this.isImageCorrect = isImageCorrect;
    }

    public int getId() {
        return id;
    }

    public String getNameOfChapter() {
        return nameOfChapter;
    }

    public String getNameOfLesson() {
        return nameOfLesson;
    }

    public int getIsImageCorrect() {
        return isImageCorrect;
    }

    public String getUrl() {
        return url;
    }
}