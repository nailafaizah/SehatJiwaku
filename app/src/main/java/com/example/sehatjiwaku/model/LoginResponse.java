package com.example.sehatjiwaku.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("data")
	private List<DataLogin> data;

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private int status;

	public List<DataLogin> getData(){
		return data;
	}

	public String getMessages(){
		return messages;
	}

	public int getStatus(){
		return status;
	}
}