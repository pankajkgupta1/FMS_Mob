package com.example.fleatmanagmentsystem.models.login.tripdetail;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WaypointsInfo implements Parcelable {

    @SerializedName("waypointLocation")
    @Expose
    private String waypointLocation;
    @SerializedName("waypointLocationState")
    @Expose
    private String waypointLocationState;
    @SerializedName("waypointLatitude")
    @Expose
    private String waypointLatitude;
    @SerializedName("waypointLongitude")
    @Expose
    private String waypointLongitude;
    public final static Creator<WaypointsInfo> CREATOR = new Creator<WaypointsInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public WaypointsInfo createFromParcel(android.os.Parcel in) {
            return new WaypointsInfo(in);
        }

        public WaypointsInfo[] newArray(int size) {
            return (new WaypointsInfo[size]);
        }

    }
            ;

    protected WaypointsInfo(android.os.Parcel in) {
        this.waypointLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.waypointLocationState = ((String) in.readValue((String.class.getClassLoader())));
        this.waypointLatitude = ((String) in.readValue((String.class.getClassLoader())));
        this.waypointLongitude = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WaypointsInfo() {
    }

    public String getWaypointLocation() {
        return waypointLocation;
    }

    public void setWaypointLocation(String waypointLocation) {
        this.waypointLocation = waypointLocation;
    }

    public String getWaypointLocationState() {
        return waypointLocationState;
    }

    public void setWaypointLocationState(String waypointLocationState) {
        this.waypointLocationState = waypointLocationState;
    }

    public String getWaypointLatitude() {
        return waypointLatitude;
    }

    public void setWaypointLatitude(String waypointLatitude) {
        this.waypointLatitude = waypointLatitude;
    }

    public String getWaypointLongitude() {
        return waypointLongitude;
    }

    public void setWaypointLongitude(String waypointLongitude) {
        this.waypointLongitude = waypointLongitude;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(waypointLocation);
        dest.writeValue(waypointLocationState);
        dest.writeValue(waypointLatitude);
        dest.writeValue(waypointLongitude);
    }

    public int describeContents() {
        return 0;
    }
}
