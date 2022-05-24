package com.example.fleatmanagmentsystem.models.login.shipmentexecution;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentExecution implements Serializable, Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("odoMeterStart")
    @Expose
    private String odoMeterStart;
    @SerializedName("odoMeterEnd")
    @Expose
    private String odoMeterEnd;
    @SerializedName("takeover")
    @Expose
    private Takeover takeover;
    @SerializedName("handover")
    @Expose
    private Handover handover;
    @SerializedName("shipmentDetails")
    @Expose
    private List<ShipmentDetail> shipmentDetails = null;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    @SerializedName("physicalDocumentsHandover")
    @Expose
    private String physicalDocumentsHandover;
    public final static Creator<ShipmentExecution> CREATOR = new Creator<ShipmentExecution>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentExecution createFromParcel(android.os.Parcel in) {
            return new ShipmentExecution(in);
        }

        public ShipmentExecution[] newArray(int size) {
            return (new ShipmentExecution[size]);
        }

    }
            ;
    private final static long serialVersionUID = 2284876489536381657L;

    protected ShipmentExecution(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.odoMeterStart = ((String) in.readValue((String.class.getClassLoader())));
        this.odoMeterEnd = ((String) in.readValue((String.class.getClassLoader())));
        this.takeover = ((Takeover) in.readValue((Takeover.class.getClassLoader())));
        this.handover = ((Handover) in.readValue((Handover.class.getClassLoader())));
        in.readList(this.shipmentDetails, (ShipmentDetail.class.getClassLoader()));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.physicalDocumentsHandover = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ShipmentExecution() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getOdoMeterStart() {
        return odoMeterStart;
    }

    public void setOdoMeterStart(String odoMeterStart) {
        this.odoMeterStart = odoMeterStart;
    }

    public String getOdoMeterEnd() {
        return odoMeterEnd;
    }

    public void setOdoMeterEnd(String odoMeterEnd) {
        this.odoMeterEnd = odoMeterEnd;
    }

    public Takeover getTakeover() {
        return takeover;
    }

    public void setTakeover(Takeover takeover) {
        this.takeover = takeover;
    }

    public Handover getHandover() {
        return handover;
    }

    public void setHandover(Handover handover) {
        this.handover = handover;
    }

    public List<ShipmentDetail> getShipmentDetails() {
        return shipmentDetails;
    }

    public void setShipmentDetails(List<ShipmentDetail> shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getPhysicalDocumentsHandover() {
        return physicalDocumentsHandover;
    }

    public void setPhysicalDocumentsHandover(String physicalDocumentsHandover) {
        this.physicalDocumentsHandover = physicalDocumentsHandover;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(odoMeterStart);
        dest.writeValue(odoMeterEnd);
        dest.writeValue(takeover);
        dest.writeValue(handover);
        dest.writeList(shipmentDetails);
        dest.writeValue(tripStatus);
        dest.writeValue(physicalDocumentsHandover);
    }

    public int describeContents() {
        return 0;
    }

}
