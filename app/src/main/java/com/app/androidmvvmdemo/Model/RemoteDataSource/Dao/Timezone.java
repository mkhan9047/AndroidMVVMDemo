package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;


import com.google.gson.annotations.SerializedName;

public class Timezone{

	@SerializedName("offset")
	private String offset;

	@SerializedName("description")
	private String description;

	public String getOffset(){
		return offset;
	}

	public String getDescription(){
		return description;
	}
}