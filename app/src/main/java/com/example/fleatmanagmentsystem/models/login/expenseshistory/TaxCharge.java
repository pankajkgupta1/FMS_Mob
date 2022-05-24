package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaxCharge implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("taxChargesPrefix")
    @Expose
    private String taxChargesPrefix;
    @SerializedName("taxChargesSequenceNumber")
    @Expose
    private Integer taxChargesSequenceNumber;
    @SerializedName("taxChargesId")
    @Expose
    private String taxChargesId;
    @SerializedName("taxType")
    @Expose
    private String taxType;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;
    @SerializedName("billAttachments")
    @Expose
    private String billAttachments;
    @SerializedName("createdDateTime")
    @Expose
    private String createdDateTime;
    public final static Creator<TaxCharge> CREATOR = new Creator<TaxCharge>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TaxCharge createFromParcel(android.os.Parcel in) {
            return new TaxCharge(in);
        }

        public TaxCharge[] newArray(int size) {
            return (new TaxCharge[size]);
        }

    }
            ;

    protected TaxCharge(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.taxChargesPrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.taxChargesSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.taxChargesId = ((String) in.readValue((String.class.getClassLoader())));
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.billAttachments = ((String) in.readValue((String.class.getClassLoader())));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TaxCharge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaxChargesPrefix() {
        return taxChargesPrefix;
    }

    public void setTaxChargesPrefix(String taxChargesPrefix) {
        this.taxChargesPrefix = taxChargesPrefix;
    }

    public Integer getTaxChargesSequenceNumber() {
        return taxChargesSequenceNumber;
    }

    public void setTaxChargesSequenceNumber(Integer taxChargesSequenceNumber) {
        this.taxChargesSequenceNumber = taxChargesSequenceNumber;
    }

    public String getTaxChargesId() {
        return taxChargesId;
    }

    public void setTaxChargesId(String taxChargesId) {
        this.taxChargesId = taxChargesId;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getBillAttachments() {
        return billAttachments;
    }

    public void setBillAttachments(String billAttachments) {
        this.billAttachments = billAttachments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(taxChargesPrefix);
        dest.writeValue(taxChargesSequenceNumber);
        dest.writeValue(taxChargesId);
        dest.writeValue(taxType);
        dest.writeValue(location);
        dest.writeValue(taxAmount);
        dest.writeValue(billAttachments);
        dest.writeValue(createdDateTime);
    }

    public int describeContents() {
        return 0;
    }

}
