package com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceUpdateStatusResponseModule implements Parcelable
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
    private MaintenanceUpdateStatusData data;
    public final static Creator<MaintenanceUpdateStatusResponseModule> CREATOR = new Creator<MaintenanceUpdateStatusResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceUpdateStatusResponseModule createFromParcel(android.os.Parcel in) {
            return new MaintenanceUpdateStatusResponseModule(in);
        }

        public MaintenanceUpdateStatusResponseModule[] newArray(int size) {
            return (new MaintenanceUpdateStatusResponseModule[size]);
        }

    }
            ;

    protected MaintenanceUpdateStatusResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((MaintenanceUpdateStatusData) in.readValue((MaintenanceUpdateStatusData.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintenanceUpdateStatusResponseModule() {
    }

    public MaintenanceUpdateStatusResponseModule(String status, String statusMsg, Object errorCode, MaintenanceUpdateStatusData data) {
        super();
        this.status = status;
        this.statusMsg = statusMsg;
        this.errorCode = errorCode;
        this.data = data;
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

    public MaintenanceUpdateStatusData getData() {
        return data;
    }

    public void setData(MaintenanceUpdateStatusData data) {
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
