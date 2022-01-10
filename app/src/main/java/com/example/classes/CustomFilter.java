package com.example.classes;

import android.widget.Filter;

import com.example.model.ChapterEducation;

import java.util.ArrayList;
import java.util.List;

public class CustomFilter extends Filter {

    List<ChapterEducation> filterList;
    MyAdapter myAdapter;

    public CustomFilter(List<ChapterEducation> filterList, MyAdapter myAdapter) {
        this.filterList = filterList;
        this.myAdapter = myAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if (constraint != null && constraint.length() > 0) {

            constraint = constraint.toString().toUpperCase();
            List<ChapterEducation> filterChapters = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {
                if (filterList.get(i).getNameOfLesson().toUpperCase().contains(constraint)){
                    filterChapters.add(filterList.get(i));
                }
            }

            filterResults.count = filterChapters.size();
            filterResults.values = filterChapters;
        }
        else {
            filterResults.count = filterList.size();
            filterResults.values = filterList;
        }

        return filterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        myAdapter.chapterEducations = (List<ChapterEducation>) results.values;
        myAdapter.notifyDataSetChanged();
    }
}