package com.example.sehatjiwaku.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataDoctor implements Parcelable {
    @SerializedName("id_dokter")
    @Expose
    private String idDokter;
    @SerializedName("nama_dokter")
    @Expose
    private String namaDokter;
    public final static Creator<DataDoctor> CREATOR = new Creator<DataDoctor>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DataDoctor createFromParcel(Parcel in) {
            return new DataDoctor(in);
        }

        public DataDoctor[] newArray(int size) {
            return (new DataDoctor[size]);
        }

    }
            ;

    protected DataDoctor(android.os.Parcel in) {
        this.idDokter = ((String) in.readValue((String.class.getClassLoader())));
        this.namaDokter = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DataDoctor() {
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(idDokter);
        dest.writeValue(namaDokter);
    }

    public int describeContents() {
        return 0;
    }

}
