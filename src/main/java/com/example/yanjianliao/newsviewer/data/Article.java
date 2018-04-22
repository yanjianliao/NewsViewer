package com.example.yanjianliao.newsviewer.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.orm.SugarRecord;

public class Article extends SugarRecord implements Parcelable {

    public int idInDatabase = 0;
    public Source source = new Source();
    public String author = "";
    public String title = "";
    public String description = "";
    public String url = "";
    public String urlToImage = "";
    public String publishedAt = "";

    public Article(){

    }

    protected Article(Parcel in) {
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    //id + "\n"  + name + "\n"
    @Override
    public String toString() {
        return source.toString() + "\n" + author + "\n" + title + "\n" + description + "\n" + url + "\n" + urlToImage + "\n" + publishedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
    }
}
