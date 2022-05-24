package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaxCharge implements Parcelable
{

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
    private List<String> billAttachments = null;
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
        this.taxType = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.billAttachments, (java.lang.String.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TaxCharge() {
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

    public List<String> getBillAttachments() {
        return billAttachments;
    }

    public void setBillAttachments(List<String> billAttachments) {
        this.billAttachments = billAttachments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(taxType);
        dest.writeValue(location);
        dest.writeValue(taxAmount);
        dest.writeList(billAttachments);
        dest.writeValue(createdDateTime);
    }

    public int describeContents() {
        return 0;
    }

}
