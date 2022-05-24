package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TollCharge implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("tollChargePrefix")
    @Expose
    private String tollChargePrefix;
    @SerializedName("tollChargeSequenceNumber")
    @Expose
    private Integer tollChargeSequenceNumber;
    @SerializedName("tollChargeId")
    @Expose
    private String tollChargeId;
    @SerializedName("tollPlazaName")
    @Expose
    private String tollPlazaName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("tollAmount")
    @Expose
    private Double tollAmount;
    @SerializedName("fastagCardNumber")
    @Expose
    private String fastagCardNumber;
    @SerializedName("billAttachments")
    @Expose
    private List<Object> billAttachments = null;
    @SerializedName("createdDateTime")
    @Expose
    private String createdDateTime;
    public final static Creator<TollCharge> CREATOR = new Creator<TollCharge>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TollCharge createFromParcel(android.os.Parcel in) {
            return new TollCharge(in);
        }

        public TollCharge[] newArray(int size) {
            return (new TollCharge[size]);
        }

    }
            ;

    protected TollCharge(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.tollChargePrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.tollChargeSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.tollChargeId = ((String) in.readValue((String.class.getClassLoader())));
        this.tollPlazaName = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.tollAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fastagCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.billAttachments, (java.lang.Object.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TollCharge() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTollChargePrefix() {
        return tollChargePrefix;
    }

    public void setTollChargePrefix(String tollChargePrefix) {
        this.tollChargePrefix = tollChargePrefix;
    }

    public Integer getTollChargeSequenceNumber() {
        return tollChargeSequenceNumber;
    }

    public void setTollChargeSequenceNumber(Integer tollChargeSequenceNumber) {
        this.tollChargeSequenceNumber = tollChargeSequenceNumber;
    }

    public String getTollChargeId() {
        return tollChargeId;
    }

    public void setTollChargeId(String tollChargeId) {
        this.tollChargeId = tollChargeId;
    }

    public String getTollPlazaName() {
        return tollPlazaName;
    }

    public void setTollPlazaName(String tollPlazaName) {
        this.tollPlazaName = tollPlazaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getTollAmount() {
        return tollAmount;
    }

    public void setTollAmount(Double tollAmount) {
        this.tollAmount = tollAmount;
    }

    public String getFastagCardNumber() {
        return fastagCardNumber;
    }

    public void setFastagCardNumber(String fastagCardNumber) {
        this.fastagCardNumber = fastagCardNumber;
    }

    public List<Object> getBillAttachments() {
        return billAttachments;
    }

    public void setBillAttachments(List<Object> billAttachments) {
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
        dest.writeValue(tollChargePrefix);
        dest.writeValue(tollChargeSequenceNumber);
        dest.writeValue(tollChargeId);
        dest.writeValue(tollPlazaName);
        dest.writeValue(location);
        dest.writeValue(tollAmount);
        dest.writeValue(fastagCardNumber);
        dest.writeList(billAttachments);
        dest.writeValue(createdDateTime);
    }

    public int describeContents() {
        return 0;
    }

}
