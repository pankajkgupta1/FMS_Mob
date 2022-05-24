package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FuelCharge implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("fuelChargePrefix")
    @Expose
    private String fuelChargePrefix;
    @SerializedName("fuelChargeSequenceNumber")
    @Expose
    private Integer fuelChargeSequenceNumber;
    @SerializedName("fuelChargeId")
    @Expose
    private String fuelChargeId;
    @SerializedName("fuelStation")
    @Expose
    private String fuelStation;
    @SerializedName("fuelLocation")
    @Expose
    private String fuelLocation;
    @SerializedName("petroCardNumber")
    @Expose
    private String petroCardNumber;
    @SerializedName("fuelQuantity")
    @Expose
    private String fuelQuantity;
    @SerializedName("fuelUom")
    @Expose
    private String fuelUom;
    @SerializedName("fuelRate")
    @Expose
    private Double fuelRate;
    @SerializedName("fuelAmount")
    @Expose
    private String fuelAmount;
    @SerializedName("currentOdometer")
    @Expose
    private Double currentOdometer;
    @SerializedName("vendorId")
    @Expose
    private String vendorId;
    @SerializedName("petroMachineAttatchments")
    @Expose
    private List<Object> petroMachineAttatchments = null;
    @SerializedName("fuelBillAttatchments")
    @Expose
    private List<Object> fuelBillAttatchments = null;
    @SerializedName("currentOdometerAttatchments")
    @Expose
    private List<Object> currentOdometerAttatchments = null;
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
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelChargePrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelChargeSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fuelChargeId = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelStation = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.petroCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelQuantity = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelUom = ((String) in.readValue((String.class.getClassLoader())));
        this.fuelRate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fuelAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.currentOdometer = ((Double) in.readValue((Double.class.getClassLoader())));
        this.vendorId = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.petroMachineAttatchments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.fuelBillAttatchments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.currentOdometerAttatchments, (java.lang.Object.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FuelCharge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuelChargePrefix() {
        return fuelChargePrefix;
    }

    public void setFuelChargePrefix(String fuelChargePrefix) {
        this.fuelChargePrefix = fuelChargePrefix;
    }

    public Integer getFuelChargeSequenceNumber() {
        return fuelChargeSequenceNumber;
    }

    public void setFuelChargeSequenceNumber(Integer fuelChargeSequenceNumber) {
        this.fuelChargeSequenceNumber = fuelChargeSequenceNumber;
    }

    public String getFuelChargeId() {
        return fuelChargeId;
    }

    public void setFuelChargeId(String fuelChargeId) {
        this.fuelChargeId = fuelChargeId;
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

    public String getPetroCardNumber() {
        return petroCardNumber;
    }

    public void setPetroCardNumber(String petroCardNumber) {
        this.petroCardNumber = petroCardNumber;
    }

    public String getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(String fuelQuantity) {
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

    public String getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(String fuelAmount) {
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

    public List<Object> getPetroMachineAttatchments() {
        return petroMachineAttatchments;
    }

    public void setPetroMachineAttatchments(List<Object> petroMachineAttatchments) {
        this.petroMachineAttatchments = petroMachineAttatchments;
    }

    public List<Object> getFuelBillAttatchments() {
        return fuelBillAttatchments;
    }

    public void setFuelBillAttatchments(List<Object> fuelBillAttatchments) {
        this.fuelBillAttatchments = fuelBillAttatchments;
    }

    public List<Object> getCurrentOdometerAttatchments() {
        return currentOdometerAttatchments;
    }

    public void setCurrentOdometerAttatchments(List<Object> currentOdometerAttatchments) {
        this.currentOdometerAttatchments = currentOdometerAttatchments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(fuelChargePrefix);
        dest.writeValue(fuelChargeSequenceNumber);
        dest.writeValue(fuelChargeId);
        dest.writeValue(fuelStation);
        dest.writeValue(fuelLocation);
        dest.writeValue(petroCardNumber);
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
