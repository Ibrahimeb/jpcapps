package com.tutorial.ibrahimestanga.jpcapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ibrahim Estanga on 4/12/2017.
 */

public class ModelRespose {


    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("url")
    @Expose
    private String url;

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

