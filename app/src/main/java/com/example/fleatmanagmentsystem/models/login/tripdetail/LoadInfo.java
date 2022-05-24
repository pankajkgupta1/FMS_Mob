package com.example.fleatmanagmentsystem.models.login.tripdetail;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoadInfo implements Parcelable {

    @SerializedName("loadId")
    @Expose
    private String loadId;
    @SerializedName("tripSequence")
    @Expose
    private Integer tripSequence;
    @SerializedName("purchaseOrderId")
    @Expose
    private Object purchaseOrderId;
    @SerializedName("sourceLocation")
    @Expose
    private String sourceLocation;
    @SerializedName("destinationLocation")
    @Expose
    private String destinationLocation;
    @SerializedName("shipperPickupDateAndTime")
    @Expose
    private String shipperPickupDateAndTime;
    @SerializedName("customerDeliveryDateAndTime")
    @Expose
    private String customerDeliveryDateAndTime;
    public final static Creator<LoadInfo> CREATOR = new Creator<LoadInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoadInfo createFromParcel(android.os.Parcel in) {
            return new LoadInfo(in);
        }

        public LoadInfo[] newArray(int size) {
            return (new LoadInfo[size]);
        }

    };

    protected LoadInfo(android.os.Parcel in) {
        this.loadId = ((String) in.readValue((String.class.getClassLoader())));
        this.tripSequence = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.purchaseOrderId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.sourceLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.shipperPickupDateAndTime = ((String) in.readValue((String.class.getClassLoader())));
        this.customerDeliveryDateAndTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LoadInfo() {
    }

    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = loadId;
    }

    public Integer getTripSequence() {
        return tripSequence;
    }

    public void setTripSequence(Integer tripSequence) {
        this.tripSequence = tripSequence;
    }

    public Object getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Object purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getShipperPickupDateAndTime() {
        return shipperPickupDateAndTime;
    }

    public void setShipperPickupDateAndTime(String shipperPickupDateAndTime) {
        this.shipperPickupDateAndTime = shipperPickupDateAndTime;
    }

    public String getCustomerDeliveryDateAndTime() {
        return customerDeliveryDateAndTime;
    }

    public void setCustomerDeliveryDateAndTime(String customerDeliveryDateAndTime) {
        this.customerDeliveryDateAndTime = customerDeliveryDateAndTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(loadId);
        dest.writeValue(tripSequence);
        dest.writeValue(purchaseOrderId);
        dest.writeValue(sourceLocation);
        dest.writeValue(destinationLocation);
        dest.writeValue(shipperPickupDateAndTime);
        dest.writeValue(customerDeliveryDateAndTime);
    }

    public int describeContents() {
        return 0;
    }
}

