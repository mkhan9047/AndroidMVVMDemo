package com.app.androidmvvmdemo.Views.CustomAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.app.androidmvvmdemo.Model.RemoteDataSource.Dao.ResultsItem;
import com.app.androidmvvmdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomUserAdapter extends RecyclerView.Adapter<RandomUserAdapter.RandomHolder> {

    List<ResultsItem> randomUsers;
    Activity activity;

    public RandomUserAdapter(List<ResultsItem> randomUsers, Activity activity) {
        this.randomUsers = randomUsers;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RandomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_random_user, parent, false);
        return new RandomHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RandomHolder holder, int position) {
        Picasso.get().load(randomUsers.get(position).getPicture().getMedium()).into(holder.ivUser);
        holder.tvUserAge.setText(String.valueOf(randomUsers.get(position).getDob().getAge()));
        holder.tvUserGender.setText(String.valueOf(randomUsers.get(position).getGender()));
        holder.tvUserName.setText(randomUsers.get(position).getName().getFirst() + " " + randomUsers.get(position).getName().getLast());
    }

    @Override
    public int getItemCount() {
        return randomUsers.size();
    }

    class RandomHolder extends RecyclerView.ViewHolder {
        ImageView ivUser;
        TextView tvUserName, tvUserAge, tvUserGender;

        public RandomHolder(@NonNull View itemView) {
            super(itemView);
            ivUser = itemView.findViewById(R.id.iv_image);
            tvUserAge = itemView.findViewById(R.id.tv_age);
            tvUserName = itemView.findViewById(R.id.tv_name);
            tvUserGender = itemView.findViewById(R.id.tv_gender);
        }
    }

}
