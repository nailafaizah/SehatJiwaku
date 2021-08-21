package com.example.sehatjiwaku.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("data")
	private List<Object> data;

	@SerializedName("messages")
	private String messages;

	@SerializedName("status")
	private int status;

	public List<Object> getData(){
		return data;
	}

	public String getMessages(){
		return messages;
	}

	public int getStatus(){
		return status;
	}
}