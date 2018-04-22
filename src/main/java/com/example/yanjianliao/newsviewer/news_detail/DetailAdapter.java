package com.example.yanjianliao.newsviewer.news_detail;

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
import com.example.yanjianliao.newsviewer.WebViewActivity;
import com.squareup.picasso.Picasso;

public class DetailAdapter extends RecyclerView.Adapter {

    Article article = null;


    public DetailAdapter(Article article){
        this.article = article;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == 1){
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.information_detail, parent, false);

            return new DetailHolder(view);
        }

        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.image_detail, parent, false);

        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if(position == 1){

            DetailHolder detail = (DetailHolder) holder;

            detail.likeCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    article.save();
                    Toast.makeText(holder.itemView.getContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            });
            detail.likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    article.save();
                    Toast.makeText(holder.itemView.getContext(), "Saved", Toast.LENGTH_LONG).show();
                }
            });

            detail.description.setText(article.description);
            detail.authorName.setText(article.author);
            detail.title.setText(article.title);


            detail.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = holder.itemView.getContext();
                    Intent intent = new Intent(context, WebViewActivity.class);
                    intent.putExtra("url", article.url);
                    context.startActivity(intent);

                }
            });

        }else{

            ImageHolder image = (ImageHolder)holder;
            image.imageView.setImageResource(R.drawable.circle);
            Picasso.get().load(article.urlToImage).placeholder(R.drawable.images).into(image.imageView);

        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
