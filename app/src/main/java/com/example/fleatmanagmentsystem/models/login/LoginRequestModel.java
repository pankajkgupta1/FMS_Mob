package com.example.fleatmanagmentsystem.models.login;

import java.util.HashMap;
import java.util.Map;
import android.os.Parcelable;


public class LoginRequestModel implements Parcelable {

    private String username;
    private String password;
    private String grant_type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<LoginRequestModel> CREATOR = new Creator<LoginRequestModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public LoginRequestModel createFromParcel(android.os.Parcel in) {
            return new LoginRequestModel(in);
        }

        public LoginRequestModel[] newArray(int size) {
            return (new LoginRequestModel[size]);
        }

    }
            ;

    protected LoginRequestModel(android.os.Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
        this.grant_type = ((String) in.readValue((String.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public LoginRequestModel() {
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getgrant_type() {
        return grant_type;
    }

    public void setgrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(password);
        dest.writeValue(grant_type);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }

}
