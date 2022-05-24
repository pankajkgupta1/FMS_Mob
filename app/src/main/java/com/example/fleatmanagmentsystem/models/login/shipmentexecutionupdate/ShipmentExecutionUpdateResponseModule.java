package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecutionUpdateResponseModule implements Parcelable
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
    private ShipmentExecutionUpdateData data;
    public final static Creator<ShipmentExecutionUpdateResponseModule> CREATOR = new Creator<ShipmentExecutionUpdateResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecutionUpdateResponseModule createFromParcel(android.os.Parcel in) {
            return new ShipmentExecutionUpdateResponseModule(in);
        }

        public ShipmentExecutionUpdateResponseModule[] newArray(int size) {
            return (new ShipmentExecutionUpdateResponseModule[size]);
        }

    }
            ;

    protected ShipmentExecutionUpdateResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((ShipmentExecutionUpdateData) in.readValue((ShipmentExecutionUpdateData.class.getClassLoader())));
    }

    public ShipmentExecutionUpdateResponseModule() {
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

    public ShipmentExecutionUpdateData getData() {
        return data;
    }

    public void setData(ShipmentExecutionUpdateData data) {
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
