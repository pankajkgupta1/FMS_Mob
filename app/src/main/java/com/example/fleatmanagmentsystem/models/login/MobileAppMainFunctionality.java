package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileAppMainFunctionality implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<MobileAppMainFunctionality> CREATOR = new Creator<MobileAppMainFunctionality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MobileAppMainFunctionality createFromParcel(android.os.Parcel in) {
            return new MobileAppMainFunctionality(in);
        }

        public MobileAppMainFunctionality[] newArray(int size) {
            return (new MobileAppMainFunctionality[size]);
        }

    }
            ;

    protected MobileAppMainFunctionality(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MobileAppMainFunctionality() {
    }

    /**
     *
     * @param name
     */
    public MobileAppMainFunctionality(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}
