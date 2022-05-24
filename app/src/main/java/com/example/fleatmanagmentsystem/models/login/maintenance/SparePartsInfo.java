package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SparePartsInfo implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private Object id;
    @SerializedName("maintanenceScheduleId")
    @Expose
    private String maintanenceScheduleId;
    @SerializedName("workOrderId")
    @Expose
    private String workOrderId;
    @SerializedName("serviceId")
    @Expose
    private Object serviceId;
    @SerializedName("itemCode")
    @Expose
    private ItemCode itemCode;
    @SerializedName("wareHouseInfo")
    @Expose
    private WareHouseInfo wareHouseInfo;
    @SerializedName("availableQuantity")
    @Expose
    private Double availableQuantity;
    @SerializedName("requestedQuantity")
    @Expose
    private Object requestedQuantity;
    @SerializedName("issueQuantity")
    @Expose
    private Object issueQuantity;
    @SerializedName("outstandingQuantity")
    @Expose
    private Double outstandingQuantity;
    @SerializedName("consumedQuantity")
    @Expose
    private Object consumedQuantity;
    @SerializedName("returnedQuantity")
    @Expose
    private Object returnedQuantity;
    @SerializedName("issuedStatus")
    @Expose
    private Object issuedStatus;
    @SerializedName("standardCostPrice")
    @Expose
    private Object standardCostPrice;
    @SerializedName("isSparePartsSettled")
    @Expose
    private String isSparePartsSettled;
    @SerializedName("isOriginalItemCode")
    @Expose
    private Object isOriginalItemCode;
    public final static Creator<SparePartsInfo> CREATOR = new Creator<SparePartsInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SparePartsInfo createFromParcel(android.os.Parcel in) {
            return new SparePartsInfo(in);
        }

        public SparePartsInfo[] newArray(int size) {
            return (new SparePartsInfo[size]);
        }

    }
            ;

    protected SparePartsInfo(android.os.Parcel in) {
        this.id = ((Object) in.readValue((Object.class.getClassLoader())));
        this.maintanenceScheduleId = ((String) in.readValue((String.class.getClassLoader())));
        this.workOrderId = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.itemCode = ((ItemCode) in.readValue((ItemCode.class.getClassLoader())));
        this.wareHouseInfo = ((WareHouseInfo) in.readValue((WareHouseInfo.class.getClassLoader())));
        this.availableQuantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.requestedQuantity = ((Object) in.readValue((Object.class.getClassLoader())));
        this.issueQuantity = ((Object) in.readValue((Object.class.getClassLoader())));
        this.outstandingQuantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.consumedQuantity = ((Object) in.readValue((Object.class.getClassLoader())));
        this.returnedQuantity = ((Object) in.readValue((Object.class.getClassLoader())));
        this.issuedStatus = ((Object) in.readValue((Object.class.getClassLoader())));
        this.standardCostPrice = ((Object) in.readValue((Object.class.getClassLoader())));
        this.isSparePartsSettled = ((String) in.readValue((String.class.getClassLoader())));
        this.isOriginalItemCode = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SparePartsInfo() {
    }

    /**
     *
     * @param availableQuantity
     * @param wareHouseInfo
     * @param returnedQuantity
     * @param maintanenceScheduleId
     * @param itemCode
     * @param issuedStatus
     * @param isSparePartsSettled
     * @param consumedQuantity
     * @param isOriginalItemCode
     * @param requestedQuantity
     * @param id
     * @param workOrderId
     * @param standardCostPrice
     * @param serviceId
     * @param issueQuantity
     * @param outstandingQuantity
     */
    public SparePartsInfo(Object id, String maintanenceScheduleId, String workOrderId, Object serviceId, ItemCode itemCode, WareHouseInfo wareHouseInfo, Double availableQuantity, Object requestedQuantity, Object issueQuantity, Double outstandingQuantity, Object consumedQuantity, Object returnedQuantity, Object issuedStatus, Object standardCostPrice, String isSparePartsSettled, Object isOriginalItemCode) {
        super();
        this.id = id;
        this.maintanenceScheduleId = maintanenceScheduleId;
        this.workOrderId = workOrderId;
        this.serviceId = serviceId;
        this.itemCode = itemCode;
        this.wareHouseInfo = wareHouseInfo;
        this.availableQuantity = availableQuantity;
        this.requestedQuantity = requestedQuantity;
        this.issueQuantity = issueQuantity;
        this.outstandingQuantity = outstandingQuantity;
        this.consumedQuantity = consumedQuantity;
        this.returnedQuantity = returnedQuantity;
        this.issuedStatus = issuedStatus;
        this.standardCostPrice = standardCostPrice;
        this.isSparePartsSettled = isSparePartsSettled;
        this.isOriginalItemCode = isOriginalItemCode;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getMaintanenceScheduleId() {
        return maintanenceScheduleId;
    }

    public void setMaintanenceScheduleId(String maintanenceScheduleId) {
        this.maintanenceScheduleId = maintanenceScheduleId;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Object getServiceId() {
        return serviceId;
    }

    public void setServiceId(Object serviceId) {
        this.serviceId = serviceId;
    }

    public ItemCode getItemCode() {
        return itemCode;
    }

    public void setItemCode(ItemCode itemCode) {
        this.itemCode = itemCode;
    }

    public WareHouseInfo getWareHouseInfo() {
        return wareHouseInfo;
    }

    public void setWareHouseInfo(WareHouseInfo wareHouseInfo) {
        this.wareHouseInfo = wareHouseInfo;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Object getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Object requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public Object getIssueQuantity() {
        return issueQuantity;
    }

    public void setIssueQuantity(Object issueQuantity) {
        this.issueQuantity = issueQuantity;
    }

    public Double getOutstandingQuantity() {
        return outstandingQuantity;
    }

    public void setOutstandingQuantity(Double outstandingQuantity) {
        this.outstandingQuantity = outstandingQuantity;
    }

    public Object getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(Object consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public Object getReturnedQuantity() {
        return returnedQuantity;
    }

    public void setReturnedQuantity(Object returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

    public Object getIssuedStatus() {
        return issuedStatus;
    }

    public void setIssuedStatus(Object issuedStatus) {
        this.issuedStatus = issuedStatus;
    }

    public Object getStandardCostPrice() {
        return standardCostPrice;
    }

    public void setStandardCostPrice(Object standardCostPrice) {
        this.standardCostPrice = standardCostPrice;
    }

    public String getIsSparePartsSettled() {
        return isSparePartsSettled;
    }

    public void setIsSparePartsSettled(String isSparePartsSettled) {
        this.isSparePartsSettled = isSparePartsSettled;
    }

    public Object getIsOriginalItemCode() {
        return isOriginalItemCode;
    }

    public void setIsOriginalItemCode(Object isOriginalItemCode) {
        this.isOriginalItemCode = isOriginalItemCode;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(maintanenceScheduleId);
        dest.writeValue(workOrderId);
        dest.writeValue(serviceId);
        dest.writeValue(itemCode);
        dest.writeValue(wareHouseInfo);
        dest.writeValue(availableQuantity);
        dest.writeValue(requestedQuantity);
        dest.writeValue(issueQuantity);
        dest.writeValue(outstandingQuantity);
        dest.writeValue(consumedQuantity);
        dest.writeValue(returnedQuantity);
        dest.writeValue(issuedStatus);
        dest.writeValue(standardCostPrice);
        dest.writeValue(isSparePartsSettled);
        dest.writeValue(isOriginalItemCode);
    }

    public int describeContents() {
        return 0;
    }

}
