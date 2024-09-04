package com.eq.epharma.dto;

public class MedicinesDto {
    public Integer medicineId;
    public String medicineName;
    public String medicineDescription;

    public MedicinesDto() {
    }

    public MedicinesDto(Integer medicineId, String medicineName, String medicineDescription) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
    }

    public Integer getmedicineId() {
        return medicineId;
    }

    public void setmedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getmedicineName() {
        return medicineName;
    }

    public void setmedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getmedicineDescription() {
        return medicineDescription;
    }

    public void setmedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }
}
