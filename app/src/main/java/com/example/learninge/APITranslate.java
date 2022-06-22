package com.example.learninge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APITranslate {
//    https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=vi&dt=t&q=take
    Gson gson = new Gson();
    APITranslate traslate = new Retrofit.Builder()
            .baseUrl("https://translate.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APITranslate.class);
    @GET("translate_a/single?client=gtx&sl=en&tl=vi&dt=t")
    Call<Currency> Translate(@Query("client") String client,
                             @Query("sl") String sl,
                             @Query("tl") String tl,
                             @Query("dt") String dt,
                             @Query("q") String q);

}
