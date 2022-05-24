package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubFunctionality implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<SubFunctionality> CREATOR = new Creator<SubFunctionality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SubFunctionality createFromParcel(android.os.Parcel in) {
            return new SubFunctionality(in);
        }

        public SubFunctionality[] newArray(int size) {
            return (new SubFunctionality[size]);
        }

    }
            ;

    protected SubFunctionality(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SubFunctionality() {
    }

    /**
     *
     * @param name
     */
    public SubFunctionality(String name) {
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
