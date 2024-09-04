package com.eq.epharma.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eq.epharma.dto.BillsDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.service.BillsService;


import java.util.List;


@Controller
public class BillsController {
    @Autowired
    BillsService bs;

    @RequestMapping("/bill")
    public String getBillPage(){

        return "bill.html";
    }

    @RequestMapping("/bill/{id}")
    public String getBillPageById(@PathVariable int id, Model model){
        List<BillsDto> billsDto=bs.getBillsById(id);
        model.addAttribute("billsDto", billsDto);
        return "billDetail.html";
    }

  @PostMapping("/addBills")
  public String addBills(@ModelAttribute("BillsDto") BillsDto billsDto,Model model){
        System.out.println(billsDto);
        MessageDto messageDto=bs.addBills(billsDto);
        model.addAttribute("messageDto", messageDto);
        return "result.html";
    }
    
}
