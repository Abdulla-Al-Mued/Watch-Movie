package com.example.watchmovie.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.watchmovie.Service.Model.Result;
import com.example.watchmovie.Service.Repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends AndroidViewModel {

    private MovieRepository MRepo;

    public MovieListViewModel(@NonNull Application application) {
        super(application);

        MRepo = MovieRepository.getInstance(application);
    }

    public LiveData<List<Result>> getTopRatedMovieLists(){
        return MRepo.getTopRatedMovieList();
    }

}
