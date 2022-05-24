package com.example.fleatmanagmentsystem.models.login.shipmentexecutionupdate;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShipmentDetail implements Parcelable
{

    @SerializedName("stops")
    @Expose
    private Integer stops;
    @SerializedName("loadSequenceHelper")
    @Expose
    private LoadSequenceHelper loadSequenceHelper;
    @SerializedName("typeOfOperation")
    @Expose
    private String typeOfOperation;
    @SerializedName("currentDateAndTime")
    @Expose
    private String currentDateAndTime;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("equipmentId")
    @Expose
    private String equipmentId;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("cleanerId")
    @Expose
    private String cleanerId;
    @SerializedName("sourceLocation")
    @Expose
    private String sourceLocation;
    @SerializedName("destinationLocation")
    @Expose
    private String destinationLocation;
    @SerializedName("timeOfPlacementAtGate")
    @Expose
    private String timeOfPlacementAtGate;
    @SerializedName("placedTimeForLoading")
    @Expose
    private String placedTimeForLoading;
    @SerializedName("loadingStartedTime")
    @Expose
    private String loadingStartedTime;
    @SerializedName("loadingEndedTime")
    @Expose
    private String loadingEndedTime;
    @SerializedName("documentsReceivedTime")
    @Expose
    private String documentsReceivedTime;
    @SerializedName("timeOfGateOut")
    @Expose
    private String timeOfGateOut;
    @SerializedName("podReceivedTime")
    @Expose
    private String podReceivedTime;
    @SerializedName("timeAtUnloadingDock")
    @Expose
    private String timeAtUnloadingDock;
    @SerializedName("unloadingTimeOfGateOut")
    @Expose
    private String unloadingTimeOfGateOut;
    @SerializedName("unloadingStartedTime")
    @Expose
    private String unloadingStartedTime;
    @SerializedName("unloadingEndedTime")
    @Expose
    private String unloadingEndedTime;
    @SerializedName("kmsOfGateOutFromLoading")
    @Expose
    private Integer kmsOfGateOutFromLoading;
    @SerializedName("kmsAtThePointOfUnloading")
    @Expose
    private Double kmsAtThePointOfUnloading;
    @SerializedName("kmsOfGateOutFromUnloading")
    @Expose
    private Double kmsOfGateOutFromUnloading;
    @SerializedName("timeOfSettlement")
    @Expose
    private String timeOfSettlement;
    @SerializedName("tripStatus")
    @Expose
    private String tripStatus;
    @SerializedName("shipmentDetailsDocumentsInfo")
    @Expose
    private List<ShipmentDetailsDocumentsInfo> shipmentDetailsDocumentsInfo = null;
    public final static Creator<ShipmentDetail> CREATOR = new Creator<ShipmentDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ShipmentDetail createFromParcel(android.os.Parcel in) {
            return new ShipmentDetail(in);
        }

        public ShipmentDetail[] newArray(int size) {
            return (new ShipmentDetail[size]);
        }

    }
            ;

    protected ShipmentDetail(android.os.Parcel in) {
        this.stops = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.loadSequenceHelper = ((LoadSequenceHelper) in.readValue((LoadSequenceHelper.class.getClassLoader())));
        this.typeOfOperation = ((String) in.readValue((String.class.getClassLoader())));
        this.currentDateAndTime = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.equipmentId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.cleanerId = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.destinationLocation = ((String) in.readValue((String.class.getClassLoader())));
        this.timeOfPlacementAtGate = ((String) in.readValue((String.class.getClassLoader())));
        this.placedTimeForLoading = ((String) in.readValue((String.class.getClassLoader())));
        this.loadingStartedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.loadingEndedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.documentsReceivedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.timeOfGateOut = ((String) in.readValue((String.class.getClassLoader())));
        this.podReceivedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.timeAtUnloadingDock = ((String) in.readValue((String.class.getClassLoader())));
        this.unloadingTimeOfGateOut = ((String) in.readValue((String.class.getClassLoader())));
        this.unloadingStartedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.unloadingEndedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.kmsOfGateOutFromLoading = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.kmsAtThePointOfUnloading = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.kmsOfGateOutFromUnloading = ((Double) in.readValue((Integer.class.getClassLoader())));
        this.timeOfSettlement = ((String) in.readValue((String.class.getClassLoader())));
        this.tripStatus = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.shipmentDetailsDocumentsInfo, (ShipmentDetailsDocumentsInfo.class.getClassLoader()));
    }

    public ShipmentDetail() {
    }

    public Integer getStops() {
        return stops;
    }

    public void setStops(Integer stops) {
        this.stops = stops;
    }

    public LoadSequenceHelper getLoadSequenceHelper() {
        return loadSequenceHelper;
    }

    public void setLoadSequenceHelper(LoadSequenceHelper loadSequenceHelper) {
        this.loadSequenceHelper = loadSequenceHelper;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(String currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public void setCleanerId(String cleanerId) {
        this.cleanerId = cleanerId;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getTimeOfPlacementAtGate() {
        return timeOfPlacementAtGate;
    }

    public void setTimeOfPlacementAtGate(String timeOfPlacementAtGate) {
        this.timeOfPlacementAtGate = timeOfPlacementAtGate;
    }

    public String getPlacedTimeForLoading() {
        return placedTimeForLoading;
    }

    public void setPlacedTimeForLoading(String placedTimeForLoading) {
        this.placedTimeForLoading = placedTimeForLoading;
    }

    public String getLoadingStartedTime() {
        return loadingStartedTime;
    }

    public void setLoadingStartedTime(String loadingStartedTime) {
        this.loadingStartedTime = loadingStartedTime;
    }

    public String getLoadingEndedTime() {
        return loadingEndedTime;
    }

    public void setLoadingEndedTime(String loadingEndedTime) {
        this.loadingEndedTime = loadingEndedTime;
    }

    public String getDocumentsReceivedTime() {
        return documentsReceivedTime;
    }

    public void setDocumentsReceivedTime(String documentsReceivedTime) {
        this.documentsReceivedTime = documentsReceivedTime;
    }

    public String getTimeOfGateOut() {
        return timeOfGateOut;
    }

    public void setTimeOfGateOut(String timeOfGateOut) {
        this.timeOfGateOut = timeOfGateOut;
    }

    public String getPodReceivedTime() {
        return podReceivedTime;
    }

    public void setPodReceivedTime(String podReceivedTime) {
        this.podReceivedTime = podReceivedTime;
    }

    public String getTimeAtUnloadingDock() {
        return timeAtUnloadingDock;
    }

    public void setTimeAtUnloadingDock(String timeAtUnloadingDock) {
        this.timeAtUnloadingDock = timeAtUnloadingDock;
    }

    public String getUnloadingTimeOfGateOut() {
        return unloadingTimeOfGateOut;
    }

    public void setUnloadingTimeOfGateOut(String unloadingTimeOfGateOut) {
        this.unloadingTimeOfGateOut = unloadingTimeOfGateOut;
    }

    public String getUnloadingStartedTime() {
        return unloadingStartedTime;
    }

    public void setUnloadingStartedTime(String unloadingStartedTime) {
        this.unloadingStartedTime = unloadingStartedTime;
    }

    public String getUnloadingEndedTime() {
        return unloadingEndedTime;
    }

    public void setUnloadingEndedTime(String unloadingEndedTime) {
        this.unloadingEndedTime = unloadingEndedTime;
    }

    public Integer getKmsOfGateOutFromLoading() {
        return kmsOfGateOutFromLoading;
    }

    public void setKmsOfGateOutFromLoading(Integer kmsOfGateOutFromLoading) {
        this.kmsOfGateOutFromLoading = kmsOfGateOutFromLoading;
    }

    public Double getKmsAtThePointOfUnloading() {
        return kmsAtThePointOfUnloading;
    }

    public void setKmsAtThePointOfUnloading(Double kmsAtThePointOfUnloading) {
        this.kmsAtThePointOfUnloading = kmsAtThePointOfUnloading;
    }

    public Double getKmsOfGateOutFromUnloading() {
        return kmsOfGateOutFromUnloading;
    }

    public void setKmsOfGateOutFromUnloading(Double kmsOfGateOutFromUnloading) {
        this.kmsOfGateOutFromUnloading = kmsOfGateOutFromUnloading;
    }

    public String getTimeOfSettlement() {
        return timeOfSettlement;
    }

    public void setTimeOfSettlement(String timeOfSettlement) {
        this.timeOfSettlement = timeOfSettlement;
    }

    public String getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }

    public List<ShipmentDetailsDocumentsInfo> getShipmentDetailsDocumentsInfo() {
        return shipmentDetailsDocumentsInfo;
    }

    public void setShipmentDetailsDocumentsInfo(List<ShipmentDetailsDocumentsInfo> shipmentDetailsDocumentsInfo) {
        this.shipmentDetailsDocumentsInfo = shipmentDetailsDocumentsInfo;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(stops);
        dest.writeValue(loadSequenceHelper);
        dest.writeValue(typeOfOperation);
        dest.writeValue(currentDateAndTime);
        dest.writeValue(vehicleId);
        dest.writeValue(equipmentId);
        dest.writeValue(driverId);
        dest.writeValue(cleanerId);
        dest.writeValue(sourceLocation);
        dest.writeValue(destinationLocation);
        dest.writeValue(timeOfPlacementAtGate);
        dest.writeValue(placedTimeForLoading);
        dest.writeValue(loadingStartedTime);
        dest.writeValue(loadingEndedTime);
        dest.writeValue(documentsReceivedTime);
        dest.writeValue(timeOfGateOut);
        dest.writeValue(podReceivedTime);
        dest.writeValue(timeAtUnloadingDock);
        dest.writeValue(unloadingTimeOfGateOut);
        dest.writeValue(unloadingStartedTime);
        dest.writeValue(unloadingEndedTime);
        dest.writeValue(kmsOfGateOutFromLoading);
        dest.writeValue(kmsAtThePointOfUnloading);
        dest.writeValue(kmsOfGateOutFromUnloading);
        dest.writeValue(timeOfSettlement);
        dest.writeValue(tripStatus);
        dest.writeList(shipmentDetailsDocumentsInfo);
    }

    public int describeContents() {
        return 0;
    }

}
