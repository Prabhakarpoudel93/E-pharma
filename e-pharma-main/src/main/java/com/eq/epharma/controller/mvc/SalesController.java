package com.eq.epharma.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import com.eq.epharma.common.validation.ValidationMessage;
import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.service.MedicinesService;
import com.eq.epharma.service.SalesService;

@Controller
public class SalesController {
  @Autowired
  SalesService ss;

  @Autowired
  MedicinesService ms;

  @RequestMapping("/sales")
  public String getSalesPage(Model model) {
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();

    model.addAttribute("salesDto", new SalesDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("messageDto", new MessageDto(new ValidationMessage()));

    return "sales.html";
  }

  @PostMapping("/addSales")
  public String addSales(SalesDto salesDto, Model model) {
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    MessageDto messageDto = ss.addSales(salesDto);
    model.addAttribute("messageDto", messageDto);
    model.addAttribute("salesDto", new SalesDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("isSalesAdded", true);
    return "sales.html";
  }


  @PostMapping("/addSalesInBulk")
  public @ResponseBody MessageDto addSalesInBulk(@RequestBody List<SalesDto> salesDto) {
    salesDto.remove(0);
    MessageDto messageDto = null;
    try {
      messageDto = ss.addSalesInBulk(salesDto);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return messageDto;
  }


  @PostMapping("/searchBySalesId")
  public @ResponseBody SalesDto searchSalesById(@RequestParam(name = "salesId") int id) {
    return ss.searchSalesById(id);
  }

  @PostMapping("/updateSales")
  public String updateStock(SalesDto updateSalesDto, Model model) {
    System.out.println(updateSalesDto);
    ss.updateSales(updateSalesDto);
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();

    model.addAttribute("salesDto", new SalesDto());
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("messageDto", new MessageDto(new ValidationMessage()));

    return "sales.html";
  }
}
