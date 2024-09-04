package com.eq.epharma.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StockDto extends Dto {
    private int stockId;
    private Integer medicineId;
    private int quantity;
    private double price;
    private int entryBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;
    private String batchNo;
    private String username;
    private String medicineName;


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

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public StockDto() {
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public String toString() {
        return "StockDto [stockId=" + stockId + ", medicineId=" + medicineId + ", quantity=" + quantity + ", price="
                + price + ", entryBy=" + entryBy + ", checkInDate=" + checkInDate + ",expiryDate=" +expiryDate +", batchNo=" +batchNo+ ",username=" + username
                + " medicineName=" + medicineName + "]";
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

}
