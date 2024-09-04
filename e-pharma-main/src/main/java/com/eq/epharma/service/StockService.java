package com.eq.epharma.service;

import com.eq.epharma.dto.StockDto;
import com.eq.epharma.dto.MessageDto;

public interface StockService {
    public MessageDto addStock(StockDto stockDto);

    public StockDto searchStockById(int id);

    public MessageDto updateStock(StockDto updateStockDto);

}
