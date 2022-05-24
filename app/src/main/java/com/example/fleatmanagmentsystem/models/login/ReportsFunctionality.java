package com.example.fleatmanagmentsystem.models.login;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ReportsFunctionality implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subFunctionalities")
    @Expose
    private List<SubFunctionality__2> subFunctionalities = new ArrayList<>();
    public final static Creator<ReportsFunctionality> CREATOR = new Creator<ReportsFunctionality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ReportsFunctionality createFromParcel(android.os.Parcel in) {
            return new ReportsFunctionality(in);
        }

        public ReportsFunctionality[] newArray(int size) {
            return (new ReportsFunctionality[size]);
        }

    }
            ;

    protected ReportsFunctionality(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subFunctionalities, (SubFunctionality__2.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public ReportsFunctionality() {
    }

    /**
     *
     * @param name
     * @param subFunctionalities
     */
    public ReportsFunctionality(String name, List<SubFunctionality__2> subFunctionalities) {
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

    public List<SubFunctionality__2> getSubFunctionalities() {
        return subFunctionalities;
    }

    public void setSubFunctionalities(List<SubFunctionality__2> subFunctionalities) {
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