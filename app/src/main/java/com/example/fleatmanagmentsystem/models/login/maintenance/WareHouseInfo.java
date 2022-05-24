package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WareHouseInfo implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("wareHouseID")
    @Expose
    private String wareHouseID;
    @SerializedName("wareHouseName")
    @Expose
    private String wareHouseName;
    public final static Creator<WareHouseInfo> CREATOR = new Creator<WareHouseInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public WareHouseInfo createFromParcel(android.os.Parcel in) {
            return new WareHouseInfo(in);
        }

        public WareHouseInfo[] newArray(int size) {
            return (new WareHouseInfo[size]);
        }

    }
            ;

    protected WareHouseInfo(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.wareHouseID = ((String) in.readValue((String.class.getClassLoader())));
        this.wareHouseName = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public WareHouseInfo() {
    }

    /**
     *
     * @param wareHouseID
     * @param id
     * @param wareHouseName
     */
    public WareHouseInfo(String id, String wareHouseID, String wareHouseName) {
        super();
        this.id = id;
        this.wareHouseID = wareHouseID;
        this.wareHouseName = wareHouseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(String wareHouseID) {
        this.wareHouseID = wareHouseID;
    }

    public String getWareHouseName() {
        return wareHouseName;
    }

    public void setWareHouseName(String wareHouseName) {
        this.wareHouseName = wareHouseName;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(wareHouseID);
        dest.writeValue(wareHouseName);
    }

    public int describeContents() {
        return 0;
    }

}
