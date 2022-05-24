package com.example.fleatmanagmentsystem.models.login.shipmentexecution;

import java.io.Serializable;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecutionData implements Parcelable {

    @SerializedName("shipmentExecution")
    @Expose
    private ShipmentExecution shipmentExecution;
    public final static Creator<ShipmentExecutionData> CREATOR = new Creator<ShipmentExecutionData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecutionData createFromParcel(android.os.Parcel in) {
            return new ShipmentExecutionData(in);
        }

        public ShipmentExecutionData[] newArray(int size) {
            return (new ShipmentExecutionData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 7679587525185664395L;

    protected ShipmentExecutionData(android.os.Parcel in) {
        this.shipmentExecution = ((ShipmentExecution) in.readValue((ShipmentExecution.class.getClassLoader())));
    }

    public ShipmentExecutionData() {
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
