package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubFunctionality__3 implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<SubFunctionality__3> CREATOR = new Creator<SubFunctionality__3>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SubFunctionality__3 createFromParcel(android.os.Parcel in) {
            return new SubFunctionality__3(in);
        }

        public SubFunctionality__3 [] newArray(int size) {
            return (new SubFunctionality__3[size]);
        }

    }
            ;

    protected SubFunctionality__3(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public SubFunctionality__3() {
    }

    /**
     *
     * @param name
     */
    public SubFunctionality__3(String name) {
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
