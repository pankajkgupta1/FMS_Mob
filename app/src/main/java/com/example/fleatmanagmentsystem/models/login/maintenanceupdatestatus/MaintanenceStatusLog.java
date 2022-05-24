package com.example.fleatmanagmentsystem.models.login.maintenanceupdatestatus;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintanenceStatusLog implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("gateEntryDateTime")
    @Expose
    private String gateEntryDateTime;
    @SerializedName("vehiclePlacedDateTime")
    @Expose
    private String vehiclePlacedDateTime;
    @SerializedName("testDriveDateTime")
    @Expose
    private String testDriveDateTime;
    @SerializedName("testDriveBy")
    @Expose
    private String testDriveBy;
    @SerializedName("testDriveStatus")
    @Expose
    private String testDriveStatus;
    @SerializedName("gateOutDateTime")
    @Expose
    private String gateOutDateTime;
    @SerializedName("sparePartsIssueDateTime")
    @Expose
    private String sparePartsIssueDateTime;
    @SerializedName("sparePartsReturnDateTime")
    @Expose
    private String sparePartsReturnDateTime;
    @SerializedName("takeover")
    @Expose
    private Takeover takeover;
    @SerializedName("handover")
    @Expose
    private Handover handover;
    public final static Creator<MaintanenceStatusLog> CREATOR = new Creator<MaintanenceStatusLog>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintanenceStatusLog createFromParcel(android.os.Parcel in) {
            return new MaintanenceStatusLog(in);
        }

        public MaintanenceStatusLog[] newArray(int size) {
            return (new MaintanenceStatusLog[size]);
        }

    }
            ;

    protected MaintanenceStatusLog(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.gateEntryDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.vehiclePlacedDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.testDriveDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.testDriveBy = ((String) in.readValue((String.class.getClassLoader())));
        this.testDriveStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.gateOutDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.sparePartsIssueDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.sparePartsReturnDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.takeover = ((Takeover) in.readValue((Takeover.class.getClassLoader())));
        this.handover = ((Handover) in.readValue((Handover.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintanenceStatusLog() {
    }

    /**
     *
     * @param testDriveBy
     * @param sparePartsIssueDateTime
     * @param country
     * @param handover
     * @param takeover
     * @param testDriveDateTime
     * @param organizationIdName
     * @param vehiclePlacedDateTime
     * @param gateEntryDateTime
     * @param testDriveStatus
     * @param sparePartsReturnDateTime
     * @param id
     * @param workOrderId
     * @param vehicleId
     * @param gateOutDateTime
     */
    public MaintanenceStatusLog(String id, String workOrderId, String organizationIdName, String country, String vehicleId, String gateEntryDateTime, String vehiclePlacedDateTime, String testDriveDateTime, String testDriveBy, String testDriveStatus, String gateOutDateTime, String sparePartsIssueDateTime, String sparePartsReturnDateTime, Takeover takeover, Handover handover) {
        super();
        this.id = id;
        this.workOrderId = workOrderId;
        this.organizationIdName = organizationIdName;
        this.country = country;
        this.vehicleId = vehicleId;
        this.gateEntryDateTime = gateEntryDateTime;
        this.vehiclePlacedDateTime = vehiclePlacedDateTime;
        this.testDriveDateTime = testDriveDateTime;
        this.testDriveBy = testDriveBy;
        this.testDriveStatus = testDriveStatus;
        this.gateOutDateTime = gateOutDateTime;
        this.sparePartsIssueDateTime = sparePartsIssueDateTime;
        this.sparePartsReturnDateTime = sparePartsReturnDateTime;
        this.takeover = takeover;
        this.handover = handover;
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

    public String getOrganizationIdName() {
        return organizationIdName;
    }

    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getGateEntryDateTime() {
        return gateEntryDateTime;
    }

    public void setGateEntryDateTime(String gateEntryDateTime) {
        this.gateEntryDateTime = gateEntryDateTime;
    }

    public String getVehiclePlacedDateTime() {
        return vehiclePlacedDateTime;
    }

    public void setVehiclePlacedDateTime(String vehiclePlacedDateTime) {
        this.vehiclePlacedDateTime = vehiclePlacedDateTime;
    }

    public String getTestDriveDateTime() {
        return testDriveDateTime;
    }

    public void setTestDriveDateTime(String testDriveDateTime) {
        this.testDriveDateTime = testDriveDateTime;
    }

    public String getTestDriveBy() {
        return testDriveBy;
    }

    public void setTestDriveBy(String testDriveBy) {
        this.testDriveBy = testDriveBy;
    }

    public String getTestDriveStatus() {
        return testDriveStatus;
    }

    public void setTestDriveStatus(String testDriveStatus) {
        this.testDriveStatus = testDriveStatus;
    }

    public String getGateOutDateTime() {
        return gateOutDateTime;
    }

    public void setGateOutDateTime(String gateOutDateTime) {
        this.gateOutDateTime = gateOutDateTime;
    }

    public String getSparePartsIssueDateTime() {
        return sparePartsIssueDateTime;
    }

    public void setSparePartsIssueDateTime(String sparePartsIssueDateTime) {
        this.sparePartsIssueDateTime = sparePartsIssueDateTime;
    }

    public String getSparePartsReturnDateTime() {
        return sparePartsReturnDateTime;
    }

    public void setSparePartsReturnDateTime(String sparePartsReturnDateTime) {
        this.sparePartsReturnDateTime = sparePartsReturnDateTime;
    }

    public Takeover getTakeover() {
        return takeover;
    }

    public void setTakeover(Takeover takeover) {
        this.takeover = takeover;
    }

    public Handover getHandover() {
        return handover;
    }

    public void setHandover(Handover handover) {
        this.handover = handover;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(workOrderId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(vehicleId);
        dest.writeValue(gateEntryDateTime);
        dest.writeValue(vehiclePlacedDateTime);
        dest.writeValue(testDriveDateTime);
        dest.writeValue(testDriveBy);
        dest.writeValue(testDriveStatus);
        dest.writeValue(gateOutDateTime);
        dest.writeValue(sparePartsIssueDateTime);
        dest.writeValue(sparePartsReturnDateTime);
        dest.writeValue(takeover);
        dest.writeValue(handover);
    }

    public int describeContents() {
        return 0;
    }

}
