package com.eq.epharma.dto;

public class AvlStockDto {
    private String medicineName;
    private int availableStock;
    private int medicineId;
    
    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
    public int getAvailableStock() {
        return availableStock;
    }
    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
}
