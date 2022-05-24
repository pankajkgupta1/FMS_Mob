package com.example.fleatmanagmentsystem.models.login.shipmentloaded;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentLoadedData implements Serializable, Parcelable
{

    @SerializedName("trip")
    @Expose
    private Trip trip;
    public final static Creator<ShipmentLoadedData> CREATOR = new Creator<ShipmentLoadedData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentLoadedData createFromParcel(android.os.Parcel in) {
            return new ShipmentLoadedData(in);
        }

        public ShipmentLoadedData[] newArray(int size) {
            return (new ShipmentLoadedData[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4747039126165127666L;

    protected ShipmentLoadedData(android.os.Parcel in) {
        this.trip = ((Trip) in.readValue((Trip.class.getClassLoader())));
    }

    public ShipmentLoadedData() {
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(trip);
    }

    public int describeContents() {
        return 0;
    }

}