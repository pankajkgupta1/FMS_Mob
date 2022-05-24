package com.example.fleatmanagmentsystem.models.login.tripdetail;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TripInfo implements Parcelable {
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
    private Object cleanerId;
    @SerializedName("cleanerName")
    @Expose
    private Object cleanerName;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    @SerializedName("itineraryDirections")
    @Expose
    private List<ItineraryDirection> itineraryDirections = new ArrayList<>();
    public final static Creator<TripInfo> CREATOR = new Creator<TripInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TripInfo createFromParcel(android.os.Parcel in) {
            return new TripInfo(in);
        }

        public TripInfo[] newArray(int size) {
            return (new TripInfo[size]);
        }

    }
            ;

    protected TripInfo(android.os.Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadInfo, (LoadInfo.class.getClassLoader()));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleName = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleRegNo = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverName = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.cleanerName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.itineraryDirections, (ItineraryDirection.class.getClassLoader()));
    }

    public TripInfo() {
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

    public Object getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(Object cleanerId) {
        this.cleanerId = cleanerId;
    }

    public Object getCleanerName() {
        return cleanerName;
    }

    public void setCleanerName(Object cleanerName) {
        this.cleanerName = cleanerName;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public List<ItineraryDirection> getItineraryDirections() {
        return itineraryDirections;
    }

    public void setItineraryDirections(List<ItineraryDirection> itineraryDirections) {
        this.itineraryDirections = itineraryDirections;
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
        dest.writeList(itineraryDirections);
    }

    public int describeContents() {
        return 0;
    }
}
