package com.caoyang.news.rss;

/**
 * Created by plter on 7/4/17.
 */

public class ReaderError {

    private Object relatedError;

    public ReaderError(Object relatedError) {
        this.relatedError = relatedError;
    }

    public Object getRelatedError() {
        return relatedError;
    }
}
