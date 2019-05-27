package com.app.androidmvvmdemo.Model.RemoteDataSource.Dao;

import com.google.gson.annotations.SerializedName;

public class ResultsItem{

	@SerializedName("nat")
	private String nat;

	@SerializedName("gender")
	private String gender;

	@SerializedName("phone")
	private String phone;

	@SerializedName("dob")
	private Dob dob;

	@SerializedName("name")
	private Name name;

	@SerializedName("registered")
	private Registered registered;

	@SerializedName("location")
	private Location location;

	@SerializedName("id")
	private Id id;

	@SerializedName("login")
	private Login login;

	@SerializedName("cell")
	private String cell;

	@SerializedName("email")
	private String email;

	@SerializedName("picture")
	private Picture picture;

	public String getNat(){
		return nat;
	}

	public String getGender(){
		return gender;
	}

	public String getPhone(){
		return phone;
	}

	public Dob getDob(){
		return dob;
	}

	public Name getName(){
		return name;
	}

	public Registered getRegistered(){
		return registered;
	}

	public Location getLocation(){
		return location;
	}

	public Id getId(){
		return id;
	}

	public Login getLogin(){
		return login;
	}

	public String getCell(){
		return cell;
	}

	public String getEmail(){
		return email;
	}

	public Picture getPicture(){
		return picture;
	}
}