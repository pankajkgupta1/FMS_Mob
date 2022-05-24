package com.example.fleatmanagmentsystem.models.login.tripstatus;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripStatusResponseModule implements Parcelable
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
    private TripStatusData data;
    public final static Creator<TripStatusResponseModule> CREATOR = new Creator<TripStatusResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripStatusResponseModule createFromParcel(android.os.Parcel in) {
            return new TripStatusResponseModule(in);
        }

        public TripStatusResponseModule[] newArray(int size) {
            return (new TripStatusResponseModule[size]);
        }

    }
            ;

    protected TripStatusResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((TripStatusData) in.readValue((TripStatusData.class.getClassLoader())));
    }

    public TripStatusResponseModule() {
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

    public TripStatusData getData() {
        return data;
    }

    public void setData(TripStatusData data) {
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
