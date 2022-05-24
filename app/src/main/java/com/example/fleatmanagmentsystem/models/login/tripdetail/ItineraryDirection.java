package com.example.fleatmanagmentsystem.models.login.tripdetail;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItineraryDirection implements Parcelable {

    @SerializedName("loadId")
    @Expose
    private String loadId;
    @SerializedName("tripSequence")
    @Expose
    private Integer tripSequence;
    @SerializedName("sourceLocation")
    @Expose
    private String sourceLocation;
    @SerializedName("sourceLocationState")
    @Expose
    private String sourceLocationState;
    @SerializedName("sourceLocationLatitude")
    @Expose
    private String sourceLocationLatitude;
    @SerializedName("sourceLocationLongitude")
    @Expose
    private String sourceLocationLongitude;
    @SerializedName("destinationLocation")
    @Expose
    private String destinationLocation;
    @SerializedName("destinationLocationState")
    @Expose
    private String destinationLocationState;
    @SerializedName("destinationLocationLatitude")
    @Expose
    private String destinationLocationLatitude;
    @SerializedName("destinationLocationLongitude")
    @Expose
    private String destinationLocationLongitude;
    @SerializedName("waypointsInfo")
    @Expose
    private List<WaypointsInfo> waypointsInfo = new ArrayList<>();
    @SerializedName("travelMode")
    @Expose
    private String travelMode;
    public final static Creator<ItineraryDirection> CREATOR = new Creator<ItineraryDirection>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ItineraryDirection createFromParcel(android.os.Parcel in) {
            return new ItineraryDirection(in);
        }

        public ItineraryDirection[] newArray(int size) {
            return (new ItineraryDirection[size]);
        }

    }
            ;

    protected ItineraryDirection(android.os.Parcel in) {
        this.loadId = ((String) in.readValue((String.class.getClassLoader())));
        this.tripSequence = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.sourceLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceLocationState = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceLocationLatitude = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceLocationLongitude = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocationState = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocationLatitude = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocationLongitude = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.waypointsInfo, (WaypointsInfo.class.getClassLoader()));
        this.travelMode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ItineraryDirection() {
    }

    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = loadId;
    }

    public Integer getTripSequence() {
        return tripSequence;
    }

    public void setTripSequence(Integer tripSequence) {
        this.tripSequence = tripSequence;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getSourceLocationState() {
        return sourceLocationState;
    }

    public void setSourceLocationState(String sourceLocationState) {
        this.sourceLocationState = sourceLocationState;
    }

    public String getSourceLocationLatitude() {
        return sourceLocationLatitude;
    }

    public void setSourceLocationLatitude(String sourceLocationLatitude) {
        this.sourceLocationLatitude = sourceLocationLatitude;
    }

    public String getSourceLocationLongitude() {
        return sourceLocationLongitude;
    }

    public void setSourceLocationLongitude(String sourceLocationLongitude) {
        this.sourceLocationLongitude = sourceLocationLongitude;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getDestinationLocationState() {
        return destinationLocationState;
    }

    public void setDestinationLocationState(String destinationLocationState) {
        this.destinationLocationState = destinationLocationState;
    }

    public String getDestinationLocationLatitude() {
        return destinationLocationLatitude;
    }

    public void setDestinationLocationLatitude(String destinationLocationLatitude) {
        this.destinationLocationLatitude = destinationLocationLatitude;
    }

    public String getDestinationLocationLongitude() {
        return destinationLocationLongitude;
    }

    public void setDestinationLocationLongitude(String destinationLocationLongitude) {
        this.destinationLocationLongitude = destinationLocationLongitude;
    }

    public List<WaypointsInfo> getWaypointsInfo() {
        return waypointsInfo;
    }

    public void setWaypointsInfo(List<WaypointsInfo> waypointsInfo) {
        this.waypointsInfo = waypointsInfo;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(loadId);
        dest.writeValue(tripSequence);
        dest.writeValue(sourceLocation);
        dest.writeValue(sourceLocationState);
        dest.writeValue(sourceLocationLatitude);
        dest.writeValue(sourceLocationLongitude);
        dest.writeValue(destinationLocation);
        dest.writeValue(destinationLocationState);
        dest.writeValue(destinationLocationLatitude);
        dest.writeValue(destinationLocationLongitude);
        dest.writeList(waypointsInfo);
        dest.writeValue(travelMode);
    }

    public int describeContents() {
        return 0;
    }
}
