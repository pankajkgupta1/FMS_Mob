package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FuelExpensesResponseModule implements Parcelable
{
    public String status;
    public String statusMsg;
    public String errorCode;
    public FuelExpensesResponseData data;

    protected FuelExpensesResponseModule(Parcel in) {
        status = in.readString();
        statusMsg = in.readString();
        errorCode = in.readString();
    }

    public static final Creator<FuelExpensesResponseModule> CREATOR = new Creator<FuelExpensesResponseModule>() {
        @Override
        public FuelExpensesResponseModule createFromParcel(Parcel in) {
            return new FuelExpensesResponseModule(in);
        }

        @Override
        public FuelExpensesResponseModule[] newArray(int size) {
            return new FuelExpensesResponseModule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(statusMsg);
        dest.writeString(errorCode);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public FuelExpensesResponseData getData() {
        return data;
    }

    public void setData(FuelExpensesResponseData data) {
        this.data = data;
    }
}
