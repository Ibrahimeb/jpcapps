package com.tutorial.ibrahimestanga.jpcapp.retrofit;


/**
 * Created by Ibrahim Estanga on 1/9/2017.
 */

public class ApiUtils {

    private ApiUtils() {
    }


    public static final String BASE_URL = "http://httpbin.org/";

    public static ApiServices getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiServices.class);

    }



}
