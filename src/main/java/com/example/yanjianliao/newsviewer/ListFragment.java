package com.example.yanjianliao.newsviewer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.yanjianliao.newsviewer.data.Article;
import com.example.yanjianliao.newsviewer.data.News;
import com.example.yanjianliao.newsviewer.news_list.ListAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListFragment extends android.support.v4.app.Fragment {

    private OkHttpClient client;
    private String data;
    private ListAdapter adapter;
    private int count = 0;
    RecyclerView recyclerView;
    public String URL = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        client = new OkHttpClient();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);
        new LoadTask(URL).execute();
    }

    private List<Article> newData(List<Article> data){

        List<Article> fiveArticles = new ArrayList<>();

        for(int i = 0; i < 5 && i + count < data.size(); i++){
            fiveArticles.add(data.get(i + count));
        }

        count += 5;

        return fiveArticles;
    }


    private class LoadTask extends AsyncTask<Void, Void, String> {
        String url;
        public LoadTask(String str){
            this.url = str;
        }
        //在background线程 不是UI线程
        @Override
        protected String doInBackground(Void... voids) {

            Request request = new Request.Builder()
                    .url(url)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }

        //参数就是 doInBackground() 函数的返回值 在UI线程执行
        @Override
        protected void onPostExecute(String s) {
            data = s;
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<News> jsonAdapter = moshi.adapter(News.class);

            if(data != null) {
                News allNews = null;
                try {
                    allNews = jsonAdapter.fromJson(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //System.out.println(allNews);
                final List<Article> articles = allNews.articles;
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new ListAdapter(new ArrayList<Article>(), new ListAdapter.ProgressBarAppears() {
                    @Override
                    public void loadMoreItem() {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                //Thread.sleep(500);
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(count >= articles.size()){
                                            adapter.setShowProgressBar(false);
                                        }
                                        adapter.addMoreItems(newData(articles));
                                    }
                                });


                            }
                        }).start();
                    }
                });

                recyclerView.setAdapter(adapter);
            }
        }
    }

}
