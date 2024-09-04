package com.eq.epharma.common.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eq.epharma.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eq.epharma.dto.AvlStockInBatchDto;
import com.eq.epharma.dto.SalesDto;

@Component
public class SalesValidation implements Validation<SalesDto> {

    @Autowired
    StockRepo sr;

    @Override
    public ValidationMessage validate(SalesDto t) {
        ValidationMessage vm = new ValidationMessage();
        vm.setHasErrors(false);
        Map<String, String> messages = new HashMap<>();
        if (t.getPrice() <= 0) {
            vm.setHasErrors(true);
            messages.put("Price", "Cannot be negative or zero");
        }
        if (t.getQuantity() <= 0) {
            vm.setHasErrors(true);
            messages.put("Quantity", "Cannot be negative or zero");
        }
        // TODO: Rename getAvlStockByBatchNoAndExpiryDate to
        // getAvlStockByBatchNoAndExpiryDateAndMedicineId
        List<AvlStockInBatchDto> asibd = sr.getAvlStockByBatchNoAndExpiryDate(t.getBatchNo(), t.getExpiryDate(),
                t.getMedicineId());

        if (asibd != null && asibd.size() == 0) {
            vm.setHasErrors(true);
            messages.put("Invalid BatchNo/ExpiryDate", "BatchNo or ExpiryDate does not match with stock");
        }
        vm.setMessage(messages);
        ;
        return vm;
    }

}
