package com.example.sehatjiwaku.model;

import com.google.gson.annotations.SerializedName;

public class GejalaModel {
    @SerializedName("id_penyakit")
    private String idPenyakit;

    @SerializedName("nama_gejala")
    private String namaGejala;

    public GejalaModel(String idPenyakit, String namaGejala) {
        this.idPenyakit = idPenyakit;
        this.namaGejala = namaGejala;
    }

    public GejalaModel() {
    }
}
