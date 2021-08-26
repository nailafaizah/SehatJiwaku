package com.example.sehatjiwaku.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPutDeleteDoctorResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("message")
    @Expose
    private String message;

    public final static Creator<PostPutDeleteDoctorResponse> CREATOR = new Creator<PostPutDeleteDoctorResponse>() {
        @SuppressWarnings({
                "unchecked"
        })
        public PostPutDeleteDoctorResponse createFromParcel(Parcel in) {
            return new PostPutDeleteDoctorResponse(in);
        }

        public PostPutDeleteDoctorResponse[] newArray(int size) {
            return (new PostPutDeleteDoctorResponse[size]);
        }

    };

    protected PostPutDeleteDoctorResponse(Parcel in) {
        this.status = ((long) in.readValue((long.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostPutDeleteDoctorResponse() {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}
