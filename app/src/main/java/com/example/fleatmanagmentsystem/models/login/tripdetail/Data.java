package com.example.fleatmanagmentsystem.models.login.tripdetail;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Parcelable
{

    /*@SerializedName("tripInfoList")
    @Expose
    private List<TripInfoList> tripInfoList = new ArrayList<>();
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(android.os.Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(android.os.Parcel in) {
        in.readList(this.tripInfoList, (TripInfoList.class.getClassLoader()));
    }

    public Data() {
    }

    public List<TripInfoList> getTripInfoList() {
        return tripInfoList;
    }

    public void setTripInfoList(List<TripInfoList> tripInfoList) {
        this.tripInfoList = tripInfoList;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(tripInfoList);
    }

    public int describeContents() {
        return 0;
    }*/

    @SerializedName("tripInfoList")
    @Expose
    public List<TripInfo> tripInfoList = new ArrayList<>();
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Data createFromParcel(android.os.Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
            ;

    protected Data(android.os.Parcel in) {
        in.readList(this.tripInfoList, (TripInfo.class.getClassLoader()));
    }

    public Data() {
    }

    public List<TripInfo> getTripInfoList() {
        return tripInfoList;
    }

    public void setTripInfoList(List<TripInfo> tripInfoList) {
        this.tripInfoList = tripInfoList;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(tripInfoList);
    }

    public int describeContents() {
        return 0;
    }

}
