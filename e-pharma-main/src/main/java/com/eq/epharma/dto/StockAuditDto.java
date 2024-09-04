package com.eq.epharma.dto;
import java.util.Date;

public class StockAuditDto {
    private int auditId;
    private int stockId;
    private Integer medicineId;
    private int quantity;
    private double price;
    private Date checkInDate;
    private Date expiryDate;
    private String batchNo;
    private int entryBy;
    private String auditType;
    private Date auditDateTime;
    private int auditBy;

    public StockAuditDto() {
    }
   
    public StockAuditDto(int auditId, int stockId, int medicineId, int quantity, double price, Date checkInDate, Date expiryDate, String batchNo, int entryBy, String auditType, Date auditDateTime,int auditBy) {
        this.auditId = auditId;
        this.stockId = stockId;
        this.medicineId = medicineId;
        this.quantity = quantity;
        this.price = price;
        this.checkInDate = checkInDate;
        this.expiryDate = expiryDate;
        this.batchNo = batchNo;
        this.entryBy = entryBy;
        this.auditType = auditType;
        this.auditDateTime = auditDateTime;
        this.auditBy = auditBy;

}

    public int getAuditId() {
        return auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public int getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(int entryBy) {
        this.entryBy = entryBy;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Date getAuditDateTime() {
        return auditDateTime;
    }

    public void setAuditDateTime(Date auditDateTime) {
        this.auditDateTime = auditDateTime;
    }

    public int getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(int auditBy) {
        this.auditBy = auditBy;
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

}
