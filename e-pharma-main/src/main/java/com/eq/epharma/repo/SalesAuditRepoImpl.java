package com.eq.epharma.repo;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.SalesAuditDto;
@Repository
public class SalesAuditRepoImpl implements SalesAuditRepo{
    private final JdbcTemplate jt;

    public SalesAuditRepoImpl(JdbcTemplate jt)
    {
        this.jt=jt;
    }

    @Override
    public int addSalesAudit(SalesAuditDto salesAudit) {
        int flag=0;
        String sql="insert into salesAudit (salesId,medicineId, quantity,price,checkOutDate,expiryDate,batchNo,billId,entryBy,auditType,auditDateTime,auditBy) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("Inside sales repo impl : "+ "audit id: "+salesAudit.getBillId()+ "sales id: "+salesAudit.getSalesId()+"med id: "+salesAudit.getMedicineId()+"Qty: "+salesAudit.getQuantity()+"Price: "+salesAudit.getPrice()+"chekoutdate: "+salesAudit.getCheckOutDate()+"expiryDate: "+salesAudit.getExpiryDate()+" batchNo: "+salesAudit.getBatchNo()+" billId: "+salesAudit.getBillId()+"entryBy: "+salesAudit.getEntryBy()+"auditType: "+salesAudit.getAuditType()+"aditDateTime: "+salesAudit.getAuditDateTime()+"auditBy: "+salesAudit.getAuditBy());
          flag= this.jt.update(sql,salesAudit.getSalesId(),salesAudit.getMedicineId(),salesAudit.getQuantity(),salesAudit.getPrice(),salesAudit.getCheckOutDate(),salesAudit.getExpiryDate(), salesAudit.getBatchNo(), salesAudit.getBillId(), salesAudit.getEntryBy(),salesAudit.getAuditType(),new Date(),salesAudit.getAuditBy());
      
        } catch (Exception e) {
            flag=0;
           
        }

        return flag;
    }
    
}
