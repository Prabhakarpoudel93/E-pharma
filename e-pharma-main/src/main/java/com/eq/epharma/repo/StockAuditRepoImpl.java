package com.eq.epharma.repo;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.StockAuditDto;

@Repository
public class StockAuditRepoImpl implements StockAuditRepo {

    private final JdbcTemplate jt;

    public StockAuditRepoImpl(JdbcTemplate jt)
    {
        this.jt=jt;
    }

    @Override
    public int addStockAudit(StockAuditDto stockAudit) {
        int flag=0;
        String sql="insert into stockAudit (stockId,medicineId, quantity,price,checkInDate,expiryDate,batchNo,entryBy,auditType,auditDateTime,auditBy) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("Inside sales repo impl : "+ "audit id: "+stockAudit.getAuditId()+ "sales id: "+stockAudit.getStockId()+"med id: "+stockAudit.getMedicineId()+"Qty: "+stockAudit.getQuantity()+"Price: "+stockAudit.getPrice()+"chekoutdate: "+stockAudit.getCheckInDate()+" Expiry Date: "+stockAudit.getExpiryDate()+"Batch Number: "+stockAudit.getBatchNo()+" enty by: "+stockAudit.getEntryBy());
          flag= this.jt.update(sql,stockAudit.getStockId(),stockAudit.getMedicineId(),stockAudit.getQuantity(),stockAudit.getPrice(),stockAudit.getCheckInDate(),stockAudit.getExpiryDate(),stockAudit.getBatchNo(), stockAudit.getEntryBy(), stockAudit.getAuditBy(), new Date(),stockAudit.getAuditBy());
      
        } catch (Exception e) {
            flag=0;
           
        }

        return flag;
    }
    
}
    

