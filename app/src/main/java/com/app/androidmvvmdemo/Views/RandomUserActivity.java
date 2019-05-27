package com.app.androidmvvmdemo.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.androidmvvmdemo.Model.RemoteDataSource.Dao.RandomUser;
import com.app.androidmvvmdemo.R;
import com.app.androidmvvmdemo.ViewModel.RandomUserViewModel;
import com.app.androidmvvmdemo.Views.CustomAdapter.RandomUserAdapter;

public class RandomUserActivity extends AppCompatActivity {

    RandomUserViewModel randomUserViewModel;
    RecyclerView randomUserRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_user);

        randomUserRecyclerView = findViewById(R.id.rv_random_user_recycler_view);
        randomUserRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        randomUserViewModel = ViewModelProviders.of(this).get(RandomUserViewModel.class);
        randomUserViewModel.getRandomUserRepo().observe(this, new Observer<RandomUser>() {
            @Override
            public void onChanged(RandomUser randomUser) {
                RandomUserAdapter randomUserAdapter = new RandomUserAdapter(randomUser.getResults(), RandomUserActivity.this);
                randomUserRecyclerView.setAdapter(randomUserAdapter);
            }
        });

    }
}
