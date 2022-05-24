package com.example.fleatmanagmentsystem.models.login.drivertripIdlist;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Confirmation implements Parcelable
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
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("driverEmailId")
    @Expose
    private String driverEmailId;
    @SerializedName("driverPhoneNumber")
    @Expose
    private String driverPhoneNumber;
    @SerializedName("driverStatus")
    @Expose
    private String driverStatus;
    @SerializedName("driverCallStatus")
    @Expose
    private Object driverCallStatus;
    @SerializedName("cleanerId")
    @Expose
    private String cleanerId;
    @SerializedName("cleanerEmailId")
    @Expose
    private String cleanerEmailId;
    @SerializedName("cleanerPhoneNumber")
    @Expose
    private String cleanerPhoneNumber;
    @SerializedName("cleanerStatus")
    @Expose
    private Object cleanerStatus;
    @SerializedName("cleanerCallStatus")
    @Expose
    private Object cleanerCallStatus;
    public final static Creator<Confirmation> CREATOR = new Creator<Confirmation>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Confirmation createFromParcel(android.os.Parcel in) {
            return new Confirmation(in);
        }

        public Confirmation[] newArray(int size) {
            return (new Confirmation[size]);
        }

    }
            ;

    protected Confirmation(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverEmailId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.driverStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.driverCallStatus = ((Object) in.readValue((Object.class.getClassLoader())));
        this.cleanerId = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerEmailId = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerPhoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerStatus = ((Object) in.readValue((Object.class.getClassLoader())));
        this.cleanerCallStatus = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Confirmation() {
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverEmailId() {
        return driverEmailId;
    }

    public void setDriverEmailId(String driverEmailId) {
        this.driverEmailId = driverEmailId;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Object getDriverCallStatus() {
        return driverCallStatus;
    }

    public void setDriverCallStatus(Object driverCallStatus) {
        this.driverCallStatus = driverCallStatus;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getCleanerEmailId() {
        return cleanerEmailId;
    }

    public void setCleanerEmailId(String cleanerEmailId) {
        this.cleanerEmailId = cleanerEmailId;
    }

    public String getCleanerPhoneNumber() {
        return cleanerPhoneNumber;
    }

    public void setCleanerPhoneNumber(String cleanerPhoneNumber) {
        this.cleanerPhoneNumber = cleanerPhoneNumber;
    }

    public Object getCleanerStatus() {
        return cleanerStatus;
    }

    public void setCleanerStatus(Object cleanerStatus) {
        this.cleanerStatus = cleanerStatus;
    }

    public Object getCleanerCallStatus() {
        return cleanerCallStatus;
    }

    public void setCleanerCallStatus(Object cleanerCallStatus) {
        this.cleanerCallStatus = cleanerCallStatus;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(driverId);
        dest.writeValue(driverEmailId);
        dest.writeValue(driverPhoneNumber);
        dest.writeValue(driverStatus);
        dest.writeValue(driverCallStatus);
        dest.writeValue(cleanerId);
        dest.writeValue(cleanerEmailId);
        dest.writeValue(cleanerPhoneNumber);
        dest.writeValue(cleanerStatus);
        dest.writeValue(cleanerCallStatus);
    }

    public int describeContents() {
        return 0;
    }

}
