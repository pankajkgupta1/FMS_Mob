package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExpensesHistoryResponseModule implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("errorCode")
    @Expose
    private String errorCode;
    @SerializedName("data")
    @Expose
    private ExpensesHistoryData data;
    public final static Creator<ExpensesHistoryResponseModule> CREATOR = new Creator<ExpensesHistoryResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ExpensesHistoryResponseModule createFromParcel(android.os.Parcel in) {
            return new ExpensesHistoryResponseModule(in);
        }

        public ExpensesHistoryResponseModule[] newArray(int size) {
            return (new ExpensesHistoryResponseModule[size]);
        }

    }
            ;

    protected ExpensesHistoryResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((ExpensesHistoryData) in.readValue((ExpensesHistoryData.class.getClassLoader())));
    }

    public ExpensesHistoryResponseModule() {
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

    public ExpensesHistoryData getData() {
        return data;
    }

    public void setData(ExpensesHistoryData data) {
        this.data = data;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(statusMsg);
        dest.writeValue(errorCode);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}
