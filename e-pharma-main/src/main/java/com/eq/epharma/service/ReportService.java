package com.eq.epharma.service;

import java.util.List;

import com.eq.epharma.dto.AvlStockDto;
import com.eq.epharma.dto.ReportDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.dto.StockDto;

public interface ReportService {
    public List<SalesDto> getSalesReport(ReportDto reportDto);
    public List<StockDto> getStockReport(ReportDto reportDto);
    public List<AvlStockDto> getAvlStock();
}
