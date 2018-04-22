package com.example.yanjianliao.newsviewer.news_detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.yanjianliao.newsviewer.R;


public class ImageHolder extends RecyclerView.ViewHolder {

    ImageView imageView;

    public ImageHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageOfDetail);

    }
}
