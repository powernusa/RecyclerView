package com.powernusa.andy.popmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.powernusa.andy.popmovies.data.ModelResponse;
import com.powernusa.andy.popmovies.data.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String APIKEY = "b41491fab3366590c929b8668512cb03";
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecylerView;
    private List<Result> mMoviesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecylerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(layoutManager);



        ApiInterface apiService = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<ModelResponse> call = apiService.getTopRatedMovies(APIKEY);

        call.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                int statusCode = response.code();
                Log.d(LOG_TAG,">>> Status Code: " + statusCode);
                mMoviesList = response.body().getResults();
                Log.d(LOG_TAG,">>> Movie Count: " + mMoviesList.size());
                MoviesAdapter adapter = new MoviesAdapter(getApplicationContext(),mMoviesList);
                mRecylerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {

            }
        });

    }
}
