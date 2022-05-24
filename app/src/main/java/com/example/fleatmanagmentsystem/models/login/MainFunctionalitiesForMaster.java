package com.example.fleatmanagmentsystem.models.login;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainFunctionalitiesForMaster implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subFunctionalities")
    @Expose
    private List<SubFunctionality__1> subFunctionalities = new ArrayList<>();
    public final static Creator<MainFunctionalitiesForMaster> CREATOR = new Creator<MainFunctionalitiesForMaster>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MainFunctionalitiesForMaster createFromParcel(android.os.Parcel in) {
            return new MainFunctionalitiesForMaster(in);
        }

        public MainFunctionalitiesForMaster[] newArray(int size) {
            return (new MainFunctionalitiesForMaster[size]);
        }

    }
            ;

    protected MainFunctionalitiesForMaster(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subFunctionalities, (SubFunctionality__1.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MainFunctionalitiesForMaster() {
    }

    /**
     *
     * @param name
     * @param subFunctionalities
     */
    public MainFunctionalitiesForMaster(String name, List<SubFunctionality__1> subFunctionalities) {
        super();
        this.name = name;
        this.subFunctionalities = subFunctionalities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubFunctionality__1> getSubFunctionalities() {
        return subFunctionalities;
    }

    public void setSubFunctionalities(List<SubFunctionality__1> subFunctionalities) {
        this.subFunctionalities = subFunctionalities;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeList(subFunctionalities);
    }

    public int describeContents() {
        return 0;
    }

}
