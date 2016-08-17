package com.powernusa.andy.popmovies;

import com.powernusa.andy.popmovies.data.ModelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Andy on 8/17/2016.
 */
public interface ApiInterface {

    @GET("movie/top_rated")
    Call<ModelResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<ModelResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

}
