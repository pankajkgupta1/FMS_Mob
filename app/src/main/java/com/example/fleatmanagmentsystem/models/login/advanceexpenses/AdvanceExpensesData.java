package com.example.fleatmanagmentsystem.models.login.advanceexpenses;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvanceExpensesData implements Parcelable{

    @SerializedName("trip")
    @Expose
    private Trip trip;
    public final static Creator<AdvanceExpensesData> CREATOR = new Creator<AdvanceExpensesData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AdvanceExpensesData createFromParcel(android.os.Parcel in) {
            return new AdvanceExpensesData(in);
        }

        public AdvanceExpensesData[] newArray(int size) {
            return (new AdvanceExpensesData[size]);
        }

    }
            ;

    protected AdvanceExpensesData(android.os.Parcel in) {
        this.trip = ((Trip) in.readValue((Trip.class.getClassLoader())));
    }

    public AdvanceExpensesData() {
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(trip);
    }

    public int describeContents() {
        return 0;
    }

}
