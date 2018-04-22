package com.example.yanjianliao.newsviewer.news_list;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yanjianliao.newsviewer.R;
import com.example.yanjianliao.newsviewer.data.Article;
import com.example.yanjianliao.newsviewer.news_detail.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter {

    ArrayList<Article> articles;
    final int GRID = 0;
    final int PROGRESS = 1;
    Context parent;
    ProgressBarAppears progressBarAppears;
    private boolean showProgressBar;

    public ListAdapter(ArrayList<Article> articles,  ProgressBarAppears progressBarAppears){
        this.progressBarAppears = progressBarAppears;
        this.showProgressBar = true;
        this.articles = articles;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        this.parent = parent.getContext();
        if(viewType == GRID) {

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
            return new ListHolder(view);
        }

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progressbar, parent, false);

        return new RecyclerView.ViewHolder(view) {};
        }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);

        if(type == GRID) {

            ListHolder listHolder = (ListHolder) holder;
            final Article article = articles.get(position);
            listHolder.articleTitle.setText(article.title);
            listHolder.likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    article.save();
                    Toast.makeText(holder.itemView.getContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            });
            listHolder.like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    article.save();
                    Toast.makeText(holder.itemView.getContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            });
            listHolder.publishDate.setText("\n" + article.publishedAt);
            if(article.urlToImage != null){
                Picasso.get().load(article.urlToImage).into(listHolder.imageView);
            }else{
                listHolder.imageView.setImageResource(R.drawable.images);
            }



            listHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = holder.itemView.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("article", article);
                    context.startActivity(intent);


                }
            });
        }else{

            progressBarAppears.loadMoreItem();

        }


    }

    public void addMoreItems(List<Article> newData){
        articles.addAll(newData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return showProgressBar ? articles.size() + 1 : articles.size();
    }

    public void setShowProgressBar(boolean b){
        showProgressBar = b;
    }


    @Override
    public int getItemViewType(int position) {
        if(position < articles.size()){
            return GRID;
        }

        return PROGRESS;
    }

    public interface ProgressBarAppears{

        void loadMoreItem();

    }

}
