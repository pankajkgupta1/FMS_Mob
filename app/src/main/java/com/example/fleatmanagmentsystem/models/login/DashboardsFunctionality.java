package com.example.fleatmanagmentsystem.models.login;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardsFunctionality implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subFunctionalities")
    @Expose
    private List<SubFunctionality__3> subFunctionalities = new ArrayList<>();
    public final static Creator<DashboardsFunctionality> CREATOR = new Creator<DashboardsFunctionality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DashboardsFunctionality createFromParcel(android.os.Parcel in) {
            return new DashboardsFunctionality(in);
        }

        public DashboardsFunctionality[] newArray(int size) {
            return (new DashboardsFunctionality[size]);
        }

    }
            ;

    protected DashboardsFunctionality(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subFunctionalities, (SubFunctionality__3.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DashboardsFunctionality() {
    }

    /**
     *
     * @param name
     * @param subFunctionalities
     */
    public DashboardsFunctionality(String name, List<SubFunctionality__3> subFunctionalities) {
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

    public List<SubFunctionality__3> getSubFunctionalities() {
        return subFunctionalities;
    }

    public void setSubFunctionalities(List<SubFunctionality__3> subFunctionalities) {
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
