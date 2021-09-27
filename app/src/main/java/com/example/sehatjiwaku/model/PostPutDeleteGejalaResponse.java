package com.example.sehatjiwaku.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostPutDeleteGejalaResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("message")
    @Expose
    private String message;

    public final static Creator<PostPutDeleteGejalaResponse> CREATOR = new Creator<PostPutDeleteGejalaResponse>() {
        @SuppressWarnings({
                "unchecked"
        })
        public PostPutDeleteGejalaResponse createFromParcel(Parcel in) {
            return new PostPutDeleteGejalaResponse(in);
        }

        public PostPutDeleteGejalaResponse[] newArray(int size) {
            return (new PostPutDeleteGejalaResponse[size]);
        }

    };

    protected PostPutDeleteGejalaResponse(Parcel in) {
        this.status = ((long) in.readValue((long.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostPutDeleteGejalaResponse() {
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
