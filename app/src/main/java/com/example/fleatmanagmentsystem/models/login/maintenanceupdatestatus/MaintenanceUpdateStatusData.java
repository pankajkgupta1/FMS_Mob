package com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceUpdateStatusData implements Parcelable {

    @SerializedName("MaintanenceStatusLog")
    @Expose
    private MaintanenceStatusLog maintanenceStatusLog;
    public final static Creator<MaintenanceUpdateStatusData> CREATOR = new Creator<MaintenanceUpdateStatusData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceUpdateStatusData createFromParcel(android.os.Parcel in) {
            return new MaintenanceUpdateStatusData(in);
        }

        public MaintenanceUpdateStatusData[] newArray(int size) {
            return (new MaintenanceUpdateStatusData[size]);
        }

    }
            ;

    protected MaintenanceUpdateStatusData(android.os.Parcel in) {
        this.maintanenceStatusLog = ((MaintanenceStatusLog) in.readValue((MaintanenceStatusLog.class.getClassLoader())));
    }

    public MaintenanceUpdateStatusData() {
    }

    public MaintenanceUpdateStatusData(MaintanenceStatusLog maintanenceStatusLog) {
        super();
        this.maintanenceStatusLog = maintanenceStatusLog;
    }

    public MaintanenceStatusLog getMaintanenceStatusLog() {
        return maintanenceStatusLog;
    }

    public void setMaintanenceStatusLog(MaintanenceStatusLog maintanenceStatusLog) {
        this.maintanenceStatusLog = maintanenceStatusLog;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(maintanenceStatusLog);
    }

    public int describeContents() {
        return 0;
    }

}
