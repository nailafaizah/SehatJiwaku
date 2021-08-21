package com.example.sehatjiwaku.model;

import com.google.gson.annotations.SerializedName;

public class LoginModel{

	@SerializedName("password")
	private String password;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getUsername(){
		return username;
	}

	public LoginModel(String username, String password){
		this.username = username;
		this.password = password;
	}
}