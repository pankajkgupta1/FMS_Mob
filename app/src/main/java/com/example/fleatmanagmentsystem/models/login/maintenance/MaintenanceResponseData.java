package com.example.fleatmanagmentsystem.models.login.maintenance;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceResponseData implements Parcelable{

    @SerializedName("maintanenceWorkOrders")
    @Expose
    private List<MaintanenceWorkOrder> maintanenceWorkOrders = null;
    public final static Creator<MaintenanceResponseData> CREATOR = new Creator<MaintenanceResponseData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceResponseData createFromParcel(android.os.Parcel in) {
            return new MaintenanceResponseData(in);
        }

        public MaintenanceResponseData[] newArray(int size) {
            return (new MaintenanceResponseData[size]);
        }

    }
            ;

    protected MaintenanceResponseData(android.os.Parcel in) {
        in.readList(this.maintanenceWorkOrders, (MaintanenceWorkOrder.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintenanceResponseData() {
    }

    public MaintenanceResponseData(List<MaintanenceWorkOrder> maintanenceWorkOrders) {
        super();
        this.maintanenceWorkOrders = maintanenceWorkOrders;
    }

    public List<MaintanenceWorkOrder> getMaintanenceWorkOrders() {
        return maintanenceWorkOrders;
    }

    public void setMaintanenceWorkOrders(List<MaintanenceWorkOrder> maintanenceWorkOrders) {
        this.maintanenceWorkOrders = maintanenceWorkOrders;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(maintanenceWorkOrders);
    }

    public int describeContents() {
        return 0;
    }


    /*@SerializedName("maintanenceWorkOrders")
    @Expose
    private List<MaintanenceWorkOrder> maintanenceWorkOrders = null;
    public final static Creator<MaintenanceResponseData> CREATOR = new Creator<MaintenanceResponseData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceResponseData createFromParcel(android.os.Parcel in) {
            return new MaintenanceResponseData(in);
        }

        public MaintenanceResponseData[] newArray(int size) {
            return (new MaintenanceResponseData[size]);
        }

    }
            ;

    protected MaintenanceResponseData(android.os.Parcel in) {
        in.readList(this.maintanenceWorkOrders, (MaintanenceWorkOrder.class.getClassLoader()));
    }

    public MaintenanceResponseData() {
    }

    public MaintenanceResponseData(List<MaintanenceWorkOrder> maintanenceWorkOrders) {
        super();
        this.maintanenceWorkOrders = maintanenceWorkOrders;
    }

    public List<MaintanenceWorkOrder> getMaintanenceWorkOrders() {
        return maintanenceWorkOrders;
    }

    public void setMaintanenceWorkOrders(List<MaintanenceWorkOrder> maintanenceWorkOrders) {
        this.maintanenceWorkOrders = maintanenceWorkOrders;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeList(maintanenceWorkOrders);
    }

    public int describeContents() {
        return 0;
    }*/

}
