package com.app.androidmvvmdemo.Repository;

import androidx.lifecycle.MutableLiveData;

import com.app.androidmvvmdemo.Model.RemoteDataSource.Dao.RandomUser;
import com.app.androidmvvmdemo.Model.RemoteDataSource.RetrofitClient.RetrofitClient;
import com.app.androidmvvmdemo.Model.RemoteDataSource.RetrofitInterface.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RandomRepository {

    private static RandomRepository instance;
    private RetrofitInterface retrofitInterface;

    public static synchronized RandomRepository getInstance() {
        if (instance == null) {
            instance = new RandomRepository();
        }
        return instance;
    }

    public RetrofitInterface getRetrofitInterface() {
        retrofitInterface = RetrofitClient.getRetrofit().create(RetrofitInterface.class);
        return retrofitInterface;
    }

    public MutableLiveData<RandomUser> getRandomUserData() {
        final MutableLiveData<RandomUser> randomUserMutableLiveData = new MutableLiveData<>();
        getRetrofitInterface().getRandomUser(5).enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                if (response.isSuccessful()) {
                    randomUserMutableLiveData.setValue(response.body());
                }else{
                    randomUserMutableLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {
                randomUserMutableLiveData.setValue(null);
            }
        });
        return randomUserMutableLiveData;
    }

}
