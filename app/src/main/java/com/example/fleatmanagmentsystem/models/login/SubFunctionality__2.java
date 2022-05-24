package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubFunctionality__2 implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<SubFunctionality__2> CREATOR = new Creator<SubFunctionality__2>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SubFunctionality__2 createFromParcel(android.os.Parcel in) {
            return new SubFunctionality__2(in);
        }

        public SubFunctionality__2 [] newArray(int size) {
            return (new SubFunctionality__2[size]);
        }

    }
            ;

    protected SubFunctionality__2(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SubFunctionality__2() {
    }

    /**
     *
     * @param name
     */
    public SubFunctionality__2(String name) {
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
