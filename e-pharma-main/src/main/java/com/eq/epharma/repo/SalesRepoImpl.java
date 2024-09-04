package com.eq.epharma.repo;

import java.util.Date;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.SalesDto;

@Repository
public class SalesRepoImpl implements SalesRepo {
    private final JdbcTemplate jt;

    public SalesRepoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public int addSales(SalesDto sales) {
        int flag = 0;
        String sql = "insert into sales (salesId,medicineId, quantity,price,checkOutDate,billId,entryBy,systemDateTime,expiryDate,batchNo) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("Inside sales repo impl : " + "sales id: " + sales.getSalesId() + "med id: "
                    + sales.getMedicineId() + "Qty: " + sales.getQuantity() + "Price: " + sales.getPrice()
                    + "chekoutdate: " + sales.getCheckOutDate() + "billId: " + sales.getBillId() + "enty by: "
                    + sales.getEntryBy());
            flag = this.jt.update(sql, sales.getSalesId(), sales.getMedicineId(), sales.getQuantity(), sales.getPrice(),
                    sales.getCheckOutDate(), sales.getBillId(), sales.getEntryBy(), new Date(), sales.getExpiryDate(),
                    sales.getBatchNo());

        } catch (Exception e) {
            flag = 0;

        }

        return flag;
    }

    @Override
    public int getMaxSalesId() {
        int maxSalesId = 0;
        String sql = "select max(salesId) from sales";
        try {
            maxSalesId = this.jt.queryForObject(sql, Integer.class);
        } catch (Exception e) {

        }
        return maxSalesId;
    }

    @Override
    public int getMaxBillId() {
        int maxSalesId = 0;
        String sql = "select max(billId) from sales";
        try {
            maxSalesId = this.jt.queryForObject(sql, Integer.class);
        } catch (Exception e) {

        }
        return maxSalesId;
    }

    @Override
    public SalesDto searchSalesById(int id) {
        String sql = "SELECT s.salesId, u.username, m.medicineName, s.batchNo, m.medicineId, s.quantity, s.price, s.expiryDate, s.checkOutDate, s.systemDateTime FROM Sales s INNER JOIN Medicines m ON s.medicineId = m.medicineId INNER JOIN Users u ON s.entryBy=u.userId where salesId=?";
        try {
            return this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(SalesDto.class), id);
        } catch (Exception e) {
            return new SalesDto();
        }
    }

    @Override
    public int updateSales(SalesDto updateSalesDto) {
        int flag = 0;
        String sql = "UPDATE sales SET medicineId=?, batchNo=?,quantity=?,price=?, expiryDate=?, checkOutDate=? WHERE salesId=?";
        try {
            flag = this.jt.update(sql, updateSalesDto.getMedicineId(), updateSalesDto.getBatchNo(),
                    updateSalesDto.getQuantity(),
                    updateSalesDto.getPrice(), updateSalesDto.getExpiryDate(), updateSalesDto.getCheckOutDate(),
                    updateSalesDto.getSalesId());
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

}
