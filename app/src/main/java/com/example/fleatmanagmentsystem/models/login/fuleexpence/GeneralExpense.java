package com.example.fleatmanagmentsystem.models.login.fuleexpence;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralExpense implements Parcelable
{

    @SerializedName("expensesName")
    @Expose
    private String expensesName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("quantity")
    @Expose
    private Double quantity;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("discount")
    @Expose
    private Double discount;
    @SerializedName("discountAmount")
    @Expose
    private Double discountAmount;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("tax")
    @Expose
    private Double tax;
    @SerializedName("taxAmount")
    @Expose
    private Double taxAmount;
    @SerializedName("totalAmount")
    @Expose
    private Double totalAmount;
    @SerializedName("billAttachments")
    @Expose
    private List<String> billAttachments = null;
    @SerializedName("createdDateTime")
    @Expose
    private String createdDateTime;
    public final static Creator<GeneralExpense> CREATOR = new Creator<GeneralExpense>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GeneralExpense createFromParcel(android.os.Parcel in) {
            return new GeneralExpense(in);
        }

        public GeneralExpense[] newArray(int size) {
            return (new GeneralExpense[size]);
        }

    }
            ;

    protected GeneralExpense(android.os.Parcel in) {
        this.expensesName = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discountAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.amount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tax = ((Double) in.readValue((Double.class.getClassLoader())));
        this.taxAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.totalAmount = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.billAttachments, (java.lang.String.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GeneralExpense() {
    }

    public String getExpensesName() {
        return expensesName;
    }

    public void setExpensesName(String expensesName) {
        this.expensesName = expensesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getBillAttachments() {
        return billAttachments;
    }

    public void setBillAttachments(List<String> billAttachments) {
        this.billAttachments = billAttachments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(expensesName);
        dest.writeValue(description);
        dest.writeValue(quantity);
        dest.writeValue(rate);
        dest.writeValue(discount);
        dest.writeValue(discountAmount);
        dest.writeValue(amount);
        dest.writeValue(tax);
        dest.writeValue(taxAmount);
        dest.writeValue(totalAmount);
        dest.writeList(billAttachments);
        dest.writeValue(createdDateTime);
    }

    public int describeContents() {
        return 0;
    }

}
