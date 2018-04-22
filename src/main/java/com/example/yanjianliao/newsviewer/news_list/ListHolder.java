package com.example.yanjianliao.newsviewer.news_list;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanjianliao.newsviewer.R;


public class ListHolder extends ViewHolder{

    TextView like;
    ImageView imageView;
    TextView articleTitle;
    TextView publishDate;
    TextView share;
    ImageButton likeButton;
    ImageButton shareButton;


    public ListHolder(View itemView) {
        super(itemView);
        likeButton = itemView.findViewById(R.id.likeCountImageList);
        share = itemView.findViewById(R.id.shareCountTextList);
        shareButton = itemView.findViewById(R.id.shareCountImageList);
        like = itemView.findViewById(R.id.likeCountTextList);
        imageView = itemView.findViewById(R.id.imageOfList);
        articleTitle = itemView.findViewById(R.id.articleTitle);
        publishDate = itemView.findViewById(R.id.publishDate);
    }
}
