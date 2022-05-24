package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TollCharge implements Parcelable
{

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
    private List<String> billAttachments = null;
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
        this.tollPlazaName = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.tollAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.fastagCardNumber = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.billAttachments, (java.lang.String.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TollCharge() {
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
