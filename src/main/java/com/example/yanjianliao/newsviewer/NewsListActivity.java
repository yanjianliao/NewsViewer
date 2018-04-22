package com.example.yanjianliao.newsviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setUpFragment();

        //TODO : pass different url to setUpFragment() function to get different types of news
    }


    public void setUpFragment(){
        ListFragment listFragment = new ListFragment();
        listFragment.URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=035f26937eb1473991f5b45dce9220a8";
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, listFragment)
                .commit();

    }
}
