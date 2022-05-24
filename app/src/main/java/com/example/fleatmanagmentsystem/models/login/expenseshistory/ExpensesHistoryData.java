package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExpensesHistoryData implements Parcelable {

    @SerializedName("tripExpenses")
    @Expose
    private TripExpenses tripExpenses;
    public final static Creator<ExpensesHistoryData> CREATOR = new Creator<ExpensesHistoryData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExpensesHistoryData createFromParcel(android.os.Parcel in) {
            return new ExpensesHistoryData(in);
        }

        public ExpensesHistoryData[] newArray(int size) {
            return (new ExpensesHistoryData[size]);
        }

    }
            ;

    protected ExpensesHistoryData(android.os.Parcel in) {
        this.tripExpenses = ((TripExpenses) in.readValue((TripExpenses.class.getClassLoader())));
    }

    public ExpensesHistoryData() {
    }

    public TripExpenses getTripExpenses() {
        return tripExpenses;
    }

    public void setTripExpenses(TripExpenses tripExpenses) {
        this.tripExpenses = tripExpenses;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(tripExpenses);
    }

    public int describeContents() {
        return 0;
    }

}
