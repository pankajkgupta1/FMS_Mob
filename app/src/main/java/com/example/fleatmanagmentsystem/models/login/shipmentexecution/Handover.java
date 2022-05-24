package com.example.fleatmanagmentsystem.models.login.shipmentexecution;

import java.io.Serializable;
import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Handover implements Serializable, Parcelable
{

    @SerializedName("fuelAttachments")
    @Expose
    private List<Object> fuelAttachments = null;
    @SerializedName("tireAttachments")
    @Expose
    private List<Object> tireAttachments = null;
    @SerializedName("speedometerAttachments")
    @Expose
    private List<Object> speedometerAttachments = null;
    @SerializedName("sideviewAttachments")
    @Expose
    private List<Object> sideviewAttachments = null;
    @SerializedName("frontpartAttachments")
    @Expose
    private List<Object> frontpartAttachments = null;
    @SerializedName("backpartAttachments")
    @Expose
    private List<Object> backpartAttachments = null;
    public final static Creator<Handover> CREATOR = new Creator<Handover>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Handover createFromParcel(android.os.Parcel in) {
            return new Handover(in);
        }

        public Handover[] newArray(int size) {
            return (new Handover[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8816263848661812397L;

    protected Handover(android.os.Parcel in) {
        in.readList(this.fuelAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.tireAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.speedometerAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.sideviewAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.frontpartAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.backpartAttachments, (java.lang.Object.class.getClassLoader()));
    }

    public Handover() {
    }

    public List<Object> getFuelAttachments() {
        return fuelAttachments;
    }

    public void setFuelAttachments(List<Object> fuelAttachments) {
        this.fuelAttachments = fuelAttachments;
    }

    public List<Object> getTireAttachments() {
        return tireAttachments;
    }

    public void setTireAttachments(List<Object> tireAttachments) {
        this.tireAttachments = tireAttachments;
    }

    public List<Object> getSpeedometerAttachments() {
        return speedometerAttachments;
    }

    public void setSpeedometerAttachments(List<Object> speedometerAttachments) {
        this.speedometerAttachments = speedometerAttachments;
    }

    public List<Object> getSideviewAttachments() {
        return sideviewAttachments;
    }

    public void setSideviewAttachments(List<Object> sideviewAttachments) {
        this.sideviewAttachments = sideviewAttachments;
    }

    public List<Object> getFrontpartAttachments() {
        return frontpartAttachments;
    }

    public void setFrontpartAttachments(List<Object> frontpartAttachments) {
        this.frontpartAttachments = frontpartAttachments;
    }

    public List<Object> getBackpartAttachments() {
        return backpartAttachments;
    }

    public void setBackpartAttachments(List<Object> backpartAttachments) {
        this.backpartAttachments = backpartAttachments;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(fuelAttachments);
        dest.writeList(tireAttachments);
        dest.writeList(speedometerAttachments);
        dest.writeList(sideviewAttachments);
        dest.writeList(frontpartAttachments);
        dest.writeList(backpartAttachments);
    }

    public int describeContents() {
        return 0;
    }

}
