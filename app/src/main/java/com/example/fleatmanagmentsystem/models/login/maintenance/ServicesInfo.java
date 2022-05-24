package com.example.fleatmanagmentsystem.models.login.maintenance;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServicesInfo implements Parcelable
{

    @SerializedName("serviceId")
    @Expose
    private String serviceId;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("serviceCost")
    @Expose
    private Double serviceCost;
    @SerializedName("isOriginalService")
    @Expose
    private Boolean isOriginalService;
    public final static Creator<ServicesInfo> CREATOR = new Creator<ServicesInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ServicesInfo createFromParcel(android.os.Parcel in) {
            return new ServicesInfo(in);
        }

        public ServicesInfo[] newArray(int size) {
            return (new ServicesInfo[size]);
        }

    }
            ;

    protected ServicesInfo(android.os.Parcel in) {
        this.serviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceName = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceType = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceCost = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isOriginalService = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ServicesInfo() {
    }

    public ServicesInfo(String serviceId, String serviceName, String description, String serviceType, Double serviceCost, Boolean isOriginalService) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.isOriginalService = isOriginalService;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Boolean getIsOriginalService() {
        return isOriginalService;
    }

    public void setIsOriginalService(Boolean isOriginalService) {
        this.isOriginalService = isOriginalService;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(serviceId);
        dest.writeValue(serviceName);
        dest.writeValue(description);
        dest.writeValue(serviceType);
        dest.writeValue(serviceCost);
        dest.writeValue(isOriginalService);
    }

    public int describeContents() {
        return 0;
    }

    /*@SerializedName("serviceId")
    @Expose
    private String serviceId;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("serviceCost")
    @Expose
    private Double serviceCost;
    @SerializedName("isOriginalService")
    @Expose
    private Boolean isOriginalService;
    public final static Creator<ServicesInfo> CREATOR = new Creator<ServicesInfo>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ServicesInfo createFromParcel(android.os.Parcel in) {
            return new ServicesInfo(in);
        }

        public ServicesInfo[] newArray(int size) {
            return (new ServicesInfo[size]);
        }

    }
            ;

    protected ServicesInfo(android.os.Parcel in) {
        this.serviceId = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceName = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceType = ((String) in.readValue((String.class.getClassLoader())));
        this.serviceCost = ((Double) in.readValue((Double.class.getClassLoader())));
        this.isOriginalService = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public ServicesInfo() {
    }

    public ServicesInfo(String serviceId, String serviceName, String description, String serviceType, Double serviceCost, Boolean isOriginalService) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.isOriginalService = isOriginalService;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Boolean getIsOriginalService() {
        return isOriginalService;
    }

    public void setIsOriginalService(Boolean isOriginalService) {
        this.isOriginalService = isOriginalService;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(serviceId);
        dest.writeValue(serviceName);
        dest.writeValue(description);
        dest.writeValue(serviceType);
        dest.writeValue(serviceCost);
        dest.writeValue(isOriginalService);
    }

    public int describeContents() {
        return 0;
    }*/

}
