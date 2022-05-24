package com.example.fleatmanagmentsystem.models.login;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FunctionalitiesAccess implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mainFunctionalities")
    @Expose
    private List<MainFunctionality> mainFunctionalities = new ArrayList<>();
    @SerializedName("mainFunctionalitiesForMasters")
    @Expose
    private List<MainFunctionalitiesForMaster> mainFunctionalitiesForMasters = new ArrayList<>();
    @SerializedName("reportsFunctionalities")
    @Expose
    private List<ReportsFunctionality> reportsFunctionalities = new ArrayList<>();
    @SerializedName("dashboardsFunctionalities")
    @Expose
    private List<DashboardsFunctionality> dashboardsFunctionalities = new ArrayList<>();
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    public final static Creator<FunctionalitiesAccess> CREATOR = new Creator<FunctionalitiesAccess>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FunctionalitiesAccess createFromParcel(android.os.Parcel in) {
            return new FunctionalitiesAccess(in);
        }

        public FunctionalitiesAccess[] newArray(int size) {
            return (new FunctionalitiesAccess[size]);
        }

    }
            ;

    protected FunctionalitiesAccess(android.os.Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.mainFunctionalities, (MainFunctionality.class.getClassLoader()));
        in.readList(this.mainFunctionalitiesForMasters, (MainFunctionalitiesForMaster.class.getClassLoader()));
        in.readList(this.reportsFunctionalities, (ReportsFunctionality.class.getClassLoader()));
        in.readList(this.dashboardsFunctionalities, (DashboardsFunctionality.class.getClassLoader()));
        this.role = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public FunctionalitiesAccess() {
    }

    /**
     *
     * @param mainFunctionalitiesForMasters
     * @param country
     * @param reportsFunctionalities
     * @param role
     * @param name
     * @param id
     * @param mainFunctionalities
     * @param dashboardsFunctionalities
     * @param organizationIdName
     */
    public FunctionalitiesAccess(String id, String name, List<MainFunctionality> mainFunctionalities, List<MainFunctionalitiesForMaster> mainFunctionalitiesForMasters, List<ReportsFunctionality> reportsFunctionalities, List<DashboardsFunctionality> dashboardsFunctionalities, String role, String organizationIdName, String country) {
        super();
        this.id = id;
        this.name = name;
        this.mainFunctionalities = mainFunctionalities;
        this.mainFunctionalitiesForMasters = mainFunctionalitiesForMasters;
        this.reportsFunctionalities = reportsFunctionalities;
        this.dashboardsFunctionalities = dashboardsFunctionalities;
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

    public List<MainFunctionality> getMainFunctionalities() {
        return mainFunctionalities;
    }

    public void setMainFunctionalities(List<MainFunctionality> mainFunctionalities) {
        this.mainFunctionalities = mainFunctionalities;
    }

    public List<MainFunctionalitiesForMaster> getMainFunctionalitiesForMasters() {
        return mainFunctionalitiesForMasters;
    }

    public void setMainFunctionalitiesForMasters(List<MainFunctionalitiesForMaster> mainFunctionalitiesForMasters) {
        this.mainFunctionalitiesForMasters = mainFunctionalitiesForMasters;
    }

    public List<ReportsFunctionality> getReportsFunctionalities() {
        return reportsFunctionalities;
    }

    public void setReportsFunctionalities(List<ReportsFunctionality> reportsFunctionalities) {
        this.reportsFunctionalities = reportsFunctionalities;
    }

    public List<DashboardsFunctionality> getDashboardsFunctionalities() {
        return dashboardsFunctionalities;
    }

    public void setDashboardsFunctionalities(List<DashboardsFunctionality> dashboardsFunctionalities) {
        this.dashboardsFunctionalities = dashboardsFunctionalities;
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
        dest.writeList(mainFunctionalities);
        dest.writeList(mainFunctionalitiesForMasters);
        dest.writeList(reportsFunctionalities);
        dest.writeList(dashboardsFunctionalities);
        dest.writeValue(role);
        dest.writeValue(organizationIdName);
        dest.writeValue(country);
    }

    public int describeContents() {
        return 0;
    }

}
