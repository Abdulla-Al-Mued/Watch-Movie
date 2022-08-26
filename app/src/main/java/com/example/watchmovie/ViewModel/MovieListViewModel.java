package com.example.watchmovie.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.watchmovie.Service.Model.Result;
import com.example.watchmovie.Service.Repository.MovieRepository;

import java.util.List;
import java.util.Random;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository MRepo;
    private String TAG = this.getClass().getSimpleName();


    public MovieListViewModel(@NonNull Application application) {
        super(application);

        MRepo = MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieLists(){
        return MRepo.getTopRatedMovieList();
    }


    private MutableLiveData<String> randomNumber;

    public MutableLiveData<String> getRandomNumber(){

        if(randomNumber == null){

            randomNumber = new MutableLiveData<>();
            createRandomNumber();
        }

        return randomNumber;
    }

    public void createRandomNumber() {

        Random random  = new Random();
        randomNumber.postValue("My Random Number"+ random.nextInt(100-1));

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "View Model Destroyed");
    }




}
