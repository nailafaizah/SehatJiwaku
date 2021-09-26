package com.example.sehatjiwaku.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataGejala implements Parcelable {
    @SerializedName("id_gejala")
    @Expose
    private String idGejala;
    @SerializedName("nama_gejala")
    @Expose
    private String namaGejala;
    @SerializedName("id_penyakit")
    @Expose
    private String idPenyakit;
    public final static Creator<DataGejala> CREATOR = new Creator<DataGejala>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DataGejala createFromParcel(android.os.Parcel in) {
            return new DataGejala(in);
        }

        public DataGejala[] newArray(int size) {
            return (new DataGejala[size]);
        }

    }
            ;

    protected DataGejala(android.os.Parcel in) {
        this.idGejala = ((String) in.readValue((String.class.getClassLoader())));
        this.namaGejala = ((String) in.readValue((String.class.getClassLoader())));
        this.idPenyakit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DataGejala() {
    }

    public String getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(String idGejala) {
        this.idGejala = idGejala;
    }

    public String getNamaGejala() {
        return namaGejala;
    }

    public void setNamaGejala(String namaGejala) {
        this.namaGejala = namaGejala;
    }

    public String getIdPenyakit() {
        return idPenyakit;
    }

    public void setIdPenyakit(String idPenyakit) {
        this.idPenyakit = idPenyakit;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(idGejala);
        dest.writeValue(namaGejala);
        dest.writeValue(idPenyakit);
    }

    public int describeContents() {
        return 0;
    }
}
