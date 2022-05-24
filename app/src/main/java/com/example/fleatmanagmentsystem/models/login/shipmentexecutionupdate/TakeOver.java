package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TakeOver implements Parcelable
{

    @SerializedName("backpartAttachments")
    @Expose
    private List<String> backpartAttachments = null;
    @SerializedName("fuelAttachments")
    @Expose
    private List<String> fuelAttachments = null;
    @SerializedName("tireAttachments")
    @Expose
    private List<String> tireAttachments = null;
    @SerializedName("speedometerAttachments")
    @Expose
    private List<String> speedometerAttachments = null;
    @SerializedName("sideviewAttachments")
    @Expose
    private List<String> sideviewAttachments = null;
    @SerializedName("frontpartAttachments")
    @Expose
    private List<String> frontpartAttachments = null;
    public final static Creator<TakeOver> CREATOR = new Creator<TakeOver>() {


        @SuppressWarnings({
                "unchecked"
        })
        public TakeOver createFromParcel(android.os.Parcel in) {
            return new TakeOver(in);
        }

        public TakeOver[] newArray(int size) {
            return (new TakeOver[size]);
        }

    }
            ;

    protected TakeOver(android.os.Parcel in) {
        in.readList(this.backpartAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.fuelAttachments, (java.lang.String.class.getClassLoader()));
        in.readList(this.tireAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.speedometerAttachments, (java.lang.String.class.getClassLoader()));
        in.readList(this.sideviewAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.frontpartAttachments, (java.lang.Object.class.getClassLoader()));
    }

    public TakeOver() {
    }

    public List<String> getBackpartAttachments() {
        return backpartAttachments;
    }

    public void setBackpartAttachments(List<String> backpartAttachments) {
        this.backpartAttachments = backpartAttachments;
    }

    public List<String> getFuelAttachments() {
        return fuelAttachments;
    }

    public void setFuelAttachments(List<String> fuelAttachments) {
        this.fuelAttachments = fuelAttachments;
    }

    public List<String> getTireAttachments() {
        return tireAttachments;
    }

    public void setTireAttachments(List<String> tireAttachments) {
        this.tireAttachments = tireAttachments;
    }

    public List<String> getSpeedometerAttachments() {
        return speedometerAttachments;
    }

    public void setSpeedometerAttachments(List<String> speedometerAttachments) {
        this.speedometerAttachments = speedometerAttachments;
    }

    public List<String> getSideviewAttachments() {
        return sideviewAttachments;
    }

    public void setSideviewAttachments(List<String> sideviewAttachments) {
        this.sideviewAttachments = sideviewAttachments;
    }

    public List<String> getFrontpartAttachments() {
        return frontpartAttachments;
    }

    public void setFrontpartAttachments(List<String> frontpartAttachments) {
        this.frontpartAttachments = frontpartAttachments;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(backpartAttachments);
        dest.writeList(fuelAttachments);
        dest.writeList(tireAttachments);
        dest.writeList(speedometerAttachments);
        dest.writeList(sideviewAttachments);
        dest.writeList(frontpartAttachments);
    }

    public int describeContents() {
        return 0;
    }

}
