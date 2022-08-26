package com.example.watchmovie.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.watchmovie.R;
import com.example.watchmovie.Service.Model.Result;
import com.example.watchmovie.View.Adapter.TopMovieListAdapter;
import com.example.watchmovie.ViewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieListViewModel movieListViewModel;
    private TopMovieListAdapter movieListAdapter;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.rand);
        recyclerView = findViewById(R.id.recyclerview);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        movieListViewModel.getTopRatedMovieLists().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                movieListAdapter = new TopMovieListAdapter(MainActivity.this, results);
                recyclerView.setAdapter(movieListAdapter);


            }
        });

        movieListViewModel.getRandomNumber().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tv1.setText(s);
            }
        });
    }
}