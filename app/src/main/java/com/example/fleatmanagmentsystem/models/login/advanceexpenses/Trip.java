package com.example.fleatmanagmentsystem.models.login.advanceexpenses;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Trip implements Parcelable {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("tripSequenceNumber")
    @Expose
    private Integer tripSequenceNumber;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("loadSequenceHelper")
    @Expose
    private List<LoadSequenceHelper> loadSequenceHelper = null;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("vehicleName")
    @Expose
    private String vehicleName;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("cleanerId")
    @Expose
    private String cleanerId;
    @SerializedName("equipmentId")
    @Expose
    private String equipmentId;
    @SerializedName("plannedTripStartDateTime")
    @Expose
    private String plannedTripStartDateTime;
    @SerializedName("plannedTripEndDateTime")
    @Expose
    private String plannedTripEndDateTime;
    @SerializedName("actualTripStartDateTime")
    @Expose
    private String actualTripStartDateTime;
    @SerializedName("actualTripEndDateTime")
    @Expose
    private String actualTripEndDateTime;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    @SerializedName("tripTrackStatus")
    @Expose
    private String tripTrackStatus;
    public final static Creator<Trip> CREATOR = new Creator<Trip>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Trip createFromParcel(android.os.Parcel in) {
            return new Trip(in);
        }

        public Trip[] newArray(int size) {
            return (new Trip[size]);
        }

    }
            ;

    protected Trip(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.prefix = ((String) in.readValue((String.class.getClassLoader())));
        this.tripSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadSequenceHelper, (LoadSequenceHelper.class.getClassLoader()));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleName = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerId = ((String) in.readValue((String.class.getClassLoader())));
        this.equipmentId = ((String) in.readValue((String.class.getClassLoader())));
        this.plannedTripStartDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.plannedTripEndDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.actualTripStartDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.actualTripEndDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.createDate = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.tripTrackStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Trip() {
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getTripSequenceNumber() {
        return tripSequenceNumber;
    }

    public void setTripSequenceNumber(Integer tripSequenceNumber) {
        this.tripSequenceNumber = tripSequenceNumber;
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

    public List<LoadSequenceHelper> getLoadSequenceHelper() {
        return loadSequenceHelper;
    }

    public void setLoadSequenceHelper(List<LoadSequenceHelper> loadSequenceHelper) {
        this.loadSequenceHelper = loadSequenceHelper;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getPlannedTripStartDateTime() {
        return plannedTripStartDateTime;
    }

    public void setPlannedTripStartDateTime(String plannedTripStartDateTime) {
        this.plannedTripStartDateTime = plannedTripStartDateTime;
    }

    public String getPlannedTripEndDateTime() {
        return plannedTripEndDateTime;
    }

    public void setPlannedTripEndDateTime(String plannedTripEndDateTime) {
        this.plannedTripEndDateTime = plannedTripEndDateTime;
    }

    public String getActualTripStartDateTime() {
        return actualTripStartDateTime;
    }

    public void setActualTripStartDateTime(String actualTripStartDateTime) {
        this.actualTripStartDateTime = actualTripStartDateTime;
    }

    public String getActualTripEndDateTime() {
        return actualTripEndDateTime;
    }

    public void setActualTripEndDateTime(String actualTripEndDateTime) {
        this.actualTripEndDateTime = actualTripEndDateTime;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public String getTripTrackStatus() {
        return tripTrackStatus;
    }

    public void setTripTrackStatus(String tripTrackStatus) {
        this.tripTrackStatus = tripTrackStatus;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(tripId);
        dest.writeValue(prefix);
        dest.writeValue(tripSequenceNumber);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeList(loadSequenceHelper);
        dest.writeValue(vehicleId);
        dest.writeValue(vehicleName);
        dest.writeValue(driverId);
        dest.writeValue(cleanerId);
        dest.writeValue(equipmentId);
        dest.writeValue(plannedTripStartDateTime);
        dest.writeValue(plannedTripEndDateTime);
        dest.writeValue(actualTripStartDateTime);
        dest.writeValue(actualTripEndDateTime);
        dest.writeValue(createDate);
        dest.writeValue(status);
        dest.writeValue(tripStatus);
        dest.writeValue(tripTrackStatus);
    }

    public int describeContents() {
        return 0;
    }

}
