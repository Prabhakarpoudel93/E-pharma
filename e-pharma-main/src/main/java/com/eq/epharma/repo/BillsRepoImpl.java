package com.eq.epharma.repo;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.BillsDto;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BillsRepoImpl implements BillsRepo {
    private final JdbcTemplate jt;

    public BillsRepoImpl(JdbcTemplate jt)
    {
        this.jt=jt;
    }

    @Override
    public int addBills(BillsDto bills) {
        int flag=0;
        String sql="insert into bills (billId,salesId, billingDate,customerName,entryBy) values (?,?,?,?,?)";
        try {
        System.out.println("Inside bills repo impl");
          flag= this.jt.update(sql,bills.getBillId(),bills.getSalesId(),bills.getBillingDate(),bills.getCustomerName(),bills.getEntryBy());
      
        } catch (Exception e) {
            flag=0;
           
        }

        return flag;
    }

    @Override
    public int getMaxBillsId() {
        int maxBillsId=0;
        String sql="select max(billId) from bills";
        try {
            maxBillsId= this.jt.queryForObject(sql,Integer.class);
        } catch (Exception e) {
            
        }
        return maxBillsId;
    }


    @Override
    public List<BillsDto> getBillsById(int id) {
        List<BillsDto> billsDto=new ArrayList<>();
        String sql= """
                    SELECT ROW_NUMBER() OVER (ORDER BY s.salesId) AS srNo,s.salesId,m.medicineName,s.batchNo,s.expiryDate,s.quantity,s.price,s.checkOutDate
                    FROM sales s inner join medicines m on s.medicineId=m.medicineId where s.billId=?
                    """;
        try {
            billsDto= this.jt.query(sql, BeanPropertyRowMapper.newInstance(BillsDto.class),id);
        } catch (Exception e) {

        }
        return billsDto;
    }
}
