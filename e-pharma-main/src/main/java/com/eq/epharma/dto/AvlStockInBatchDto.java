package com.eq.epharma.dto;

import java.util.Date;

public class AvlStockInBatchDto {
    private int avlStock;
    private int medicineId;
    private String medicineName;
    private String batchNo;
    private Date expiryDate;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public AvlStockInBatchDto() {
    }

    public int getAvlStock() {
        return avlStock;
    }

    public void setAvlStock(int avlStock) {
        this.avlStock = avlStock;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
