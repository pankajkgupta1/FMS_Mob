package com.example.fleatmanagmentsystem.models.login.tripdetail;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TripInfoList implements Parcelable {

    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("loadInfo")
    @Expose
    private List<LoadInfo> loadInfo = new ArrayList<>();
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("vehicleName")
    @Expose
    private String vehicleName;
    @SerializedName("vehicleRegNo")
    @Expose
    private String vehicleRegNo;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("cleanerId")
    @Expose
    private String cleanerId;
    @SerializedName("cleanerName")
    @Expose
    private String cleanerName;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    public final static Creator<TripInfoList> CREATOR = new Creator<TripInfoList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripInfoList createFromParcel(android.os.Parcel in) {
            return new TripInfoList(in);
        }

        public TripInfoList[] newArray(int size) {
            return (new TripInfoList[size]);
        }

    };

    protected TripInfoList(android.os.Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadInfo, (LoadInfo.class.getClassLoader()));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleName = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleRegNo = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerId = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerName = ((String) in.readValue((String.class.getClassLoader())));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TripInfoList() {
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

    public List<LoadInfo> getLoadInfo() {
        return loadInfo;
    }

    public void setLoadInfo(List<LoadInfo> loadInfo) {
        this.loadInfo = loadInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getCleanerName() {
        return cleanerName;
    }

    public void setCleanerName(String cleanerName) {
        this.cleanerName = cleanerName;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeList(loadInfo);
        dest.writeValue(country);
        dest.writeValue(vehicleId);
        dest.writeValue(vehicleName);
        dest.writeValue(vehicleRegNo);
        dest.writeValue(driverId);
        dest.writeValue(driverName);
        dest.writeValue(cleanerId);
        dest.writeValue(cleanerName);
        dest.writeValue(tripStatus);
    }

    public int describeContents() {
        return 0;
    }
}