package com.tutorial.ibrahimestanga.jpcapp.retrofit;

import com.tutorial.ibrahimestanga.jpcapp.model.ModelRespose;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ibrahim Estanga on 5/12/2017.
 */

public interface ApiServices {

    @GET("get")
    Call<ModelRespose> getResponse();


}
