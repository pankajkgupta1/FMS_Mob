package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;

import com.example.fleatmanagmentsystem.models.login.shipmentexecution.ShipmentExecution;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecutionUpdateData implements Parcelable
{

    @SerializedName("ShipmentExecution")
    @Expose
    private ShipmentExecution shipmentExecution;
    public final static Creator<ShipmentExecutionUpdateData> CREATOR = new Creator<ShipmentExecutionUpdateData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecutionUpdateData createFromParcel(android.os.Parcel in) {
            return new ShipmentExecutionUpdateData(in);
        }

        public ShipmentExecutionUpdateData[] newArray(int size) {
            return (new ShipmentExecutionUpdateData[size]);
        }

    }
            ;

    protected ShipmentExecutionUpdateData(android.os.Parcel in) {
        this.shipmentExecution = ((ShipmentExecution) in.readValue((ShipmentExecution.class.getClassLoader())));
    }

    public ShipmentExecutionUpdateData() {
    }

    public ShipmentExecution getShipmentExecution() {
        return shipmentExecution;
    }

    public void setShipmentExecution(ShipmentExecution shipmentExecution) {
        this.shipmentExecution = shipmentExecution;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(shipmentExecution);
    }

    public int describeContents() {
        return 0;
    }

}
