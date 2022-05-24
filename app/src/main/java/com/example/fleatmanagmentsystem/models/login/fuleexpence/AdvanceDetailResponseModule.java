package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvanceDetailResponseModule implements Parcelable
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
    private AdvanceDetailData data;
    public final static Creator<AdvanceDetailResponseModule> CREATOR = new Creator<AdvanceDetailResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AdvanceDetailResponseModule createFromParcel(android.os.Parcel in) {
            return new AdvanceDetailResponseModule(in);
        }

        public AdvanceDetailResponseModule[] newArray(int size) {
            return (new AdvanceDetailResponseModule[size]);
        }

    }
            ;

    protected AdvanceDetailResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((AdvanceDetailData) in.readValue((AdvanceDetailData.class.getClassLoader())));
    }

    public AdvanceDetailResponseModule() {
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

    public AdvanceDetailData getData() {
        return data;
    }

    public void setData(AdvanceDetailData data) {
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
