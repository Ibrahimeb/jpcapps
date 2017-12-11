package com.tutorial.ibrahimestanga.jpcapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ibrahim Estanga on 4/12/2017.
 */

public class Headers {

    @SerializedName("Accept")
    @Expose
    private String accept;
    @SerializedName("Accept-Encoding")
    @Expose
    private String accept_Encoding;
    @SerializedName("Accept-Language")
    @Expose
    private String accept_Language;
    @SerializedName("Connection")
    @Expose
    private String connection;
    @SerializedName("Host")
    @Expose
    private String host;
    @SerializedName("Upgrade-Insecure-Requests")
    @Expose
    private String upgrade_Insecure_Requests;
    @SerializedName("User-Agent")
    @Expose
    private String user_Agent;
    @SerializedName("X-Chrome-Uma-Enabled")
    @Expose
    private String x_Chrome_Uma_Enabled;
    @SerializedName("X-Client-Data")
    @Expose
    private String x_Client_Data;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAccept_Encoding() {
        return accept_Encoding;
    }

    public void setAccept_Encoding(String accept_Encoding) {
        this.accept_Encoding = accept_Encoding;
    }

    public String getAccept_Language() {
        return accept_Language;
    }

    public void setAccept_Language(String accept_Language) {
        this.accept_Language = accept_Language;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUpgrade_Insecure_Requests() {
        return upgrade_Insecure_Requests;
    }

    public void setUpgrade_Insecure_Requests(String upgrade_Insecure_Requests) {
        this.upgrade_Insecure_Requests = upgrade_Insecure_Requests;
    }

    public String getUser_Agent() {
        return user_Agent;
    }

    public void setUser_Agent(String user_Agent) {
        this.user_Agent = user_Agent;
    }

    public String getX_Chrome_Uma_Enabled() {
        return x_Chrome_Uma_Enabled;
    }

    public void setX_Chrome_Uma_Enabled(String x_Chrome_Uma_Enabled) {
        this.x_Chrome_Uma_Enabled = x_Chrome_Uma_Enabled;
    }

    public String getX_Client_Data() {
        return x_Client_Data;
    }

    public void setX_Client_Data(String x_Client_Data) {
        this.x_Client_Data = x_Client_Data;
    }

}
