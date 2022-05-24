package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemCode implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("itemCode")
    @Expose
    private String itemCode;
    @SerializedName("itemMasterId")
    @Expose
    private Object itemMasterId;
    @SerializedName("itemDescription")
    @Expose
    private String itemDescription;
    @SerializedName("itemType")
    @Expose
    private String itemType;
    @SerializedName("receivingUnit")
    @Expose
    private Object receivingUnit;
    @SerializedName("minimumOrderQuantity")
    @Expose
    private Object minimumOrderQuantity;
    public final static Creator<ItemCode> CREATOR = new Creator<ItemCode>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ItemCode createFromParcel(android.os.Parcel in) {
            return new ItemCode(in);
        }

        public ItemCode[] newArray(int size) {
            return (new ItemCode[size]);
        }

    }
            ;

    protected ItemCode(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.itemCode = ((String) in.readValue((String.class.getClassLoader())));
        this.itemMasterId = ((Object) in.readValue((Object.class.getClassLoader())));
        this.itemDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.itemType = ((String) in.readValue((String.class.getClassLoader())));
        this.receivingUnit = ((Object) in.readValue((Object.class.getClassLoader())));
        this.minimumOrderQuantity = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ItemCode() {
    }

    public ItemCode(String id, String itemCode, Object itemMasterId, String itemDescription, String itemType, Object receivingUnit, Object minimumOrderQuantity) {
        super();
        this.id = id;
        this.itemCode = itemCode;
        this.itemMasterId = itemMasterId;
        this.itemDescription = itemDescription;
        this.itemType = itemType;
        this.receivingUnit = receivingUnit;
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Object getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(Object itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Object getReceivingUnit() {
        return receivingUnit;
    }

    public void setReceivingUnit(Object receivingUnit) {
        this.receivingUnit = receivingUnit;
    }

    public Object getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(Object minimumOrderQuantity) {
        this.minimumOrderQuantity = minimumOrderQuantity;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(itemCode);
        dest.writeValue(itemMasterId);
        dest.writeValue(itemDescription);
        dest.writeValue(itemType);
        dest.writeValue(receivingUnit);
        dest.writeValue(minimumOrderQuantity);
    }

    public int describeContents() {
        return 0;
    }

}
