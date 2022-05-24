package com.example.fleatmanagmentsystem.models.login.driverimage;

import android.os.Parcel;
import android.os.Parcelable;

public class DriverImageResponseModule implements Parcelable {

    private String status;
    private String statusMsg;
    private Object errorCode;
    private DriverImageData data;

    protected DriverImageResponseModule(Parcel in) {
        status = in.readString();
        statusMsg = in.readString();
    }

    public static final Creator<DriverImageResponseModule> CREATOR = new Creator<DriverImageResponseModule>() {
        @Override
        public DriverImageResponseModule createFromParcel(Parcel in) {
            return new DriverImageResponseModule(in);
        }

        @Override
        public DriverImageResponseModule[] newArray(int size) {
            return new DriverImageResponseModule[size];
        }
    };

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
    public Object getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }
    public DriverImageData getData() {
        return data;
    }
    public void setData(DriverImageData data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(statusMsg);
    }
}
