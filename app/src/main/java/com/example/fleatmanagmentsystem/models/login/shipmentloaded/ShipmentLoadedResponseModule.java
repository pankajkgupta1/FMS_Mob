package com.example.fleatmanagmentsystem.models.login.shipmentloaded;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentLoadedResponseModule implements Serializable, Parcelable
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
    private ShipmentLoadedData data;
    public final static Creator<ShipmentLoadedResponseModule> CREATOR = new Creator<ShipmentLoadedResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentLoadedResponseModule createFromParcel(android.os.Parcel in) {
            return new ShipmentLoadedResponseModule(in);
        }

        public ShipmentLoadedResponseModule[] newArray(int size) {
            return (new ShipmentLoadedResponseModule[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6717632312821457668L;

    protected ShipmentLoadedResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((ShipmentLoadedData) in.readValue((ShipmentLoadedData.class.getClassLoader())));
    }

    public ShipmentLoadedResponseModule() {
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

    public ShipmentLoadedData getData() {
        return data;
    }

    public void setData(ShipmentLoadedData data) {
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
