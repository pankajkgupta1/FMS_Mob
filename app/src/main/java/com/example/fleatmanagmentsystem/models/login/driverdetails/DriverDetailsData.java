package com.example.fleatmanagmentsystem.models.login.driverdetails;

import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class DriverDetailsData implements Parcelable {

    private Object driver;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<DriverDetailsData> CREATOR = new Creator<DriverDetailsData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DriverDetailsData createFromParcel(android.os.Parcel in) {
            return new DriverDetailsData(in);
        }

        public DriverDetailsData[] newArray(int size) {
            return (new DriverDetailsData[size]);
        }

    }
            ;

    protected DriverDetailsData(android.os.Parcel in) {
        this.driver = ((Object) in.readValue((Object.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public DriverDetailsData() {
    }

    public Object getDriver() {
        return driver;
    }

    public void setDriver(Object driver) {
        this.driver = driver;
    }

    public DriverDetailsData withDriver(Object driver) {
        this.driver = driver;
        return this;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public DriverDetailsData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(driver);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }
}
