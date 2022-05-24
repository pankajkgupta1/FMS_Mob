package com.example.fleatmanagmentsystem.models.login.maintenanceclosure;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceClosureData implements Parcelable {

    @SerializedName("maintanenceStatusLog")
    @Expose
    private MaintanenceStatusLog maintanenceStatusLog;
    public final static Creator<MaintenanceClosureData> CREATOR = new Creator<MaintenanceClosureData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintenanceClosureData createFromParcel(android.os.Parcel in) {
            return new MaintenanceClosureData(in);
        }

        public MaintenanceClosureData[] newArray(int size) {
            return (new MaintenanceClosureData[size]);
        }

    }
            ;

    protected MaintenanceClosureData(android.os.Parcel in) {
        this.maintanenceStatusLog = ((MaintanenceStatusLog) in.readValue((MaintanenceStatusLog.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintenanceClosureData() {
    }

    /**
     *
     * @param maintanenceStatusLog
     */
    public MaintenanceClosureData(MaintanenceStatusLog maintanenceStatusLog) {
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
