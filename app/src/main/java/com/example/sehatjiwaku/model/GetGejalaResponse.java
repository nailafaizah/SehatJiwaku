package com.example.sehatjiwaku.model;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetGejalaResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataGejala> data = null;
    public final static Creator<GetGejalaResponse> CREATOR = new Creator<GetGejalaResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GetGejalaResponse createFromParcel(android.os.Parcel in) {
            return new GetGejalaResponse(in);
        }

        public GetGejalaResponse[] newArray(int size) {
            return (new GetGejalaResponse[size]);
        }

    }
            ;

    protected GetGejalaResponse(android.os.Parcel in) {
        this.status = ((long) in.readValue((long.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.example.sehatjiwaku.model.DataGejala.class.getClassLoader()));
    }

    public GetGejalaResponse() {
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

    public List<DataGejala> getData() {
        return data;
    }

    public void setData(List<DataGejala> data) {
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
