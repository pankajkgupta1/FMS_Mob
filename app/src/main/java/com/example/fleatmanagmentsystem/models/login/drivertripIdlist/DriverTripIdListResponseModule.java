package com.example.fleatmanagmentsystem.models.login.drivertripIdlist;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverTripIdListResponseModule implements Parcelable
{

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("statusMsg")
    @Expose
    private String statusMsg;
    @SerializedName("errorCode")
    @Expose
    private Object errorCode;
    @SerializedName("data")
    @Expose
    private DriverTripIdListData data;
    public final static Creator<DriverTripIdListResponseModule> CREATOR = new Creator<DriverTripIdListResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DriverTripIdListResponseModule createFromParcel(android.os.Parcel in) {
            return new DriverTripIdListResponseModule(in);
        }

        public DriverTripIdListResponseModule[] newArray(int size) {
            return (new DriverTripIdListResponseModule[size]);
        }

    }
            ;

    protected DriverTripIdListResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((DriverTripIdListData) in.readValue((DriverTripIdListData.class.getClassLoader())));
    }

    public DriverTripIdListResponseModule() {
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

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public DriverTripIdListData getData() {
        return data;
    }

    public void setData(DriverTripIdListData data) {
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
