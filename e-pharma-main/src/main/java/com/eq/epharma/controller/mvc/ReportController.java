package com.eq.epharma.controller.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eq.epharma.dto.AvlStockDto;
import com.eq.epharma.dto.ReportDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.dto.StockDto;
import com.eq.epharma.service.ReportService;

@Controller
public class ReportController {

@Autowired
ReportService rs;

  @RequestMapping("/report")
  public String report() {
    return "report";
  }

  @RequestMapping("/get-report")
  public String getReport(ReportDto reportDto, Model model) {
    String reportPage=null;
    String reportType=reportDto.getReportType();
    List<StockDto> stocks=new ArrayList<>();
    List<SalesDto> sales=new ArrayList<>();
    if(reportType.equals ("sales")){
      sales=rs.getSalesReport(reportDto);
      model.addAttribute("salesDtoList", sales);
      reportPage="reports/salesReport.html";
     
    }else{
      stocks=rs.getStockReport(reportDto);
      model.addAttribute("stockDtoList", stocks);
      reportPage="reports/stockReport.html";
    }
    
    return reportPage;
  
  }


  @RequestMapping("/get-avl-stock")
  @ResponseBody
  public List<AvlStockDto> getAvlStock() {
    return rs.getAvlStock();
  }

}