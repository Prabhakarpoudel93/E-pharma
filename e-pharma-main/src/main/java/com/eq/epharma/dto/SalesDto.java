package com.eq.epharma.dto;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

public class SalesDto extends Dto {
    private int salesId;
    private Integer medicineId;
    private int quantity;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkOutDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private String batchNo;
    private int billId;
    private int entryBy;
    private String username;
    private String medicineName;

    

    public SalesDto() {
    }

    public SalesDto(int salesId, Integer medicineId, int quantity, double price, Date checkOutDate, Date expiryDate, String batchNo, int billId, int entryBy, String username, String medicineName) {
        this.salesId = salesId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.price = price;
        this.checkOutDate = checkOutDate;
        this.expiryDate = expiryDate;
        this.batchNo = batchNo;
        this.billId = billId;
        this.entryBy = entryBy;
        this.username = username;
        this.medicineName = medicineName;
    }



    public int getSalesId() {
        return salesId;
    }
    public void setSalesId(int salesId) {
        this.salesId = salesId;
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

    
    
    @Override
    public String toString() {
        return "SalesDto [salesId=" + salesId + ", medicineId=" + medicineId + ", quantity=" + quantity + ", price="
                + price + ", checkOutDate=" + checkOutDate + ",expiryDate=" +expiryDate +", batchNo=" +batchNo+", billId=" + billId +" entryBy=" + entryBy + ",username=" +username +" medicineName=" + medicineName +"]";
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

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
    
    
    
    
}
