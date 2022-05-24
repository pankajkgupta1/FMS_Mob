package com.example.fleatmanagmentsystem.models.login.advanceexpenses;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoadSequenceHelper implements Parcelable {

    @SerializedName("loadId")
    @Expose
    private String loadId;
    @SerializedName("tripSequence")
    @Expose
    private Integer tripSequence;
    @SerializedName("purchaseOrderId")
    @Expose
    private String purchaseOrderId;
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
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("invoiceStatus")
    @Expose
    private String invoiceStatus;
    public final static Creator<LoadSequenceHelper> CREATOR = new Creator<LoadSequenceHelper>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoadSequenceHelper createFromParcel(android.os.Parcel in) {
            return new LoadSequenceHelper(in);
        }

        public LoadSequenceHelper[] newArray(int size) {
            return (new LoadSequenceHelper[size]);
        }

    }
            ;

    protected LoadSequenceHelper(android.os.Parcel in) {
        this.loadId = ((String) in.readValue((String.class.getClassLoader())));
        this.tripSequence = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.purchaseOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.shipperPickupDateAndTime = ((String) in.readValue((String.class.getClassLoader())));
        this.customerDeliveryDateAndTime = ((String) in.readValue((String.class.getClassLoader())));
        this.distance = ((String) in.readValue((String.class.getClassLoader())));
        this.invoiceStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LoadSequenceHelper() {
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

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(loadId);
        dest.writeValue(tripSequence);
        dest.writeValue(purchaseOrderId);
        dest.writeValue(sourceLocation);
        dest.writeValue(destinationLocation);
        dest.writeValue(shipperPickupDateAndTime);
        dest.writeValue(customerDeliveryDateAndTime);
        dest.writeValue(distance);
        dest.writeValue(invoiceStatus);
    }

    public int describeContents() {
        return 0;
    }

}
