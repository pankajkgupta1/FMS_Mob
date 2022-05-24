package com.example.fleatmanagmentsystem.models.login.advanceexpenses;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvanceExpensesResponseModule implements Parcelable {

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
    private AdvanceExpensesData data;
    public final static Creator<AdvanceExpensesResponseModule> CREATOR = new Creator<AdvanceExpensesResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AdvanceExpensesResponseModule createFromParcel(android.os.Parcel in) {
            return new AdvanceExpensesResponseModule(in);
        }

        public AdvanceExpensesResponseModule[] newArray(int size) {
            return (new AdvanceExpensesResponseModule[size]);
        }

    }
            ;

    protected AdvanceExpensesResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((AdvanceExpensesData) in.readValue((AdvanceExpensesData.class.getClassLoader())));
    }

    public AdvanceExpensesResponseModule() {
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

    public AdvanceExpensesData getData() {
        return data;
    }

    public void setData(AdvanceExpensesData data) {
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
