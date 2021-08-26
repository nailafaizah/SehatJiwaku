package com.example.sehatjiwaku.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDoctorResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataDoctor> data = null;
    public final static Creator<GetDoctorResponse> CREATOR = new Creator<GetDoctorResponse>() {
        @SuppressWarnings({
                "unchecked"
        })
        public GetDoctorResponse createFromParcel(android.os.Parcel in) {
            return new GetDoctorResponse(in);
        }

        public GetDoctorResponse[] newArray(int size) {
            return (new GetDoctorResponse[size]);
        }

    };

    protected GetDoctorResponse(Parcel in) {
        this.status = ((long) in.readValue((long.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (DataDoctor.class.getClassLoader()));
    }

    public GetDoctorResponse() {
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataDoctor> getData() {
        return data;
    }

    public void setData(List<DataDoctor> data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

}
