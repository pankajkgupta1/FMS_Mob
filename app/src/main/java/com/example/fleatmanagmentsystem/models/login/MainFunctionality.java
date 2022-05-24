package com.example.fleatmanagmentsystem.models.login;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainFunctionality implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subFunctionalities")
    @Expose
    private List<SubFunctionality> subFunctionalities = new ArrayList<>();
    public final static Creator<MainFunctionality> CREATOR = new Creator<MainFunctionality>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MainFunctionality createFromParcel(android.os.Parcel in) {
            return new MainFunctionality(in);
        }

        public MainFunctionality[] newArray(int size) {
            return (new MainFunctionality[size]);
        }

    }
            ;

    protected MainFunctionality(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.subFunctionalities, (SubFunctionality.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MainFunctionality() {
    }

    /**
     *
     * @param name
     * @param subFunctionalities
     */
    public MainFunctionality(String name, List<SubFunctionality> subFunctionalities) {
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

    public List<SubFunctionality> getSubFunctionalities() {
        return subFunctionalities;
    }

    public void setSubFunctionalities(List<SubFunctionality> subFunctionalities) {
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
