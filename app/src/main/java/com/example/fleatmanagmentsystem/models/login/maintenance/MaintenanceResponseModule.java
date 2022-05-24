package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceResponseModule implements Parcelable
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
    private MaintenanceResponseData data;
    public final static Creator<MaintenanceResponseModule> CREATOR = new Creator<MaintenanceResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceResponseModule createFromParcel(android.os.Parcel in) {
            return new MaintenanceResponseModule(in);
        }

        public MaintenanceResponseModule[] newArray(int size) {
            return (new MaintenanceResponseModule[size]);
        }

    }
            ;

    protected MaintenanceResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((MaintenanceResponseData) in.readValue((MaintenanceResponseData.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintenanceResponseModule() {
    }

    /**
     *
     * @param statusMsg
     * @param data
     * @param errorCode
     * @param status
     */
    public MaintenanceResponseModule(String status, String statusMsg, Object errorCode, MaintenanceResponseData data) {
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

    public MaintenanceResponseData getData() {
        return data;
    }

    public void setData(MaintenanceResponseData data) {
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

/*import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceResponseModule implements Parcelable
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
    private MaintenanceResponseData data;
    public final static Creator<MaintenanceResponseModule> CREATOR = new Creator<MaintenanceResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceResponseModule createFromParcel(android.os.Parcel in) {
            return new MaintenanceResponseModule(in);
        }

        public MaintenanceResponseModule[] newArray(int size) {
            return (new MaintenanceResponseModule[size]);
        }

    }
            ;

    protected MaintenanceResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((MaintenanceResponseData) in.readValue((MaintenanceResponseData.class.getClassLoader())));
    }

    public MaintenanceResponseModule() {
    }

    public MaintenanceResponseModule(String status, String statusMsg, String errorCode, MaintenanceResponseData data) {
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

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public MaintenanceResponseData getData() {
        return data;
    }

    public void setData(MaintenanceResponseData data) {
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

}*/
