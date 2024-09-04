package com.eq.epharma.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReportDto {
    private String reportType;
   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date endDate;
    private Date expiryDate;
    private String batchNo;

        
    public ReportDto() {
    }
    public String getReportType() {
        return reportType;
    }
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
  
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    @Override
    public String toString() {
        return "ReportDto [reportType=" + reportType + ", startDate=" + startDate + ", endDate=" + endDate + ",expiryDate=" +expiryDate+", batchNo=" +batchNo+"]";
    }
    
    
}
