package com.app.androidmvvmdemo.Model.RemoteDataSource.RetrofitInterface;

import androidx.lifecycle.LiveData;
import androidx.room.SkipQueryVerification;

import com.app.androidmvvmdemo.Model.RemoteDataSource.Dao.RandomUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {
    @GET("api")
    Call<RandomUser> getRandomUser(@Query("results") int result);
}


