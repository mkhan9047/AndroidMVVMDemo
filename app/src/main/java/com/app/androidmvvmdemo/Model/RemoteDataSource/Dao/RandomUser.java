package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class RandomUser{

	@SerializedName("results")
	private List<ResultsItem> results;

	@SerializedName("info")
	private Info info;

	public List<ResultsItem> getResults(){
		return results;
	}

	public Info getInfo(){
		return info;
	}
}