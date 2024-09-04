package com.eq.epharma.common.validation;

import java.util.HashMap;
import java.util.Map;

import com.eq.epharma.dto.StockDto;


import org.springframework.stereotype.Component;

@Component
public class StockValidation implements Validation<StockDto> {
 @Override
 public ValidationMessage validate(StockDto t){
    ValidationMessage vm=new ValidationMessage();
    vm.setHasErrors(false);
  
    Map<String,String> messages=new HashMap<>();
    if(t.getPrice()<=0){
    vm.setHasErrors(true);
        messages.put("Price","Cannot be negative or zero");
    }
    if(t.getQuantity()<=0){
        vm.setHasErrors(true);
      
        messages.put("Quantity","Cannot be negative or zero"); 
       }
       vm.setMessage(messages);;
       return vm;
    }
 
}
