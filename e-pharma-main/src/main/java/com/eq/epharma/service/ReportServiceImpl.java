package com.eq.epharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eq.epharma.dto.ReportDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.dto.StockDto;
import com.eq.epharma.dto.AvlStockDto;

import com.eq.epharma.repo.ReportRepo;

import java.util.List;



@Service
public class ReportServiceImpl implements ReportService {

@Autowired
ReportRepo rr;
    public List<SalesDto> getSalesReport(ReportDto reportDto) {
                 
            return rr.getSalesByDate(reportDto);
        
        
            
        
    }

    public List<StockDto> getStockReport(ReportDto reportDto) {
                
          return rr.getStockByDate(reportDto);
           
        
    }

    @Override
    public List<AvlStockDto> getAvlStock() {
       return rr.getAvlStock();
    }


    

}
    