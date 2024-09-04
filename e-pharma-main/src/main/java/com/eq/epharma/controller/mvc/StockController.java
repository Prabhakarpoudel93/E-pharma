package com.eq.epharma.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eq.epharma.common.validation.ValidationMessage;
import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.StockDto;
import com.eq.epharma.service.MedicinesService;
import com.eq.epharma.service.StockService;

@Controller
public class StockController {

  @Autowired
  StockService ss;

  @Autowired
  MedicinesService ms;

  @RequestMapping("/stock")
  public String getStockPage(Model model) {
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();

    model.addAttribute("stockDto", new StockDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("messageDto", new MessageDto(new ValidationMessage()));

    return "stock.html";
  }

  @PostMapping("/addStock")
  public String addStock(StockDto stockDto, Model model) {
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    MessageDto messageDto = ss.addStock(stockDto);
    model.addAttribute("messageDto", messageDto);
    model.addAttribute("stockDto", new StockDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    return "stock.html";
  }

  @PostMapping("/searchByStockId")
  public @ResponseBody StockDto searchStockById(@RequestParam(name = "stockId") int id) {
    StockDto stock = ss.searchStockById(id);
    System.out.println(stock.getCheckInDate());
    return stock;
  }

  @PostMapping("/updateStock")
  public String updateStock(StockDto updateStockDto, Model model) {
    System.out.println(updateStockDto);
    ss.updateStock(updateStockDto);
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    model.addAttribute("stockDto", new StockDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("messageDto", new MessageDto(new ValidationMessage()));

    return "stock.html";
  }

}
