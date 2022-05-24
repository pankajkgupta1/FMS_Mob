package com.example.fleatmanagmentsystem.models.login.shipmentexecution;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecutionResponseModule implements Serializable, Parcelable
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
    private ShipmentExecutionData data;
    public final static Creator<ShipmentExecutionResponseModule> CREATOR = new Creator<ShipmentExecutionResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecutionResponseModule createFromParcel(android.os.Parcel in) {
            return new ShipmentExecutionResponseModule(in);
        }

        public ShipmentExecutionResponseModule[] newArray(int size) {
            return (new ShipmentExecutionResponseModule[size]);
        }

    }
            ;
    private final static long serialVersionUID = -9203854859541375438L;

    protected ShipmentExecutionResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((ShipmentExecutionData) in.readValue((ShipmentExecutionData.class.getClassLoader())));
    }

    public ShipmentExecutionResponseModule() {
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

    public ShipmentExecutionData getData() {
        return data;
    }

    public void setData(ShipmentExecutionData data) {
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