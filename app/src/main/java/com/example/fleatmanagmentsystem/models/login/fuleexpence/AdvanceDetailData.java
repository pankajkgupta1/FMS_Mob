package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import android.os.Parcelable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvanceDetailData implements Parcelable {

    @SerializedName("tripAdvance")
    @Expose
    private TripAdvance tripAdvance;
    public final static Creator<AdvanceDetailData> CREATOR = new Creator<AdvanceDetailData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AdvanceDetailData createFromParcel(android.os.Parcel in) {
            return new AdvanceDetailData(in);
        }

        public AdvanceDetailData[] newArray(int size) {
            return (new AdvanceDetailData[size]);
        }

    }
            ;

    protected AdvanceDetailData(android.os.Parcel in) {
        this.tripAdvance = ((TripAdvance) in.readValue((TripAdvance.class.getClassLoader())));
    }

    public AdvanceDetailData() {
    }

    public TripAdvance getTripAdvance() {
        return tripAdvance;
    }

    public void setTripAdvance(TripAdvance tripAdvance) {
        this.tripAdvance = tripAdvance;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(tripAdvance);
    }

    public int describeContents() {
        return 0;
    }
}
