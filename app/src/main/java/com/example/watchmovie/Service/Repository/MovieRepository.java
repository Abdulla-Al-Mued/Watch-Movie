package com.example.watchmovie.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.watchmovie.Service.Model.MovieModel;
import com.example.watchmovie.Service.Model.Result;
import com.example.watchmovie.Service.Network.ApiService;
import com.example.watchmovie.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {


    private static MovieRepository instance;
    private static Context ctx;
    private static MovieModel movieModel;
    private static List<Result> results;
    private static MutableLiveData mutableLiveData;

    public static MovieRepository getInstance(Context context){
        if(instance==null){

            ctx = context;
            instance = new MovieRepository();

        }

        return instance;
    }


    public MutableLiveData<List<Result>> getTopRatedMovieList(){

        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }

        ApiService apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        Call<MovieModel> call = apiService.getTopRatedMovieList();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel  = response.body();
                results = movieModel.getResults();
                mutableLiveData.postValue(results);

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mutableLiveData;

    }


}
