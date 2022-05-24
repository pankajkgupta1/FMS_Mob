package com.example.fleatmanagmentsystem.models.login.maintenance;

import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintanenceWorkOrder implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("maintanenceWorkOrderSequenceNumber")
    @Expose
    private Integer maintanenceWorkOrderSequenceNumber;
    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("maintanenceScheduleId")
    @Expose
    private String maintanenceScheduleId;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("scheduleDateTime")
    @Expose
    private String scheduleDateTime;
    @SerializedName("lastScheduleDateTime")
    @Expose
    private Object lastScheduleDateTime;
    @SerializedName("employeeId")
    @Expose
    private String employeeId;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("depotId")
    @Expose
    private Object depotId;
    @SerializedName("depotName")
    @Expose
    private Object depotName;
    @SerializedName("depotAddress")
    @Expose
    private Object depotAddress;
    @SerializedName("workOrderName")
    @Expose
    private String workOrderName;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("workOrderStartDate")
    @Expose
    private String workOrderStartDate;
    @SerializedName("workOrderEndDate")
    @Expose
    private Object workOrderEndDate;
    @SerializedName("requiredCompletionDate")
    @Expose
    private String requiredCompletionDate;
    @SerializedName("workOrderAssignedTo")
    @Expose
    private Object workOrderAssignedTo;
    @SerializedName("workOrderCompletedBy")
    @Expose
    private Object workOrderCompletedBy;
    @SerializedName("summaryOfIssue")
    @Expose
    private Object summaryOfIssue;
    @SerializedName("actualWorkOrderStartDate")
    @Expose
    private String actualWorkOrderStartDate;
    @SerializedName("actualWorkOrderEndDate")
    @Expose
    private String actualWorkOrderEndDate;
    @SerializedName("estimatedLabourHours")
    @Expose
    private Object estimatedLabourHours;
    @SerializedName("workOrderCompletionEstimatedTime")
    @Expose
    private Object workOrderCompletionEstimatedTime;
    @SerializedName("workOrderCompletionEstimatedTimeUom")
    @Expose
    private Object workOrderCompletionEstimatedTimeUom;
    @SerializedName("actualLabourHours")
    @Expose
    private Object actualLabourHours;
    @SerializedName("workInstructions")
    @Expose
    private Object workInstructions;
    @SerializedName("documents")
    @Expose
    private Object documents;
    @SerializedName("servicesInfo")
    @Expose
    private List<ServicesInfo> servicesInfo = null;
    @SerializedName("sparePartsInfo")
    @Expose
    private List<SparePartsInfo> sparePartsInfo = null;
    @SerializedName("purchaseRequisition")
    @Expose
    private List<Object> purchaseRequisition = null;
    @SerializedName("meterReadingInfo")
    @Expose
    private List<MeterReadingInfo> meterReadingInfo = null;
    @SerializedName("workOrderStatus")
    @Expose
    private String workOrderStatus;
    @SerializedName("isWorkOrderCreated")
    @Expose
    private Boolean isWorkOrderCreated;
    @SerializedName("isWorkOrderConfirmed")
    @Expose
    private Object isWorkOrderConfirmed;
    @SerializedName("isGateEntryDone")
    @Expose
    private Boolean isGateEntryDone;
    @SerializedName("areSparePartsIssued")
    @Expose
    private Object areSparePartsIssued;
    @SerializedName("areSparePartsReturned")
    @Expose
    private Object areSparePartsReturned;
    @SerializedName("isWorkOrderClosed")
    @Expose
    private Boolean isWorkOrderClosed;
    @SerializedName("maintanenceCost")
    @Expose
    private Double maintanenceCost;
    public final static Creator<MaintanenceWorkOrder> CREATOR = new Creator<MaintanenceWorkOrder>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintanenceWorkOrder createFromParcel(android.os.Parcel in) {
            return new MaintanenceWorkOrder(in);
        }

        public MaintanenceWorkOrder[] newArray(int size) {
            return (new MaintanenceWorkOrder[size]);
        }

    }
            ;

    protected MaintanenceWorkOrder(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.prefix = ((String) in.readValue((String.class.getClassLoader())));
        this.maintanenceWorkOrderSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.workOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.maintanenceScheduleId = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceType = ((String) in.readValue((String.class.getClassLoader())));
        this.scheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.lastScheduleDateTime = ((Object) in.readValue((Object.class.getClassLoader())));
        this.employeeId = ((String) in.readValue((String.class.getClassLoader())));
        this.employeeName = ((String) in.readValue((String.class.getClassLoader())));
        this.depotId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.depotName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.depotAddress = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workOrderName = ((String) in.readValue((String.class.getClassLoader())));
        this.priority = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderEndDate = ((Object) in.readValue((Object.class.getClassLoader())));
        this.requiredCompletionDate = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderAssignedTo = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workOrderCompletedBy = ((Object) in.readValue((Object.class.getClassLoader())));
        this.summaryOfIssue = ((Object) in.readValue((Object.class.getClassLoader())));
        this.actualWorkOrderStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.actualWorkOrderEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.estimatedLabourHours = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workOrderCompletionEstimatedTime = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workOrderCompletionEstimatedTimeUom = ((Object) in.readValue((Object.class.getClassLoader())));
        this.actualLabourHours = ((Object) in.readValue((Object.class.getClassLoader())));
        this.workInstructions = ((Object) in.readValue((Object.class.getClassLoader())));
        this.documents = ((Object) in.readValue((Object.class.getClassLoader())));
        in.readList(this.servicesInfo, (ServicesInfo.class.getClassLoader()));
        in.readList(this.sparePartsInfo, (SparePartsInfo.class.getClassLoader()));
        in.readList(this.purchaseRequisition, (java.lang.Object.class.getClassLoader()));
        in.readList(this.meterReadingInfo, (MeterReadingInfo.class.getClassLoader()));
        this.workOrderStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.isWorkOrderCreated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isWorkOrderConfirmed = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isGateEntryDone = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.areSparePartsIssued = ((Object) in.readValue((Object.class.getClassLoader())));
        this.areSparePartsReturned = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isWorkOrderClosed = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.maintanenceCost = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MaintanenceWorkOrder() {
    }

    public MaintanenceWorkOrder(String id, String prefix, Integer maintanenceWorkOrderSequenceNumber, String workOrderId, String organizationIdName, String country, String maintanenceScheduleId, String vehicleId, String driverId, String serviceType, String scheduleDateTime, Object lastScheduleDateTime, String employeeId, String employeeName, Object depotId, Object depotName, Object depotAddress, String workOrderName, String priority, String workOrderStartDate, Object workOrderEndDate, String requiredCompletionDate, Object workOrderAssignedTo, Object workOrderCompletedBy, Object summaryOfIssue, String actualWorkOrderStartDate, String actualWorkOrderEndDate, Object estimatedLabourHours, Object workOrderCompletionEstimatedTime, Object workOrderCompletionEstimatedTimeUom, Object actualLabourHours, Object workInstructions, Object documents, List<ServicesInfo> servicesInfo, List<SparePartsInfo> sparePartsInfo, List<Object> purchaseRequisition, List<MeterReadingInfo> meterReadingInfo, String workOrderStatus, Boolean isWorkOrderCreated, Object isWorkOrderConfirmed, Boolean isGateEntryDone, Object areSparePartsIssued, Object areSparePartsReturned, Boolean isWorkOrderClosed, Double maintanenceCost) {
        super();
        this.id = id;
        this.prefix = prefix;
        this.maintanenceWorkOrderSequenceNumber = maintanenceWorkOrderSequenceNumber;
        this.workOrderId = workOrderId;
        this.organizationIdName = organizationIdName;
        this.country = country;
        this.maintanenceScheduleId = maintanenceScheduleId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.serviceType = serviceType;
        this.scheduleDateTime = scheduleDateTime;
        this.lastScheduleDateTime = lastScheduleDateTime;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.depotId = depotId;
        this.depotName = depotName;
        this.depotAddress = depotAddress;
        this.workOrderName = workOrderName;
        this.priority = priority;
        this.workOrderStartDate = workOrderStartDate;
        this.workOrderEndDate = workOrderEndDate;
        this.requiredCompletionDate = requiredCompletionDate;
        this.workOrderAssignedTo = workOrderAssignedTo;
        this.workOrderCompletedBy = workOrderCompletedBy;
        this.summaryOfIssue = summaryOfIssue;
        this.actualWorkOrderStartDate = actualWorkOrderStartDate;
        this.actualWorkOrderEndDate = actualWorkOrderEndDate;
        this.estimatedLabourHours = estimatedLabourHours;
        this.workOrderCompletionEstimatedTime = workOrderCompletionEstimatedTime;
        this.workOrderCompletionEstimatedTimeUom = workOrderCompletionEstimatedTimeUom;
        this.actualLabourHours = actualLabourHours;
        this.workInstructions = workInstructions;
        this.documents = documents;
        this.servicesInfo = servicesInfo;
        this.sparePartsInfo = sparePartsInfo;
        this.purchaseRequisition = purchaseRequisition;
        this.meterReadingInfo = meterReadingInfo;
        this.workOrderStatus = workOrderStatus;
        this.isWorkOrderCreated = isWorkOrderCreated;
        this.isWorkOrderConfirmed = isWorkOrderConfirmed;
        this.isGateEntryDone = isGateEntryDone;
        this.areSparePartsIssued = areSparePartsIssued;
        this.areSparePartsReturned = areSparePartsReturned;
        this.isWorkOrderClosed = isWorkOrderClosed;
        this.maintanenceCost = maintanenceCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getMaintanenceWorkOrderSequenceNumber() {
        return maintanenceWorkOrderSequenceNumber;
    }

    public void setMaintanenceWorkOrderSequenceNumber(Integer maintanenceWorkOrderSequenceNumber) {
        this.maintanenceWorkOrderSequenceNumber = maintanenceWorkOrderSequenceNumber;
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

    public String getMaintanenceScheduleId() {
        return maintanenceScheduleId;
    }

    public void setMaintanenceScheduleId(String maintanenceScheduleId) {
        this.maintanenceScheduleId = maintanenceScheduleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    public Object getLastScheduleDateTime() {
        return lastScheduleDateTime;
    }

    public void setLastScheduleDateTime(Object lastScheduleDateTime) {
        this.lastScheduleDateTime = lastScheduleDateTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Object getDepotId() {
        return depotId;
    }

    public void setDepotId(Object depotId) {
        this.depotId = depotId;
    }

    public Object getDepotName() {
        return depotName;
    }

    public void setDepotName(Object depotName) {
        this.depotName = depotName;
    }

    public Object getDepotAddress() {
        return depotAddress;
    }

    public void setDepotAddress(Object depotAddress) {
        this.depotAddress = depotAddress;
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWorkOrderStartDate() {
        return workOrderStartDate;
    }

    public void setWorkOrderStartDate(String workOrderStartDate) {
        this.workOrderStartDate = workOrderStartDate;
    }

    public Object getWorkOrderEndDate() {
        return workOrderEndDate;
    }

    public void setWorkOrderEndDate(Object workOrderEndDate) {
        this.workOrderEndDate = workOrderEndDate;
    }

    public String getRequiredCompletionDate() {
        return requiredCompletionDate;
    }

    public void setRequiredCompletionDate(String requiredCompletionDate) {
        this.requiredCompletionDate = requiredCompletionDate;
    }

    public Object getWorkOrderAssignedTo() {
        return workOrderAssignedTo;
    }

    public void setWorkOrderAssignedTo(Object workOrderAssignedTo) {
        this.workOrderAssignedTo = workOrderAssignedTo;
    }

    public Object getWorkOrderCompletedBy() {
        return workOrderCompletedBy;
    }

    public void setWorkOrderCompletedBy(Object workOrderCompletedBy) {
        this.workOrderCompletedBy = workOrderCompletedBy;
    }

    public Object getSummaryOfIssue() {
        return summaryOfIssue;
    }

    public void setSummaryOfIssue(Object summaryOfIssue) {
        this.summaryOfIssue = summaryOfIssue;
    }

    public String getActualWorkOrderStartDate() {
        return actualWorkOrderStartDate;
    }

    public void setActualWorkOrderStartDate(String actualWorkOrderStartDate) {
        this.actualWorkOrderStartDate = actualWorkOrderStartDate;
    }

    public String getActualWorkOrderEndDate() {
        return actualWorkOrderEndDate;
    }

    public void setActualWorkOrderEndDate(String actualWorkOrderEndDate) {
        this.actualWorkOrderEndDate = actualWorkOrderEndDate;
    }

    public Object getEstimatedLabourHours() {
        return estimatedLabourHours;
    }

    public void setEstimatedLabourHours(Object estimatedLabourHours) {
        this.estimatedLabourHours = estimatedLabourHours;
    }

    public Object getWorkOrderCompletionEstimatedTime() {
        return workOrderCompletionEstimatedTime;
    }

    public void setWorkOrderCompletionEstimatedTime(Object workOrderCompletionEstimatedTime) {
        this.workOrderCompletionEstimatedTime = workOrderCompletionEstimatedTime;
    }

    public Object getWorkOrderCompletionEstimatedTimeUom() {
        return workOrderCompletionEstimatedTimeUom;
    }

    public void setWorkOrderCompletionEstimatedTimeUom(Object workOrderCompletionEstimatedTimeUom) {
        this.workOrderCompletionEstimatedTimeUom = workOrderCompletionEstimatedTimeUom;
    }

    public Object getActualLabourHours() {
        return actualLabourHours;
    }

    public void setActualLabourHours(Object actualLabourHours) {
        this.actualLabourHours = actualLabourHours;
    }

    public Object getWorkInstructions() {
        return workInstructions;
    }

    public void setWorkInstructions(Object workInstructions) {
        this.workInstructions = workInstructions;
    }

    public Object getDocuments() {
        return documents;
    }

    public void setDocuments(Object documents) {
        this.documents = documents;
    }

    public List<ServicesInfo> getServicesInfo() {
        return servicesInfo;
    }

    public void setServicesInfo(List<ServicesInfo> servicesInfo) {
        this.servicesInfo = servicesInfo;
    }

    public List<SparePartsInfo> getSparePartsInfo() {
        return sparePartsInfo;
    }

    public void setSparePartsInfo(List<SparePartsInfo> sparePartsInfo) {
        this.sparePartsInfo = sparePartsInfo;
    }

    public List<Object> getPurchaseRequisition() {
        return purchaseRequisition;
    }

    public void setPurchaseRequisition(List<Object> purchaseRequisition) {
        this.purchaseRequisition = purchaseRequisition;
    }

    public List<MeterReadingInfo> getMeterReadingInfo() {
        return meterReadingInfo;
    }

    public void setMeterReadingInfo(List<MeterReadingInfo> meterReadingInfo) {
        this.meterReadingInfo = meterReadingInfo;
    }

    public String getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(String workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public Boolean getIsWorkOrderCreated() {
        return isWorkOrderCreated;
    }

    public void setIsWorkOrderCreated(Boolean isWorkOrderCreated) {
        this.isWorkOrderCreated = isWorkOrderCreated;
    }

    public Object getIsWorkOrderConfirmed() {
        return isWorkOrderConfirmed;
    }

    public void setIsWorkOrderConfirmed(Object isWorkOrderConfirmed) {
        this.isWorkOrderConfirmed = isWorkOrderConfirmed;
    }

    public Boolean getIsGateEntryDone() {
        return isGateEntryDone;
    }

    public void setIsGateEntryDone(Boolean isGateEntryDone) {
        this.isGateEntryDone = isGateEntryDone;
    }

    public Object getAreSparePartsIssued() {
        return areSparePartsIssued;
    }

    public void setAreSparePartsIssued(Object areSparePartsIssued) {
        this.areSparePartsIssued = areSparePartsIssued;
    }

    public Object getAreSparePartsReturned() {
        return areSparePartsReturned;
    }

    public void setAreSparePartsReturned(Object areSparePartsReturned) {
        this.areSparePartsReturned = areSparePartsReturned;
    }

    public Boolean getIsWorkOrderClosed() {
        return isWorkOrderClosed;
    }

    public void setIsWorkOrderClosed(Boolean isWorkOrderClosed) {
        this.isWorkOrderClosed = isWorkOrderClosed;
    }

    public Double getMaintanenceCost() {
        return maintanenceCost;
    }

    public void setMaintanenceCost(Double maintanenceCost) {
        this.maintanenceCost = maintanenceCost;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(prefix);
        dest.writeValue(maintanenceWorkOrderSequenceNumber);
        dest.writeValue(workOrderId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(maintanenceScheduleId);
        dest.writeValue(vehicleId);
        dest.writeValue(driverId);
        dest.writeValue(serviceType);
        dest.writeValue(scheduleDateTime);
        dest.writeValue(lastScheduleDateTime);
        dest.writeValue(employeeId);
        dest.writeValue(employeeName);
        dest.writeValue(depotId);
        dest.writeValue(depotName);
        dest.writeValue(depotAddress);
        dest.writeValue(workOrderName);
        dest.writeValue(priority);
        dest.writeValue(workOrderStartDate);
        dest.writeValue(workOrderEndDate);
        dest.writeValue(requiredCompletionDate);
        dest.writeValue(workOrderAssignedTo);
        dest.writeValue(workOrderCompletedBy);
        dest.writeValue(summaryOfIssue);
        dest.writeValue(actualWorkOrderStartDate);
        dest.writeValue(actualWorkOrderEndDate);
        dest.writeValue(estimatedLabourHours);
        dest.writeValue(workOrderCompletionEstimatedTime);
        dest.writeValue(workOrderCompletionEstimatedTimeUom);
        dest.writeValue(actualLabourHours);
        dest.writeValue(workInstructions);
        dest.writeValue(documents);
        dest.writeList(servicesInfo);
        dest.writeList(sparePartsInfo);
        dest.writeList(purchaseRequisition);
        dest.writeList(meterReadingInfo);
        dest.writeValue(workOrderStatus);
        dest.writeValue(isWorkOrderCreated);
        dest.writeValue(isWorkOrderConfirmed);
        dest.writeValue(isGateEntryDone);
        dest.writeValue(areSparePartsIssued);
        dest.writeValue(areSparePartsReturned);
        dest.writeValue(isWorkOrderClosed);
        dest.writeValue(maintanenceCost);
    }

    public int describeContents() {
        return 0;
    }

    /*@SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("maintanenceWorkOrderSequenceNumber")
    @Expose
    private Integer maintanenceWorkOrderSequenceNumber;
    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("maintanenceScheduleId")
    @Expose
    private String maintanenceScheduleId;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("scheduleDateTime")
    @Expose
    private String scheduleDateTime;
    @SerializedName("lastScheduleDateTime")
    @Expose
    private String lastScheduleDateTime;
    @SerializedName("employeeId")
    @Expose
    private String employeeId;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("depotId")
    @Expose
    private String depotId;
    @SerializedName("depotName")
    @Expose
    private String depotName;
    @SerializedName("depotAddress")
    @Expose
    private String depotAddress;
    @SerializedName("workOrderName")
    @Expose
    private String workOrderName;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("workOrderStartDate")
    @Expose
    private String workOrderStartDate;
    @SerializedName("workOrderEndDate")
    @Expose
    private String workOrderEndDate;
    @SerializedName("requiredCompletionDate")
    @Expose
    private String requiredCompletionDate;
    @SerializedName("workOrderAssignedTo")
    @Expose
    private String workOrderAssignedTo;
    @SerializedName("workOrderCompletedBy")
    @Expose
    private String workOrderCompletedBy;
    @SerializedName("summaryOfIssue")
    @Expose
    private String summaryOfIssue;
    @SerializedName("actualWorkOrderStartDate")
    @Expose
    private String actualWorkOrderStartDate;
    @SerializedName("actualWorkOrderEndDate")
    @Expose
    private String actualWorkOrderEndDate;
    @SerializedName("estimatedLabourHours")
    @Expose
    private String estimatedLabourHours;
    @SerializedName("workOrderCompletionEstimatedTime")
    @Expose
    private String workOrderCompletionEstimatedTime;
    @SerializedName("workOrderCompletionEstimatedTimeUom")
    @Expose
    private String workOrderCompletionEstimatedTimeUom;
    @SerializedName("actualLabourHours")
    @Expose
    private String actualLabourHours;
    @SerializedName("workInstructions")
    @Expose
    private String workInstructions;
    @SerializedName("documents")
    @Expose
    private String documents;
    @SerializedName("servicesInfo")
    @Expose
    private List<ServicesInfo> servicesInfo = null;
    @SerializedName("sparePartsInfo")
    @Expose
    private String sparePartsInfo;
    @SerializedName("purchaseRequisition")
    @Expose
    private String purchaseRequisition;
    @SerializedName("meterReadingInfo")
    @Expose
    private List<MeterReadingInfo> meterReadingInfo = null;
    @SerializedName("workOrderStatus")
    @Expose
    private String workOrderStatus;
    @SerializedName("isWorkOrderCreated")
    @Expose
    private Boolean isWorkOrderCreated;
    @SerializedName("isWorkOrderConfirmed")
    @Expose
    private String isWorkOrderConfirmed;
    @SerializedName("isGateEntryDone")
    @Expose
    private Boolean isGateEntryDone;
    @SerializedName("areSparePartsIssued")
    @Expose
    private String areSparePartsIssued;
    @SerializedName("areSparePartsReturned")
    @Expose
    private String areSparePartsReturned;
    @SerializedName("isWorkOrderClosed")
    @Expose
    private String isWorkOrderClosed;
    @SerializedName("maintanenceCost")
    @Expose
    private String maintanenceCost;
    public final static Creator<MaintanenceWorkOrder> CREATOR = new Creator<MaintanenceWorkOrder>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MaintanenceWorkOrder createFromParcel(android.os.Parcel in) {
            return new MaintanenceWorkOrder(in);
        }

        public MaintanenceWorkOrder[] newArray(int size) {
            return (new MaintanenceWorkOrder[size]);
        }

    }
            ;

    protected MaintanenceWorkOrder(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.prefix = ((String) in.readValue((String.class.getClassLoader())));
        this.maintanenceWorkOrderSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.workOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.maintanenceScheduleId = ((String) in.readValue((String.class.getClassLoader())));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceType = ((String) in.readValue((String.class.getClassLoader())));
        this.scheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.lastScheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.employeeId = ((String) in.readValue((String.class.getClassLoader())));
        this.employeeName = ((String) in.readValue((String.class.getClassLoader())));
        this.depotId = ((String) in.readValue((String.class.getClassLoader())));
        this.depotName = ((String) in.readValue((String.class.getClassLoader())));
        this.depotAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderName = ((String) in.readValue((String.class.getClassLoader())));
        this.priority = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.requiredCompletionDate = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderAssignedTo = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderCompletedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.summaryOfIssue = ((String) in.readValue((String.class.getClassLoader())));
        this.actualWorkOrderStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.actualWorkOrderEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.estimatedLabourHours = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderCompletionEstimatedTime = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderCompletionEstimatedTimeUom = ((String) in.readValue((String.class.getClassLoader())));
        this.actualLabourHours = ((String) in.readValue((String.class.getClassLoader())));
        this.workInstructions = ((String) in.readValue((String.class.getClassLoader())));
        this.documents = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.servicesInfo, (ServicesInfo.class.getClassLoader()));
        this.sparePartsInfo = ((String) in.readValue((String.class.getClassLoader())));
        this.purchaseRequisition = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.meterReadingInfo, (MeterReadingInfo.class.getClassLoader()));
        this.workOrderStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.isWorkOrderCreated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isWorkOrderConfirmed = ((String) in.readValue((String.class.getClassLoader())));
        this.isGateEntryDone = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.areSparePartsIssued = ((String) in.readValue((String.class.getClassLoader())));
        this.areSparePartsReturned = ((String) in.readValue((String.class.getClassLoader())));
        this.isWorkOrderClosed = ((String) in.readValue((String.class.getClassLoader())));
        this.maintanenceCost = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MaintanenceWorkOrder() {
    }

    public MaintanenceWorkOrder(String id, String prefix, Integer maintanenceWorkOrderSequenceNumber, String workOrderId, String organizationIdName, String country, String maintanenceScheduleId, String vehicleId, String driverId, String serviceType, String scheduleDateTime, String lastScheduleDateTime, String employeeId, String employeeName, String depotId, String depotName, String depotAddress, String workOrderName, String priority, String workOrderStartDate, String workOrderEndDate, String requiredCompletionDate, String workOrderAssignedTo, String workOrderCompletedBy, String summaryOfIssue, String actualWorkOrderStartDate, String actualWorkOrderEndDate, String estimatedLabourHours, String workOrderCompletionEstimatedTime, String workOrderCompletionEstimatedTimeUom, String actualLabourHours, String workInstructions, String documents, List<ServicesInfo> servicesInfo, String sparePartsInfo, String purchaseRequisition, List<MeterReadingInfo> meterReadingInfo, String workOrderStatus, Boolean isWorkOrderCreated, String isWorkOrderConfirmed, Boolean isGateEntryDone, String areSparePartsIssued, String areSparePartsReturned, String isWorkOrderClosed, String maintanenceCost) {
        super();
        this.id = id;
        this.prefix = prefix;
        this.maintanenceWorkOrderSequenceNumber = maintanenceWorkOrderSequenceNumber;
        this.workOrderId = workOrderId;
        this.organizationIdName = organizationIdName;
        this.country = country;
        this.maintanenceScheduleId = maintanenceScheduleId;
        this.vehicleId = vehicleId;
        this.driverId = driverId;
        this.serviceType = serviceType;
        this.scheduleDateTime = scheduleDateTime;
        this.lastScheduleDateTime = lastScheduleDateTime;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.depotId = depotId;
        this.depotName = depotName;
        this.depotAddress = depotAddress;
        this.workOrderName = workOrderName;
        this.priority = priority;
        this.workOrderStartDate = workOrderStartDate;
        this.workOrderEndDate = workOrderEndDate;
        this.requiredCompletionDate = requiredCompletionDate;
        this.workOrderAssignedTo = workOrderAssignedTo;
        this.workOrderCompletedBy = workOrderCompletedBy;
        this.summaryOfIssue = summaryOfIssue;
        this.actualWorkOrderStartDate = actualWorkOrderStartDate;
        this.actualWorkOrderEndDate = actualWorkOrderEndDate;
        this.estimatedLabourHours = estimatedLabourHours;
        this.workOrderCompletionEstimatedTime = workOrderCompletionEstimatedTime;
        this.workOrderCompletionEstimatedTimeUom = workOrderCompletionEstimatedTimeUom;
        this.actualLabourHours = actualLabourHours;
        this.workInstructions = workInstructions;
        this.documents = documents;
        this.servicesInfo = servicesInfo;
        this.sparePartsInfo = sparePartsInfo;
        this.purchaseRequisition = purchaseRequisition;
        this.meterReadingInfo = meterReadingInfo;
        this.workOrderStatus = workOrderStatus;
        this.isWorkOrderCreated = isWorkOrderCreated;
        this.isWorkOrderConfirmed = isWorkOrderConfirmed;
        this.isGateEntryDone = isGateEntryDone;
        this.areSparePartsIssued = areSparePartsIssued;
        this.areSparePartsReturned = areSparePartsReturned;
        this.isWorkOrderClosed = isWorkOrderClosed;
        this.maintanenceCost = maintanenceCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getMaintanenceWorkOrderSequenceNumber() {
        return maintanenceWorkOrderSequenceNumber;
    }

    public void setMaintanenceWorkOrderSequenceNumber(Integer maintanenceWorkOrderSequenceNumber) {
        this.maintanenceWorkOrderSequenceNumber = maintanenceWorkOrderSequenceNumber;
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

    public String getMaintanenceScheduleId() {
        return maintanenceScheduleId;
    }

    public void setMaintanenceScheduleId(String maintanenceScheduleId) {
        this.maintanenceScheduleId = maintanenceScheduleId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    public String getLastScheduleDateTime() {
        return lastScheduleDateTime;
    }

    public void setLastScheduleDateTime(String lastScheduleDateTime) {
        this.lastScheduleDateTime = lastScheduleDateTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepotId() {
        return depotId;
    }

    public void setDepotId(String depotId) {
        this.depotId = depotId;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotAddress() {
        return depotAddress;
    }

    public void setDepotAddress(String depotAddress) {
        this.depotAddress = depotAddress;
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWorkOrderStartDate() {
        return workOrderStartDate;
    }

    public void setWorkOrderStartDate(String workOrderStartDate) {
        this.workOrderStartDate = workOrderStartDate;
    }

    public String getWorkOrderEndDate() {
        return workOrderEndDate;
    }

    public void setWorkOrderEndDate(String workOrderEndDate) {
        this.workOrderEndDate = workOrderEndDate;
    }

    public String getRequiredCompletionDate() {
        return requiredCompletionDate;
    }

    public void setRequiredCompletionDate(String requiredCompletionDate) {
        this.requiredCompletionDate = requiredCompletionDate;
    }

    public String getWorkOrderAssignedTo() {
        return workOrderAssignedTo;
    }

    public void setWorkOrderAssignedTo(String workOrderAssignedTo) {
        this.workOrderAssignedTo = workOrderAssignedTo;
    }

    public String getWorkOrderCompletedBy() {
        return workOrderCompletedBy;
    }

    public void setWorkOrderCompletedBy(String workOrderCompletedBy) {
        this.workOrderCompletedBy = workOrderCompletedBy;
    }

    public String getSummaryOfIssue() {
        return summaryOfIssue;
    }

    public void setSummaryOfIssue(String summaryOfIssue) {
        this.summaryOfIssue = summaryOfIssue;
    }

    public String getActualWorkOrderStartDate() {
        return actualWorkOrderStartDate;
    }

    public void setActualWorkOrderStartDate(String actualWorkOrderStartDate) {
        this.actualWorkOrderStartDate = actualWorkOrderStartDate;
    }

    public String getActualWorkOrderEndDate() {
        return actualWorkOrderEndDate;
    }

    public void setActualWorkOrderEndDate(String actualWorkOrderEndDate) {
        this.actualWorkOrderEndDate = actualWorkOrderEndDate;
    }

    public String getEstimatedLabourHours() {
        return estimatedLabourHours;
    }

    public void setEstimatedLabourHours(String estimatedLabourHours) {
        this.estimatedLabourHours = estimatedLabourHours;
    }

    public String getWorkOrderCompletionEstimatedTime() {
        return workOrderCompletionEstimatedTime;
    }

    public void setWorkOrderCompletionEstimatedTime(String workOrderCompletionEstimatedTime) {
        this.workOrderCompletionEstimatedTime = workOrderCompletionEstimatedTime;
    }

    public String getWorkOrderCompletionEstimatedTimeUom() {
        return workOrderCompletionEstimatedTimeUom;
    }

    public void setWorkOrderCompletionEstimatedTimeUom(String workOrderCompletionEstimatedTimeUom) {
        this.workOrderCompletionEstimatedTimeUom = workOrderCompletionEstimatedTimeUom;
    }

    public String getActualLabourHours() {
        return actualLabourHours;
    }

    public void setActualLabourHours(String actualLabourHours) {
        this.actualLabourHours = actualLabourHours;
    }

    public String getWorkInstructions() {
        return workInstructions;
    }

    public void setWorkInstructions(String workInstructions) {
        this.workInstructions = workInstructions;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public List<ServicesInfo> getServicesInfo() {
        return servicesInfo;
    }

    public void setServicesInfo(List<ServicesInfo> servicesInfo) {
        this.servicesInfo = servicesInfo;
    }

    public String getSparePartsInfo() {
        return sparePartsInfo;
    }

    public void setSparePartsInfo(String sparePartsInfo) {
        this.sparePartsInfo = sparePartsInfo;
    }

    public String getPurchaseRequisition() {
        return purchaseRequisition;
    }

    public void setPurchaseRequisition(String purchaseRequisition) {
        this.purchaseRequisition = purchaseRequisition;
    }

    public List<MeterReadingInfo> getMeterReadingInfo() {
        return meterReadingInfo;
    }

    public void setMeterReadingInfo(List<MeterReadingInfo> meterReadingInfo) {
        this.meterReadingInfo = meterReadingInfo;
    }

    public String getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(String workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public Boolean getIsWorkOrderCreated() {
        return isWorkOrderCreated;
    }

    public void setIsWorkOrderCreated(Boolean isWorkOrderCreated) {
        this.isWorkOrderCreated = isWorkOrderCreated;
    }

    public String getIsWorkOrderConfirmed() {
        return isWorkOrderConfirmed;
    }

    public void setIsWorkOrderConfirmed(String isWorkOrderConfirmed) {
        this.isWorkOrderConfirmed = isWorkOrderConfirmed;
    }

    public Boolean getIsGateEntryDone() {
        return isGateEntryDone;
    }

    public void setIsGateEntryDone(Boolean isGateEntryDone) {
        this.isGateEntryDone = isGateEntryDone;
    }

    public String getAreSparePartsIssued() {
        return areSparePartsIssued;
    }

    public void setAreSparePartsIssued(String areSparePartsIssued) {
        this.areSparePartsIssued = areSparePartsIssued;
    }

    public String getAreSparePartsReturned() {
        return areSparePartsReturned;
    }

    public void setAreSparePartsReturned(String areSparePartsReturned) {
        this.areSparePartsReturned = areSparePartsReturned;
    }

    public String getIsWorkOrderClosed() {
        return isWorkOrderClosed;
    }

    public void setIsWorkOrderClosed(String isWorkOrderClosed) {
        this.isWorkOrderClosed = isWorkOrderClosed;
    }

    public String getMaintanenceCost() {
        return maintanenceCost;
    }

    public void setMaintanenceCost(String maintanenceCost) {
        this.maintanenceCost = maintanenceCost;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(prefix);
        dest.writeValue(maintanenceWorkOrderSequenceNumber);
        dest.writeValue(workOrderId);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
        dest.writeValue(maintanenceScheduleId);
        dest.writeValue(vehicleId);
        dest.writeValue(driverId);
        dest.writeValue(serviceType);
        dest.writeValue(scheduleDateTime);
        dest.writeValue(lastScheduleDateTime);
        dest.writeValue(employeeId);
        dest.writeValue(employeeName);
        dest.writeValue(depotId);
        dest.writeValue(depotName);
        dest.writeValue(depotAddress);
        dest.writeValue(workOrderName);
        dest.writeValue(priority);
        dest.writeValue(workOrderStartDate);
        dest.writeValue(workOrderEndDate);
        dest.writeValue(requiredCompletionDate);
        dest.writeValue(workOrderAssignedTo);
        dest.writeValue(workOrderCompletedBy);
        dest.writeValue(summaryOfIssue);
        dest.writeValue(actualWorkOrderStartDate);
        dest.writeValue(actualWorkOrderEndDate);
        dest.writeValue(estimatedLabourHours);
        dest.writeValue(workOrderCompletionEstimatedTime);
        dest.writeValue(workOrderCompletionEstimatedTimeUom);
        dest.writeValue(actualLabourHours);
        dest.writeValue(workInstructions);
        dest.writeValue(documents);
        dest.writeList(servicesInfo);
        dest.writeValue(sparePartsInfo);
        dest.writeValue(purchaseRequisition);
        dest.writeList(meterReadingInfo);
        dest.writeValue(workOrderStatus);
        dest.writeValue(isWorkOrderCreated);
        dest.writeValue(isWorkOrderConfirmed);
        dest.writeValue(isGateEntryDone);
        dest.writeValue(areSparePartsIssued);
        dest.writeValue(areSparePartsReturned);
        dest.writeValue(isWorkOrderClosed);
        dest.writeValue(maintanenceCost);
    }

    public int describeContents() {
        return 0;
    }*/

}
