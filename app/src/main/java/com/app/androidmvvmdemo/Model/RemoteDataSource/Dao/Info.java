package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import com.google.gson.annotations.SerializedName;

public class Info{

	@SerializedName("seed")
	private String seed;

	@SerializedName("page")
	private int page;

	@SerializedName("results")
	private int results;

	@SerializedName("version")
	private String version;

	public String getSeed(){
		return seed;
	}

	public int getPage(){
		return page;
	}

	public int getResults(){
		return results;
	}

	public String getVersion(){
		return version;
	}
}