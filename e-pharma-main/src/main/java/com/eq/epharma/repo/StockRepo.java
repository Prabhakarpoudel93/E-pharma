package com.eq.epharma.repo;

import com.eq.epharma.dto.AvlStockInBatchDto;
import com.eq.epharma.dto.StockDto;

import java.util.Date;
import java.util.List;

public interface StockRepo {
    public int addStock(StockDto stock);

    public int getMaxStockId();

    public StockDto searchStockById(int id);

    public int updateStock(StockDto updateStockDto);

    public List<String> getBatchNumbers();

    public List<AvlStockInBatchDto> getAvlStockByBatchNoAndExpiryDate(String batchNo, Date expiryDate, int medicineId);

}
