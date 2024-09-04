package com.eq.epharma.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eq.epharma.dto.AvlStockInBatchDto;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.eq.epharma.dto.StockDto;

@Repository
public class StockRepoImpl implements StockRepo {
    private final JdbcTemplate jt;

    public StockRepoImpl(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public int addStock(StockDto stock) {
        int flag = 0;
        String sql = "insert into stock (stockId,medicineId,quantity,price,entryBy,CheckInDate,systemDateTime,expiryDate,batchNo) values (?,?,?,?,?,?,?,?,?)";
        try {
            flag = this.jt.update(sql, stock.getStockId(), stock.getMedicineId(), stock.getQuantity(), stock.getPrice(),
                    stock.getEntryBy(), stock.getCheckInDate(), new Date(), stock.getExpiryDate(), stock.getBatchNo());

        } catch (Exception e) {
            flag = 0;
        }
        return flag;

    }

    @Override
    public int getMaxStockId() {
        int maxStockId = 0;
        String sql = "select max(stockId) from stock";
        try {
            maxStockId = this.jt.queryForObject(sql, Integer.class);
        } catch (Exception e) {

        }
        return maxStockId;
    }

    @Override
    public StockDto searchStockById(int id) {
        String sql = "SELECT s.stockId, u.username, m.medicineName, m.medicineId, s.expiryDate, s.batchNo, s.quantity, s.price,s.checkInDate, s.systemDateTime FROM Stock s INNER JOIN Medicines m ON s.medicineId = m.medicineId INNER JOIN Users u ON s.entryBy=u.userId where s.stockId=?";

        try {
            return this.jt.queryForObject(sql, BeanPropertyRowMapper.newInstance(StockDto.class), id);
        } catch (Exception e) {
            return new StockDto();
        }
    }

    @Override
    public int updateStock(StockDto updateStockDto) {
        int flag = 0;
        String sql = "UPDATE stock SET medicineId=?,quantity=?,price=?, checkInDate=?, batchNo=?, expiryDate=? WHERE stockId=?";
        try {
            flag = this.jt.update(sql, updateStockDto.getMedicineId(), updateStockDto.getQuantity(),
                    updateStockDto.getPrice(), updateStockDto.getCheckInDate(), updateStockDto.getBatchNo(),
                    updateStockDto.getExpiryDate(), updateStockDto.getStockId());
        } catch (Exception e) {
            flag = 0;
        }
        return flag;
    }

    @Override
    public List<String> getBatchNumbers() {
        String sql = "select distinct batchNo from stock";
        List<String> batchNumbers = null;
        try {
            batchNumbers = this.jt.queryForList(sql, String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return batchNumbers;
    }

    @Override
    public List<AvlStockInBatchDto> getAvlStockByBatchNoAndExpiryDate(String batchNo, Date expiryDate, int medicineId) {
        String sql = """
                SELECT m.medicineName, m.medicineId,
                s.batchNo,\s
                s.expiryDate,\s
                s.quantity - COALESCE(sa.soldQuantity, 0) AS avlStock\s
                FROM stock s\s
                INNER JOIN medicines m ON s.medicineId = m.medicineId
                LEFT JOIN (
                SELECT medicineId, batchNo, expiryDate, SUM(quantity) AS soldQuantity\s
                FROM sales\s
                GROUP BY medicineId, batchNo, expiryDate
                ) sa\s
                ON s.medicineId = sa.medicineId\s
                AND s.batchNo = sa.batchNo\s
                AND s.expiryDate = sa.expiryDate where s.batchNo=? and s.expiryDate=? and m.medicineId=?;
                """;
        List<AvlStockInBatchDto> avlStock = null;
        try {
            avlStock = this.jt.query(sql, BeanPropertyRowMapper.newInstance(AvlStockInBatchDto.class), batchNo,
                    expiryDate, medicineId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return avlStock;
    }
}
