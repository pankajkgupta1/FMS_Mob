package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FuelExpensesRequestModule implements Parcelable
{

    @SerializedName("tripId")
    @Expose
    private String tripId;
    @SerializedName("organizationIdName")
    @Expose
    private String organizationIdName;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("loadSequenceHelper")
    @Expose
    private List<LoadSequenceHelper> loadSequenceHelper = null;
    @SerializedName("vehicleId")
    @Expose
    private String vehicleId;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("invoiceId")
    @Expose
    private String invoiceId;
    @SerializedName("invoiceOrPaymentDate")
    @Expose
    private String invoiceOrPaymentDate;
    @SerializedName("currentOdometer")
    @Expose
    private Double currentOdometer;
    @SerializedName("PaymentDueDate")
    @Expose
    private String paymentDueDate;
    @SerializedName("vendorId")
    @Expose
    private String vendorId;
    @SerializedName("transactionDateTime")
    @Expose
    private String transactionDateTime;
    @SerializedName("previousFuelingOdoMeterReading")
    @Expose
    private Double previousFuelingOdoMeterReading;
    @SerializedName("generalExpenses")
    @Expose
    private List<GeneralExpense> generalExpenses;
    @SerializedName("generalExpensesTotal")
    @Expose
    private Double generalExpensesTotal;
    @SerializedName("fuelCharges")
    @Expose
    private List<FuelCharge> fuelCharges;
    @SerializedName("fuelChargesTotal")
    @Expose
    private Double fuelChargesTotal;
    @SerializedName("tollCharges")
    @Expose
    private List<TollCharge> tollCharges ;
    @SerializedName("tollChargesTotal")
    @Expose
    private Double tollChargesTotal;
    @SerializedName("taxCharges")
    @Expose
    private List<TaxCharge> taxCharges;
    @SerializedName("taxChargesTotal")
    @Expose
    private Double taxChargesTotal;
    @SerializedName("chargesTotal")
    @Expose
    private Double chargesTotal;
    public final static Creator<FuelExpensesRequestModule> CREATOR = new Creator<FuelExpensesRequestModule>() {


        @SuppressWarnings({
                "unchecked"
        })
        public FuelExpensesRequestModule createFromParcel(android.os.Parcel in) {
            return new FuelExpensesRequestModule(in);
        }

        public FuelExpensesRequestModule[] newArray(int size) {
            return (new FuelExpensesRequestModule[size]);
        }

    }
            ;

    protected FuelExpensesRequestModule(android.os.Parcel in) {
        this.tripId = ((String) in.readValue((String.class.getClassLoader())));
        this.organizationIdName = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.loadSequenceHelper, (LoadSequenceHelper.class.getClassLoader()));
        this.vehicleId = ((String) in.readValue((String.class.getClassLoader())));
        this.driverId = ((String) in.readValue((String.class.getClassLoader())));
        this.invoiceId = ((String) in.readValue((String.class.getClassLoader())));
        this.invoiceOrPaymentDate = ((String) in.readValue((String.class.getClassLoader())));
        this.currentOdometer = ((Double) in.readValue((Double.class.getClassLoader())));
        this.paymentDueDate = ((String) in.readValue((String.class.getClassLoader())));
        this.vendorId = ((String) in.readValue((String.class.getClassLoader())));
        this.transactionDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.previousFuelingOdoMeterReading = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.generalExpenses, (GeneralExpense.class.getClassLoader()));
        this.generalExpensesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.fuelCharges, (FuelCharge.class.getClassLoader()));
        this.fuelChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.tollCharges, (TollCharge.class.getClassLoader()));
        this.tollChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.taxCharges, (TaxCharge.class.getClassLoader()));
        this.taxChargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
        this.chargesTotal = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    public FuelExpensesRequestModule() {
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

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public List<LoadSequenceHelper> getLoadSequenceHelper() {
        return loadSequenceHelper;
    }

    public void setLoadSequenceHelper(List<LoadSequenceHelper> loadSequenceHelper) {
        this.loadSequenceHelper = loadSequenceHelper;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceOrPaymentDate() {
        return invoiceOrPaymentDate;
    }

    public void setInvoiceOrPaymentDate(String invoiceOrPaymentDate) {
        this.invoiceOrPaymentDate = invoiceOrPaymentDate;
    }

    public Double getCurrentOdometer() {
        return currentOdometer;
    }

    public void setCurrentOdometer(Double currentOdometer) {
        this.currentOdometer = currentOdometer;
    }

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(String transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public Double getPreviousFuelingOdoMeterReading() {
        return previousFuelingOdoMeterReading;
    }

    public void setPreviousFuelingOdoMeterReading(Double previousFuelingOdoMeterReading) {
        this.previousFuelingOdoMeterReading = previousFuelingOdoMeterReading;
    }

    public List<GeneralExpense> getGeneralExpenses() {
        return generalExpenses;
    }

    public void setGeneralExpenses(List<GeneralExpense> generalExpenses) {
        this.generalExpenses = generalExpenses;
    }

    public Double getGeneralExpensesTotal() {
        return generalExpensesTotal;
    }

    public void setGeneralExpensesTotal(Double generalExpensesTotal) {
        this.generalExpensesTotal = generalExpensesTotal;
    }

    public List<FuelCharge> getFuelCharges() {
        return fuelCharges;
    }

    public void setFuelCharges(List<FuelCharge> fuelCharges) {
        this.fuelCharges = fuelCharges;
    }

    public Double getFuelChargesTotal() {
        return fuelChargesTotal;
    }

    public void setFuelChargesTotal(Double fuelChargesTotal) {
        this.fuelChargesTotal = fuelChargesTotal;
    }

    public List<TollCharge> getTollCharges() {
        return tollCharges;
    }

    public void setTollCharges(List<TollCharge> tollCharges) {
        this.tollCharges = tollCharges;
    }

    public Double getTollChargesTotal() {
        return tollChargesTotal;
    }

    public void setTollChargesTotal(Double tollChargesTotal) {
        this.tollChargesTotal = tollChargesTotal;
    }

    public List<TaxCharge> getTaxCharges() {
        return taxCharges;
    }

    public void setTaxCharges(List<TaxCharge> taxCharges) {
        this.taxCharges = taxCharges;
    }

    public Double getTaxChargesTotal() {
        return taxChargesTotal;
    }

    public void setTaxChargesTotal(Double taxChargesTotal) {
        this.taxChargesTotal = taxChargesTotal;
    }

    public Double getChargesTotal() {
        return chargesTotal;
    }

    public void setChargesTotal(Double chargesTotal) {
        this.chargesTotal = chargesTotal;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(tripId);
        dest.writeValue(organizationIdName);
        dest.writeValue(vehicleId);
        dest.writeList(loadSequenceHelper);
        dest.writeValue(vehicleId);
        dest.writeValue(driverId);
        dest.writeValue(invoiceId);
        dest.writeValue(invoiceOrPaymentDate);
        dest.writeValue(currentOdometer);
        dest.writeValue(paymentDueDate);
        dest.writeValue(vendorId);
        dest.writeValue(transactionDateTime);
        dest.writeValue(previousFuelingOdoMeterReading);
        dest.writeList(generalExpenses);
        dest.writeValue(generalExpensesTotal);
        dest.writeList(fuelCharges);
        dest.writeValue(fuelChargesTotal);
        dest.writeList(tollCharges);
        dest.writeValue(tollChargesTotal);
        dest.writeList(taxCharges);
        dest.writeValue(taxChargesTotal);
        dest.writeValue(chargesTotal);
    }

    public int describeContents() {
        return 0;
    }

}
