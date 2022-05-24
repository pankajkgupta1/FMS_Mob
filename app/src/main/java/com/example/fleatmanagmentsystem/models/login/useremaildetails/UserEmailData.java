package com.example.fleatmanagmentsystem.models.login.useremaildetails;

import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

public class UserEmailData implements Parcelable {

    private User user;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<UserEmailData> CREATOR = new Creator<UserEmailData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public UserEmailData createFromParcel(android.os.Parcel in) {
            return new UserEmailData(in);
        }

        public UserEmailData[] newArray(int size) {
            return (new UserEmailData[size]);
        }

    }
            ;

    protected UserEmailData(android.os.Parcel in) {
        this.user = ((User) in.readValue((User.class.getClassLoader())));
        this.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
    }

    public UserEmailData() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(user);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return 0;
    }
}
