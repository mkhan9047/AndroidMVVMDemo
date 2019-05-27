package com.app.androidmvvmdemo.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.androidmvvmdemo.Model.RemoteDataSource.Dao.RandomUser;
import com.app.androidmvvmdemo.Repository.RandomRepository;

public class RandomUserViewModel extends AndroidViewModel {

    MutableLiveData<RandomUser> randomUserMutableLiveData;
    RandomRepository randomRepository;

    public RandomUserViewModel(@NonNull Application application) {
        super(application);
        randomRepository = RandomRepository.getInstance();
        if(randomRepository.getRetrofitInterface()!=null)
        randomUserMutableLiveData = randomRepository.getRandomUserData();
    }


    public LiveData<RandomUser> getRandomUserRepo() {
        return randomUserMutableLiveData;
    }


}
