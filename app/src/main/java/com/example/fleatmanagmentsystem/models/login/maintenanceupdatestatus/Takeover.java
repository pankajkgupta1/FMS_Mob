package com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Takeover implements Parcelable
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
    public final static Creator<Takeover> CREATOR = new Creator<Takeover>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Takeover createFromParcel(android.os.Parcel in) {
            return new Takeover(in);
        }

        public Takeover[] newArray(int size) {
            return (new Takeover[size]);
        }

    }
            ;

    protected Takeover(android.os.Parcel in) {
        in.readList(this.fuelAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.tireAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.speedometerAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.sideviewAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.frontpartAttachments, (java.lang.Object.class.getClassLoader()));
        in.readList(this.backpartAttachments, (java.lang.Object.class.getClassLoader()));
    }

    public Takeover() {
    }

    public Takeover(List<Object> fuelAttachments, List<Object> tireAttachments, List<Object> speedometerAttachments, List<Object> sideviewAttachments, List<Object> frontpartAttachments, List<Object> backpartAttachments) {
        super();
        this.fuelAttachments = fuelAttachments;
        this.tireAttachments = tireAttachments;
        this.speedometerAttachments = speedometerAttachments;
        this.sideviewAttachments = sideviewAttachments;
        this.frontpartAttachments = frontpartAttachments;
        this.backpartAttachments = backpartAttachments;
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
