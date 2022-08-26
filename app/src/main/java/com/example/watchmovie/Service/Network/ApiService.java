package com.example.watchmovie.Service.Network;

import com.example.watchmovie.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("3/movie/top_rated?api_key=287ad21992be07561b35919ecd019c5c&language=en-US")
    Call<MovieModel> getTopRatedMovieList();


}
