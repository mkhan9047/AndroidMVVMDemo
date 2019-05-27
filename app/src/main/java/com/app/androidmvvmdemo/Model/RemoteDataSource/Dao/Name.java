package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import com.google.gson.annotations.SerializedName;

public class Name{

	@SerializedName("last")
	private String last;

	@SerializedName("title")
	private String title;

	@SerializedName("first")
	private String first;

	public String getLast(){
		return last;
	}

	public String getTitle(){
		return title;
	}

	public String getFirst(){
		return first;
	}
}