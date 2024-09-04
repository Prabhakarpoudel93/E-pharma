package com.eq.epharma.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BillsDto {
    private int srNo;
    private int billId;
    private int salesId;
    private Date billingDate;

    private Integer medicineId;
    private int quantity;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private String batchNo;
    private int entryBy;
    private String username;
    private String medicineName;
    private int totalQuantity;
    private double totalPrice;



    private String customerName;


    
    public BillsDto() {
    }
    
    public BillsDto(int billId, int salesId, Date billingDate, String customerName, int entryBy) {
        this.billId = billId;
        this.salesId = salesId;
        this.billingDate = billingDate;
        this.customerName = customerName;
        this.entryBy = entryBy;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public int getBillId() {
        return billId;
    }
    public void setBillId(int billId) {
        this.billId = billId;
    }
    public int getSalesId() {
        return salesId;
    }
    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }
    public Date getBillingDate() {
        return billingDate;
    }
    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getEntryBy() {
        return entryBy;
    }
    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }


    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
