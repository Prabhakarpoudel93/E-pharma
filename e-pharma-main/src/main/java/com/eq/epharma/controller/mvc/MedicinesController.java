package com.eq.epharma.controller.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.service.MedicinesService;

@Controller
public class MedicinesController {

  @Autowired
  MedicinesService ms;

  @RequestMapping("/medicine")
  public String getMedicinePage(Model model) {
    MedicinesDto medicinesDto = new MedicinesDto();
    MessageDto messageDto =new MessageDto();
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("medicinesDto", medicinesDto);
    model.addAttribute("messageDto", messageDto);
    return "medicine.html";
  }

  @PostMapping("/addMedicine")
  public String addMedicine(@ModelAttribute("MedicineDto") MedicinesDto medicinesDto, Model model) {
    System.out.println(medicinesDto);
    MessageDto messageDto = ms.addMedicines(medicinesDto);
    model.addAttribute("messageDto", messageDto);
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("medicinesDto", medicinesDto);
    return "medicine.html";
  }

  @RequestMapping("/getMedicineById/{id}")
  public @ResponseBody MedicinesDto getUserById(@PathVariable int id) {
    MedicinesDto medicine = ms.findByMedicineId(id);
    return medicine;
  }

  @PostMapping("/updateMedicine")
  public String updateMedicine(MedicinesDto medicinesDtoUpdate, Model model) {
    System.out.println(medicinesDtoUpdate);
    ms.updateMedicine(medicinesDtoUpdate);
    List<MedicinesDto> medicinesDtoList = ms.getAllMedicines().get();
    MedicinesDto medicinesDto = new MedicinesDto();
    model.addAttribute("medicinesDtoList", medicinesDtoList);
    model.addAttribute("medicinesDto", medicinesDto);
    return "medicine.html";
  }

  @GetMapping("/medicines")
  public @ResponseBody List<MedicinesDto> getAllMedicines(){
    return  ms.getAllMedicines().get();
  }

}
