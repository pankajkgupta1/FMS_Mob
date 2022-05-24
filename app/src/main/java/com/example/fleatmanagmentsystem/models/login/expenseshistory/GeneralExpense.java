package com.example.fleatmanagmentsystem.models.login.expenseshistory;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeneralExpense implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("generalExpensesPrefix")
    @Expose
    private String generalExpensesPrefix;
    @SerializedName("generalExpensesSequenceNumber")
    @Expose
    private Integer generalExpensesSequenceNumber;
    @SerializedName("generalExpensesId")
    @Expose
    private String generalExpensesId;
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
    private String discount;
    @SerializedName("discountAmount")
    @Expose
    private String discountAmount;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("tax")
    @Expose
    private String tax;
    @SerializedName("taxAmount")
    @Expose
    private String taxAmount;
    @SerializedName("totalAmount")
    @Expose
    private String totalAmount;
    @SerializedName("billAttachments")
    @Expose
    private List<Object> billAttachments = null;
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
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.generalExpensesPrefix = ((String) in.readValue((String.class.getClassLoader())));
        this.generalExpensesSequenceNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.generalExpensesId = ((String) in.readValue((String.class.getClassLoader())));
        this.expensesName = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.quantity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.rate = ((Double) in.readValue((Double.class.getClassLoader())));
        this.discount = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tax = ((String) in.readValue((String.class.getClassLoader())));
        this.taxAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.totalAmount = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.billAttachments, (java.lang.Object.class.getClassLoader()));
        this.createdDateTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GeneralExpense() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGeneralExpensesPrefix() {
        return generalExpensesPrefix;
    }

    public void setGeneralExpensesPrefix(String generalExpensesPrefix) {
        this.generalExpensesPrefix = generalExpensesPrefix;
    }

    public Integer getGeneralExpensesSequenceNumber() {
        return generalExpensesSequenceNumber;
    }

    public void setGeneralExpensesSequenceNumber(Integer generalExpensesSequenceNumber) {
        this.generalExpensesSequenceNumber = generalExpensesSequenceNumber;
    }

    public String getGeneralExpensesId() {
        return generalExpensesId;
    }

    public void setGeneralExpensesId(String generalExpensesId) {
        this.generalExpensesId = generalExpensesId;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Object> getBillAttachments() {
        return billAttachments;
    }

    public void setBillAttachments(List<Object> billAttachments) {
        this.billAttachments = billAttachments;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(generalExpensesPrefix);
        dest.writeValue(generalExpensesSequenceNumber);
        dest.writeValue(generalExpensesId);
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
