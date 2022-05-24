package com.example.fleatmanagmentsystem.models.login.maintenanceclosure;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceClosureResponseModule implements Parcelable
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
    private MaintenanceClosureData data;
    public final static Creator<MaintenanceClosureResponseModule> CREATOR = new Creator<MaintenanceClosureResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceClosureResponseModule createFromParcel(android.os.Parcel in) {
            return new MaintenanceClosureResponseModule(in);
        }

        public MaintenanceClosureResponseModule[] newArray(int size) {
            return (new MaintenanceClosureResponseModule[size]);
        }

    }
            ;

    protected MaintenanceClosureResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((MaintenanceClosureData) in.readValue((MaintenanceClosureData.class.getClassLoader())));
    }

    public MaintenanceClosureResponseModule() {
    }

    public MaintenanceClosureResponseModule(String status, String statusMsg, Object errorCode, MaintenanceClosureData data) {
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

    public MaintenanceClosureData getData() {
        return data;
    }

    public void setData(MaintenanceClosureData data) {
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
