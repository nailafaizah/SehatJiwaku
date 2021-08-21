package com.example.sehatjiwaku.model;

import com.google.gson.annotations.SerializedName;

public class DataLogin {

	@SerializedName("nama")
	private String nama;

	@SerializedName("level")
	private String level;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("username")
	private String username;

	public String getNama(){
		return nama;
	}

	public String getLevel(){
		return level;
	}

	public String getIdUser(){
		return idUser;
	}

	public String getUsername(){
		return username;
	}
}