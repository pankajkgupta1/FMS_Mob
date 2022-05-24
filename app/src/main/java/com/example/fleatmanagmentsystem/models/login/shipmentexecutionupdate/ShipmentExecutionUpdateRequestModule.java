package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import java.util.List;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecutionUpdateRequestModule implements Parcelable
{

    @SerializedName("shipmentDetails")
    @Expose
    private List<ShipmentDetail> shipmentDetails = null;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("physicalDocumentsHandover")
    @Expose
    private String physicalDocumentsHandover;
    @SerializedName("odoMeterStart")
    @Expose
    private Integer odoMeterStart;
    @SerializedName("odoMeterEnd")
    @Expose
    private String odoMeterEnd;
    @SerializedName("takeOver")
    @Expose
    private TakeOver takeOver;
    @SerializedName("handOver")
    @Expose
    private HandOver handOver;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    public final static Creator<ShipmentExecutionUpdateRequestModule> CREATOR = new Creator<ShipmentExecutionUpdateRequestModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecutionUpdateRequestModule createFromParcel(android.os.Parcel in) {
            return new ShipmentExecutionUpdateRequestModule(in);
        }

        public ShipmentExecutionUpdateRequestModule[] newArray(int size) {
            return (new ShipmentExecutionUpdateRequestModule[size]);
        }

    }
            ;

    protected ShipmentExecutionUpdateRequestModule(android.os.Parcel in) {
        in.readList(this.shipmentDetails, (ShipmentDetail.class.getClassLoader()));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.physicalDocumentsHandover = ((String) in.readValue((String.class.getClassLoader())));
        this.odoMeterStart = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.odoMeterEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.takeOver = ((TakeOver) in.readValue((TakeOver.class.getClassLoader())));
        this.handOver = ((HandOver) in.readValue((HandOver.class.getClassLoader())));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ShipmentExecutionUpdateRequestModule() {
    }

    public List<ShipmentDetail> getShipmentDetails() {
        return shipmentDetails;
    }

    public void setShipmentDetails(List<ShipmentDetail> shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getOrganizationIdName() {
        return organizationIdName;
    }

    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhysicalDocumentsHandover() {
        return physicalDocumentsHandover;
    }

    public void setPhysicalDocumentsHandover(String physicalDocumentsHandover) {
        this.physicalDocumentsHandover = physicalDocumentsHandover;
    }

    public Integer getOdoMeterStart() {
        return odoMeterStart;
    }

    public void setOdoMeterStart(Integer odoMeterStart) {
        this.odoMeterStart = odoMeterStart;
    }

    public String getOdoMeterEnd() {
        return odoMeterEnd;
    }

    public void setOdoMeterEnd(String odoMeterEnd) {
        this.odoMeterEnd = odoMeterEnd;
    }

    public TakeOver getTakeOver() {
        return takeOver;
    }

    public void setTakeOver(TakeOver takeOver) {
        this.takeOver = takeOver;
    }

    public HandOver getHandOver() {
        return handOver;
    }

    public void setHandOver(HandOver handOver) {
        this.handOver = handOver;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(shipmentDetails);
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(physicalDocumentsHandover);
        dest.writeValue(odoMeterStart);
        dest.writeValue(odoMeterEnd);
        dest.writeValue(takeOver);
        dest.writeValue(handOver);
        dest.writeValue(tripStatus);
    }

    public int describeContents() {
        return 0;
    }

}
