package com.example.yanjianliao.newsviewer.data;

import java.util.ArrayList;
import java.util.List;

public class News {

    public String status = null;
    public Integer totalResults = 0;
    public List<Article> articles = null;

    public News(){

    }

    @Override
    public String toString() {
        return " status : " + status + "; totalResults : " + totalResults + articles.toString();
    }
}
