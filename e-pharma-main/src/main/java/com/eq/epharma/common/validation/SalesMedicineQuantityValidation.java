package com.eq.epharma.common.validation;

import com.eq.epharma.dto.AvlStockDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.repo.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class SalesMedicineQuantityValidation implements Validation<List<SalesDto>>{

    @Autowired
    ReportRepo rr;


    Map<Integer,Integer> quantityByMedicineId(List<SalesDto> salesDtoList) {
        Map<Integer, Integer> quantityByMedicineId = salesDtoList.stream()
                .collect(Collectors.groupingBy(SalesDto::getMedicineId,
                        Collectors.summingInt(SalesDto::getQuantity)));
        return quantityByMedicineId;
    }



    @Override
    public ValidationMessage validate(List<SalesDto> salesDtoList) {
        Map<Integer,Integer> quantityByMedicineId=quantityByMedicineId(salesDtoList);
        ValidationMessage vm=new ValidationMessage();
        vm.setHasErrors(false);
        Map<String,String> messages=new HashMap<>();
        quantityByMedicineId.forEach((medicineId, quantity)->{
            AvlStockDto avlStockDto=rr.getAvlStockByMedicineId(medicineId);
            if(avlStockDto.getMedicineId()==medicineId){
                if(avlStockDto.getAvailableStock()<quantity){
                    vm.setHasErrors(true);
                    messages.put("Medicine: "+avlStockDto.getMedicineName(),"is low on stock");
                }
            }
        });
        vm.setMessage(messages);;
        return vm;
    }
}
