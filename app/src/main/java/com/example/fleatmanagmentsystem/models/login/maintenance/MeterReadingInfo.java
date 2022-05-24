package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MeterReadingInfo implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private Object id;
    @SerializedName("workOrderId")
    @Expose
    private Object workOrderId;
    @SerializedName("scheduleDateTime")
    @Expose
    private String scheduleDateTime;
    @SerializedName("currentMeterReading")
    @Expose
    private Object currentMeterReading;
    @SerializedName("pastMeterReading")
    @Expose
    private Object pastMeterReading;
    @SerializedName("nextTriggerReading")
    @Expose
    private Object nextTriggerReading;
    @SerializedName("nextTriggerDate")
    @Expose
    private Object nextTriggerDate;
    public final static Creator<MeterReadingInfo> CREATOR = new Creator<MeterReadingInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MeterReadingInfo createFromParcel(android.os.Parcel in) {
            return new MeterReadingInfo(in);
        }

        public MeterReadingInfo[] newArray(int size) {
            return (new MeterReadingInfo[size]);
        }

    }
            ;

    protected MeterReadingInfo(android.os.Parcel in) {
        this.id = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workOrderId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.scheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.currentMeterReading = ((Object) in.readValue((Object.class.getClassLoader())));
        this.pastMeterReading = ((Object) in.readValue((Object.class.getClassLoader())));
        this.nextTriggerReading = ((Object) in.readValue((Object.class.getClassLoader())));
        this.nextTriggerDate = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MeterReadingInfo() {
    }

    /**
     *
     * @param scheduleDateTime
     * @param currentMeterReading
     * @param nextTriggerReading
     * @param id
     * @param workOrderId
     * @param pastMeterReading
     * @param nextTriggerDate
     */
    public MeterReadingInfo(Object id, Object workOrderId, String scheduleDateTime, Object currentMeterReading, Object pastMeterReading, Object nextTriggerReading, Object nextTriggerDate) {
        super();
        this.id = id;
        this.workOrderId = workOrderId;
        this.scheduleDateTime = scheduleDateTime;
        this.currentMeterReading = currentMeterReading;
        this.pastMeterReading = pastMeterReading;
        this.nextTriggerReading = nextTriggerReading;
        this.nextTriggerDate = nextTriggerDate;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Object workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    public Object getCurrentMeterReading() {
        return currentMeterReading;
    }

    public void setCurrentMeterReading(Object currentMeterReading) {
        this.currentMeterReading = currentMeterReading;
    }

    public Object getPastMeterReading() {
        return pastMeterReading;
    }

    public void setPastMeterReading(Object pastMeterReading) {
        this.pastMeterReading = pastMeterReading;
    }

    public Object getNextTriggerReading() {
        return nextTriggerReading;
    }

    public void setNextTriggerReading(Object nextTriggerReading) {
        this.nextTriggerReading = nextTriggerReading;
    }

    public Object getNextTriggerDate() {
        return nextTriggerDate;
    }

    public void setNextTriggerDate(Object nextTriggerDate) {
        this.nextTriggerDate = nextTriggerDate;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(workOrderId);
        dest.writeValue(scheduleDateTime);
        dest.writeValue(currentMeterReading);
        dest.writeValue(pastMeterReading);
        dest.writeValue(nextTriggerReading);
        dest.writeValue(nextTriggerDate);
    }

    public int describeContents() {
        return 0;
    }

    /*@SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;
    @SerializedName("scheduleDateTime")
    @Expose
    private String scheduleDateTime;
    @SerializedName("currentMeterReading")
    @Expose
    private String currentMeterReading;
    @SerializedName("pastMeterReading")
    @Expose
    private String pastMeterReading;
    @SerializedName("nextTriggerReading")
    @Expose
    private String nextTriggerReading;
    @SerializedName("nextTriggerDate")
    @Expose
    private String nextTriggerDate;
    public final static Creator<MeterReadingInfo> CREATOR = new Creator<MeterReadingInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MeterReadingInfo createFromParcel(android.os.Parcel in) {
            return new MeterReadingInfo(in);
        }

        public MeterReadingInfo[] newArray(int size) {
            return (new MeterReadingInfo[size]);
        }

    }
            ;

    protected MeterReadingInfo(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.scheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.currentMeterReading = ((String) in.readValue((String.class.getClassLoader())));
        this.pastMeterReading = ((String) in.readValue((String.class.getClassLoader())));
        this.nextTriggerReading = ((String) in.readValue((String.class.getClassLoader())));
        this.nextTriggerDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MeterReadingInfo() {
    }

    public MeterReadingInfo(String id, String workOrderId, String scheduleDateTime, String currentMeterReading, String pastMeterReading, String nextTriggerReading, String nextTriggerDate) {
        super();
        this.id = id;
        this.workOrderId = workOrderId;
        this.scheduleDateTime = scheduleDateTime;
        this.currentMeterReading = currentMeterReading;
        this.pastMeterReading = pastMeterReading;
        this.nextTriggerReading = nextTriggerReading;
        this.nextTriggerDate = nextTriggerDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    public String getCurrentMeterReading() {
        return currentMeterReading;
    }

    public void setCurrentMeterReading(String currentMeterReading) {
        this.currentMeterReading = currentMeterReading;
    }

    public String getPastMeterReading() {
        return pastMeterReading;
    }

    public void setPastMeterReading(String pastMeterReading) {
        this.pastMeterReading = pastMeterReading;
    }

    public String getNextTriggerReading() {
        return nextTriggerReading;
    }

    public void setNextTriggerReading(String nextTriggerReading) {
        this.nextTriggerReading = nextTriggerReading;
    }

    public String getNextTriggerDate() {
        return nextTriggerDate;
    }

    public void setNextTriggerDate(String nextTriggerDate) {
        this.nextTriggerDate = nextTriggerDate;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(workOrderId);
        dest.writeValue(scheduleDateTime);
        dest.writeValue(currentMeterReading);
        dest.writeValue(pastMeterReading);
        dest.writeValue(nextTriggerReading);
        dest.writeValue(nextTriggerDate);
    }

    public int describeContents() {
        return 0;
    }*/

}
