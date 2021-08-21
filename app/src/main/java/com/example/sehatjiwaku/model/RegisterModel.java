package com.example.sehatjiwaku.model;

public class RegisterModel{
	private String password;
	private String nama;
	private String level;
	private String username;

	public RegisterModel(String password, String nama, String level, String username) {
		this.password = password;
		this.nama = nama;
		this.level = level;
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public String getNama(){
		return nama;
	}

	public String getLevel(){
		return level;
	}

	public String getUsername(){
		return username;
	}
}
