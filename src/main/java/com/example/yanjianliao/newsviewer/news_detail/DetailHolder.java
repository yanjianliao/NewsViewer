package com.example.yanjianliao.newsviewer.news_detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanjianliao.newsviewer.R;

public class DetailHolder extends RecyclerView.ViewHolder{

    TextView description;
    TextView authorName;
    TextView title;
    TextView likeCount;
    TextView shareCount;
    ImageButton likeButton;
    ImageButton shareButton;
    Button button;
    ImageView likeImageView;

    public DetailHolder(View itemView) {
        super(itemView);
        likeImageView = itemView.findViewById(R.id.likeCountImage);
        description = itemView.findViewById(R.id.descriptionDetail);
        authorName = itemView.findViewById(R.id.authorName);
        title = itemView.findViewById(R.id.title);
        likeButton = itemView.findViewById(R.id.likeCountImage);
        likeCount = itemView.findViewById(R.id.likeCountText);
        shareButton = itemView.findViewById(R.id.shareCountImage);
        shareCount = itemView.findViewById(R.id.shareCountText);
        button = itemView.findViewById(R.id.openWebView);

    }
}
