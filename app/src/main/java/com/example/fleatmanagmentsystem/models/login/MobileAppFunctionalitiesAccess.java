package com.example.fleatmanagmentsystem.models.login;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileAppFunctionalitiesAccess implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobileAppMainFunctionalities")
    @Expose
    private List<MobileAppMainFunctionality> mobileAppMainFunctionalities = new ArrayList<>();
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    public final static Creator<MobileAppFunctionalitiesAccess> CREATOR = new Creator<MobileAppFunctionalitiesAccess>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MobileAppFunctionalitiesAccess createFromParcel(android.os.Parcel in) {
            return new MobileAppFunctionalitiesAccess(in);
        }

        public MobileAppFunctionalitiesAccess[] newArray(int size) {
            return (new MobileAppFunctionalitiesAccess[size]);
        }

    }
            ;

    protected MobileAppFunctionalitiesAccess(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.mobileAppMainFunctionalities, (MobileAppMainFunctionality.class.getClassLoader()));
        this.role = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MobileAppFunctionalitiesAccess() {
    }

    /**
     *
     * @param country
     * @param role
     * @param name
     * @param id
     * @param organizationIdName
     * @param mobileAppMainFunctionalities
     */
    public MobileAppFunctionalitiesAccess(String id, String name, List<MobileAppMainFunctionality> mobileAppMainFunctionalities, String role, String organizationIdName, String country) {
        super();
        this.id = id;
        this.name = name;
        this.mobileAppMainFunctionalities = mobileAppMainFunctionalities;
        this.role = role;
        this.organizationIdName = organizationIdName;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MobileAppMainFunctionality> getMobileAppMainFunctionalities() {
        return mobileAppMainFunctionalities;
    }

    public void setMobileAppMainFunctionalities(List<MobileAppMainFunctionality> mobileAppMainFunctionalities) {
        this.mobileAppMainFunctionalities = mobileAppMainFunctionalities;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrganizationIdName() {
        return organizationIdName;
    }

    public void setOrganizationIdName(String organizationIdName) {
        this.organizationIdName = organizationIdName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeList(mobileAppMainFunctionalities);
        dest.writeValue(role);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
    }

    public int describeContents() {
        return 0;
    }

}
