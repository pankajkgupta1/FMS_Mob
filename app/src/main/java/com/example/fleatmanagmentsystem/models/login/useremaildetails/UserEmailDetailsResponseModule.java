package com.example.fleatmanagmentsystem.models.login.useremaildetails;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcelable;

public class UserEmailDetailsResponseModule implements Parcelable
{

    private String status;
    private String statusMsg;
    private Object errorCode;
    private UserEmailData data;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<UserEmailDetailsResponseModule> CREATOR = new Creator<UserEmailDetailsResponseModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserEmailDetailsResponseModule createFromParcel(android.os.Parcel in) {
            return new UserEmailDetailsResponseModule(in);
        }

        public UserEmailDetailsResponseModule[] newArray(int size) {
            return (new UserEmailDetailsResponseModule[size]);
        }

    }
            ;

    protected UserEmailDetailsResponseModule(android.os.Parcel in) {
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusMsg = ((String) in.readValue((String.class.getClassLoader())));
        this.errorCode = ((Object) in.readValue((Object.class.getClassLoader())));
        this.data = ((UserEmailData) in.readValue((UserEmailData.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public UserEmailDetailsResponseModule() {
    }

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

    public UserEmailData getData() {
        return data;
    }

    public void setData(UserEmailData data) {
        this.data = data;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
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

}
