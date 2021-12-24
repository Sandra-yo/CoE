package com.sandracoe.booklistapp.Objects;

public class BookCover {
    private String url;
    private int statusCode;
    
    public BookCover(String url, int statusCode) {
        this.url = url;
        this.statusCode = statusCode;
    }
    public BookCover() {}

    public int getStatusCode() {
        return statusCode;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
