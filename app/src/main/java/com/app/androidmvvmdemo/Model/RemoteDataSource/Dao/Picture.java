package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import com.google.gson.annotations.SerializedName;

public class Picture{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("large")
	private String large;

	@SerializedName("medium")
	private String medium;

	public String getThumbnail(){
		return thumbnail;
	}

	public String getLarge(){
		return large;
	}

	public String getMedium(){
		return medium;
	}
}