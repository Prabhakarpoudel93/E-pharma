package com.eq.epharma.dto;
import java.util.Date;


public class SalesAuditDto {
    private int auditId;
    private int salesId;
    private Integer medicineId;
    private int quantity;
    private double price;
    private Date checkOutDate;
    private Date expiryDate;
    private String batchNo;
    private int billId;
    private int entryBy;
    private String auditType;
    private Date auditDateTime;
    private int auditBy;


    public SalesAuditDto() {
    }
        public SalesAuditDto(int auditId, int salesId, int medicineId, int quantity, double price, Date checkOutDate, Date expiryDate, String batchNo, int billId, int entryBy, String auditType, Date auditDateTime,int auditBy) {
            this.auditId = auditId;
            this.salesId = salesId;
            this.medicineId = medicineId;
            this.quantity = quantity;
            this.price = price;
            this.checkOutDate = checkOutDate;
            this.expiryDate = expiryDate;
            this.batchNo = batchNo;
            this.billId = billId;
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
        public int getSalesId() {
            return salesId;
        }
        public void setSalesId(int salesId) {
            this.salesId = salesId;
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
        public int getBillId() {
            return billId;
        }
        public void setBillId(int billId) {
            this.billId = billId;
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
