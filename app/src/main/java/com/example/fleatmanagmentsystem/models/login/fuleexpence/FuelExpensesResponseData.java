package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import android.os.Parcel;
import android.os.Parcelable;

public class FuelExpensesResponseData implements Parcelable {

    public TripExpenses tripExpenses;

    protected FuelExpensesResponseData(Parcel in) {
    }

    public static final Creator<FuelExpensesResponseData> CREATOR = new Creator<FuelExpensesResponseData>() {
        @Override
        public FuelExpensesResponseData createFromParcel(Parcel in) {
            return new FuelExpensesResponseData(in);
        }

        @Override
        public FuelExpensesResponseData[] newArray(int size) {
            return new FuelExpensesResponseData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public TripExpenses getTripExpenses() {
        return tripExpenses;
    }

    public void setTripExpenses(TripExpenses tripExpenses) {
        this.tripExpenses = tripExpenses;
    }
}
