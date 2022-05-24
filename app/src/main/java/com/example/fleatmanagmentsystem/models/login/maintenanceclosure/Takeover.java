package com.example.fleatmanagmentsystem.models.login.maintenanceclosure;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Takeover implements Parcelable
{

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
    @SerializedName("backpartAttachments")
    @Expose
    private List<String> backpartAttachments = null;
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

    public Takeover(List<String> fuelAttachments, List<String> tireAttachments, List<String> speedometerAttachments, List<String> sideviewAttachments, List<String> frontpartAttachments, List<String> backpartAttachments) {
        super();
        this.fuelAttachments = fuelAttachments;
        this.tireAttachments = tireAttachments;
        this.speedometerAttachments = speedometerAttachments;
        this.sideviewAttachments = sideviewAttachments;
        this.frontpartAttachments = frontpartAttachments;
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

    public List<String> getBackpartAttachments() {
        return backpartAttachments;
    }

    public void setBackpartAttachments(List<String> backpartAttachments) {
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
