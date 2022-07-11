package com.joydas1902.newsapp;

import com.joydas1902.newsapp.model.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<NewsApiResponse> getNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("q") String query,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize
    );
}
