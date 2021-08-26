package com.example.sehatjiwaku.model;

import com.google.gson.annotations.SerializedName;

public class DoctorModel{

	@SerializedName("nama_dokter")
	private String namaDokter;

	public String getNamaDokter(){
		return namaDokter;
	}

	public DoctorModel(String namaDokter){
		this.namaDokter = namaDokter;
	}
}