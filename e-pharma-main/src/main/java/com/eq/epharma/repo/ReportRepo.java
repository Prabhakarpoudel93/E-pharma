package com.eq.epharma.repo;
import java.util.List;

import com.eq.epharma.dto.*;

public interface ReportRepo {
    public List<SalesDto> getSalesByDate(ReportDto report);
    public List<StockDto> getStockByDate(ReportDto report);
    public List<AvlStockDto> getAvlStock();
    public AvlStockDto getAvlStockByMedicineId(int medicationId);
    public List<AvlStockInBatchDto> getAvlStockAccordingToBatchNoAndExpiryDate();
}



