package com.example.fleatmanagmentsystem.models.login.tripstatus;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripStatusData implements Parcelable {

    public final static Creator<TripStatusData> CREATOR = new Creator<TripStatusData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripStatusData createFromParcel(android.os.Parcel in) {
            return new TripStatusData(in);
        }

        public TripStatusData[] newArray(int size) {
            return (new TripStatusData[size]);
        }

    }
            ;

    protected TripStatusData(android.os.Parcel in) {
    }

    public TripStatusData() {
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
    }

    public int describeContents() {
        return 0;
    }
}
