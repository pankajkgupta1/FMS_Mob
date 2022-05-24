package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FuelCharge implements Parcelable
{

    @SerializedName("petroCardNumber")
    @Expose
    private String petroCardNumber;
    @SerializedName("fuelStation")
    @Expose
    private String fuelStation;
    @SerializedName("fuelLocation")
    @Expose
    private String fuelLocation;
    @SerializedName("fuelQuantity")
    @Expose
    private Double fuelQuantity;
    @SerializedName("fuelUom")
    @Expose
    private String fuelUom;
    @SerializedName("fuelRate")
    @Expose
    private Double fuelRate;
    @SerializedName("fuelAmount")
    @Expose
    private Double fuelAmount;
    @SerializedName("currentOdometer")
    @Expose
    private Double currentOdometer;
    @SerializedName("vendorId")
    @Expose
    private String vendorId;
    @SerializedName("petroMachineAttatchments")
    @Expose
    private List<String> petroMachineAttatchments = null;
    @SerializedName("fuelBillAttatchments")
    @Expose
    private List<String> fuelBillAttatchments = null;
    @SerializedName("currentOdometerAttatchments")
    @Expose
    private List<String> currentOdometerAttatchments = null;
    @SerializedName("createdDateTime")
    @Expose
    private String createdDateTime;
    public final static Creator<FuelCharge> CREATOR = new Creator<FuelCharge>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FuelCharge createFromParcel(android.os.Parcel in) {
            return new FuelCharge(in);
        }

        public FuelCharge[] newArray(int size) {
            return (new FuelCharge[size]);
        }

    }
            ;

    protected FuelCharge(android.os.Parcel in) {
        this.petroCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelStation = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelQuantity = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.fuelUom = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelRate = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.fuelAmount = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.currentOdometer = ((Double) in.readValue((Double.class.getClassLoader())));
        this.vendorId = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.petroMachineAttatchments, (java.lang.String.class.getClassLoader()));
        in.readList(this.fuelBillAttatchments, (java.lang.String.class.getClassLoader()));
        in.readList(this.currentOdometerAttatchments, (java.lang.String.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FuelCharge() {
    }

    public String getPetroCardNumber() {
        return petroCardNumber;
    }

    public void setPetroCardNumber(String petroCardNumber) {
        this.petroCardNumber = petroCardNumber;
    }

    public String getFuelStation() {
        return fuelStation;
    }

    public void setFuelStation(String fuelStation) {
        this.fuelStation = fuelStation;
    }

    public String getFuelLocation() {
        return fuelLocation;
    }

    public void setFuelLocation(String fuelLocation) {
        this.fuelLocation = fuelLocation;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public String getFuelUom() {
        return fuelUom;
    }

    public void setFuelUom(String fuelUom) {
        this.fuelUom = fuelUom;
    }

    public Double getFuelRate() {
        return fuelRate;
    }

    public void setFuelRate(Double fuelRate) {
        this.fuelRate = fuelRate;
    }

    public Double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(Double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public Double getCurrentOdometer() {
        return currentOdometer;
    }

    public void setCurrentOdometer(Double currentOdometer) {
        this.currentOdometer = currentOdometer;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public List<String> getPetroMachineAttatchments() {
        return petroMachineAttatchments;
    }

    public void setPetroMachineAttatchments(List<String> petroMachineAttatchments) {
        this.petroMachineAttatchments = petroMachineAttatchments;
    }

    public List<String> getFuelBillAttatchments() {
        return fuelBillAttatchments;
    }

    public void setFuelBillAttatchments(List<String> fuelBillAttatchments) {
        this.fuelBillAttatchments = fuelBillAttatchments;
    }

    public List<String> getCurrentOdometerAttatchments() {
        return currentOdometerAttatchments;
    }

    public void setCurrentOdometerAttatchments(List<String> currentOdometerAttatchments) {
        this.currentOdometerAttatchments = currentOdometerAttatchments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(petroCardNumber);
        dest.writeValue(fuelStation);
        dest.writeValue(fuelLocation);
        dest.writeValue(fuelQuantity);
        dest.writeValue(fuelUom);
        dest.writeValue(fuelRate);
        dest.writeValue(fuelAmount);
        dest.writeValue(currentOdometer);
        dest.writeValue(vendorId);
        dest.writeList(petroMachineAttatchments);
        dest.writeList(fuelBillAttatchments);
        dest.writeList(currentOdometerAttatchments);
        dest.writeValue(createdDateTime);
    }

    public int describeContents() {
        return 0;
    }

}