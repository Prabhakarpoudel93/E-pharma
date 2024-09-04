package com.eq.epharma.service;

import com.eq.epharma.common.LoggedUser;
import com.eq.epharma.common.validation.Validation;
import com.eq.epharma.common.validation.ValidationMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eq.epharma.dto.StockDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.StockAuditDto;
import com.eq.epharma.repo.StockAuditRepo;
import com.eq.epharma.repo.StockRepo;

@Service

public class StockServiceImpl implements StockService {

    @Autowired
    StockRepo sr;

    @Autowired
    StockAuditRepo sar;

    @Autowired
    LoggedUser lu;

    @Autowired
    Validation<StockDto> stockValidation;

    @Override
    public MessageDto addStock(StockDto stockDto) {
        stockDto.setStockId(sr.getMaxStockId() + 1);
        stockDto.setEntryBy(lu.getUserId());

        MessageDto md = new MessageDto("Failed", false);
        ValidationMessage vm = stockValidation.validate(stockDto);
        md.setVm(vm);
        if (vm.hasErrors()) {
            return md;
        }
        int result = sr.addStock(stockDto);

        if (result > 0) {
            md.setMessage("Stock Added ");
            md.setStatus(true);
        }
        return md;
    }

    @Override
    public StockDto searchStockById(int id) {
        return sr.searchStockById(id);
    }

    @Override
    public MessageDto updateStock(StockDto updateStockDto) {
        int flag = 0;
        MessageDto md = new MessageDto("failed", false);
        StockDto existingStock = sr.searchStockById(updateStockDto.getStockId());
        StockAuditDto sad = new StockAuditDto();
        sad.setAuditBy(lu.getUserId());
        sad.setAuditType("EDIT");
        sad.setCheckInDate(existingStock.getCheckInDate());
        sad.setEntryBy(existingStock.getEntryBy());
        sad.setMedicineId(existingStock.getMedicineId());
        sad.setPrice(existingStock.getPrice());
        sad.setQuantity(existingStock.getQuantity());
        sad.setStockId(existingStock.getStockId());
        sad.setBatchNo(existingStock.getBatchNo());
        sad.setExpiryDate(existingStock.getExpiryDate());
        sar.addStockAudit(sad);
        flag = sr.updateStock(updateStockDto);
        if (flag > 0) {
            md.setMessage("Stock Updated Successfully");
            md.setStatus(true);
        }
        return md;
    }

}
