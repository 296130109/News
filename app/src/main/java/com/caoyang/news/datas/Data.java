package com.caoyang.news.datas;

/**
 * Created by caoyang on 17-6-29.
 */

public class Data {

    private String title,link,author,category,pubDate,comments,description;

    public Data(String title, String link, String author, String category, String pubDate, String comments, String description) {
        this.title = title;
        this.link = link;
        this.author = author;
        this.category = category;
        this.pubDate = pubDate;
        this.comments = comments;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getComments() {
        return comments;
    }

    public String getDescription() {
        return description;
    }
}
