package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import com.google.gson.annotations.SerializedName;


public class Login{

	@SerializedName("sha1")
	private String sha1;

	@SerializedName("password")
	private String password;

	@SerializedName("salt")
	private String salt;

	@SerializedName("sha256")
	private String sha256;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("username")
	private String username;

	@SerializedName("md5")
	private String md5;

	public String getSha1(){
		return sha1;
	}

	public String getPassword(){
		return password;
	}

	public String getSalt(){
		return salt;
	}

	public String getSha256(){
		return sha256;
	}

	public String getUuid(){
		return uuid;
	}

	public String getUsername(){
		return username;
	}

	public String getMd5(){
		return md5;
	}
}