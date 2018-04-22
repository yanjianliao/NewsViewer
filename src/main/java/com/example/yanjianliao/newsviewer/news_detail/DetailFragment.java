package com.example.yanjianliao.newsviewer.news_detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanjianliao.newsviewer.R;
import com.example.yanjianliao.newsviewer.data.Article;

public class DetailFragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Article article = null;

        if(getActivity() != null)
            article = getActivity().getIntent().getParcelableExtra("article");

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new DetailAdapter(article));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }




}
