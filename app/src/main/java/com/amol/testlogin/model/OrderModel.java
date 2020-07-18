package com.amol.testlogin.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amolmhatre on 7/7/20
 */


public class OrderModel {

    @SerializedName("vendor_order_id")
    @Expose
    private String vendorOrderId;
    @SerializedName("purchase_date")
    @Expose
    private String purchaseDate;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("grand_total")
    @Expose
    private String grandTotal;
    @SerializedName("vendor_Name")
    @Expose
    private String vendorName;

    /**
     * No args constructor for use in serialization
     *
     */
    public OrderModel() {
    }

    /**
     *
     * @param purchaseDate
     * @param grandTotal
     * @param vendorOrderId
     * @param paymentMethod
     * @param orderStatus
     * @param vendorName
     * @param paymentStatus
     * @param transactionId
     */
    public OrderModel(String vendorOrderId, String purchaseDate, String paymentStatus, String paymentMethod, String transactionId, String orderStatus, String grandTotal, String vendorName) {
        super();
        this.vendorOrderId = vendorOrderId;
        this.purchaseDate = purchaseDate;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.orderStatus = orderStatus;
        this.grandTotal = grandTotal;
        this.vendorName = vendorName;
    }

    public String getVendorOrderId() {
        return vendorOrderId;
    }

    public void setVendorOrderId(String vendorOrderId) {
        this.vendorOrderId = vendorOrderId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

}