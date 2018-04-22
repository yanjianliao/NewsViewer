package com.example.yanjianliao.newsviewer.news_detail;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yanjianliao.newsviewer.R;


public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setUpFragment();

    }

    public void setUpFragment() {

        DetailFragment detailFragment = new DetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailFragment, detailFragment)
                .commit();

    }
}


