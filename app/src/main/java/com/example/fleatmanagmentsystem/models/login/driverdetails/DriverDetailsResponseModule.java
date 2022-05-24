package com.example.fleatmanagmentsystem.models.login.driverdetails;

import java.util.HashMap;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;

public class DriverDetailsResponseModule implements Parcelable
{

    private String status;
    private String statusMsg;
    private Object errorCode;
    private Data data;

    protected DriverDetailsResponseModule(Parcel in) {
        status = in.readString();
        statusMsg = in.readString();
    }

    public static final Creator<DriverDetailsResponseModule> CREATOR = new Creator<DriverDetailsResponseModule>() {
        @Override
        public DriverDetailsResponseModule createFromParcel(Parcel in) {
            return new DriverDetailsResponseModule(in);
        }

        @Override
        public DriverDetailsResponseModule[] newArray(int size) {
            return new DriverDetailsResponseModule[size];
        }
    };

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatusMsg() {
        return statusMsg;
    }
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
    public Object getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(statusMsg);
    }

    /*private String status;
    private String statusMsg;
    private Object errorCode;
    private DriverDetailsData data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<DriverDetailsResponseModule> CREATOR = new Creator<DriverDetailsResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DriverDetailsResponseModule createFromParcel(android.os.Parcel in) {
            return new DriverDetailsResponseModule(in);
        }

        public DriverDetailsResponseModule[] newArray(int size) {
            return (new DriverDetailsResponseModule[size]);
        }

    }
            ;

    protected DriverDetailsResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((DriverDetailsData) in.readValue((DriverDetailsData.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public DriverDetailsResponseModule() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DriverDetailsResponseModule withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public DriverDetailsResponseModule withStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
        return this;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public DriverDetailsResponseModule withErrorCode(Object errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public DriverDetailsData getData() {
        return data;
    }

    public void setData(DriverDetailsData data) {
        this.data = data;
    }

    public DriverDetailsResponseModule withData(DriverDetailsData data) {
        this.data = data;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public DriverDetailsResponseModule withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(statusMsg);
        dest.writeValue(errorCode);
        dest.writeValue(data);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }
*/
}