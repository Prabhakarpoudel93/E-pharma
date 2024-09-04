package com.eq.epharma.service;

import com.eq.epharma.common.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eq.epharma.common.LoggedUser;
import com.eq.epharma.common.validation.Validation;
import com.eq.epharma.common.validation.ValidationMessage;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.SalesAuditDto;
import com.eq.epharma.dto.SalesDto;
import com.eq.epharma.repo.SalesAuditRepo;
import com.eq.epharma.repo.SalesRepo;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    SalesRepo sr;

    @Autowired
    SalesAuditRepo sar;

    @Autowired
    LoggedUser lu;

    @Autowired
    Validation<SalesDto> salesValidation;
    @Autowired
    Validation<List<SalesDto>> salesMedicationQuantityValidation;

    @Override
    public MessageDto addSales(SalesDto salesDto) {
        salesDto.setEntryBy(lu.getUserId());
        salesDto.setSalesId(sr.getMaxSalesId() + 1);
        MessageDto md = new MessageDto("Failed", false);
        ValidationMessage vm = salesValidation.validate(salesDto);
        md.setVm(vm);
        if (vm.hasErrors()) {
            return md;
        }
        int result = sr.addSales(salesDto);

        if (result > 0) {
            md.setMessage("Sales Added");
            md.setStatus(true);
        }

        return md;
    }

    @Override
    public MessageDto addSalesInBulk(List<SalesDto> salesDto) {
        MessageDto md = new MessageDto("Failed", false);
        ValidationMessage vm;
        for (SalesDto sd : salesDto) {// Executing validation for each SalesDto
            try {
                sd.setExpiryDate(DateUtils.formatDate(sd.getExpiryDate()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return md;
            }
            vm = salesValidation.validate(sd);
            md.setVm(vm);
            if (vm.hasErrors()) {
                return md;
            }
            vm = salesMedicationQuantityValidation.validate(salesDto);
            md.setVm(vm);
            if (vm.hasErrors()) {
                return md;
            }
        }

        int billId = sr.getMaxBillId() + 1;
        Date checkOutDate = salesDto.get(0).getCheckOutDate();
        for (SalesDto sd : salesDto) {// Saving each SalesDto
            try {
                sd.setExpiryDate(DateUtils.formatDate(sd.getExpiryDate()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return md;
            }
            sd.setEntryBy(lu.getUserId());
            sd.setSalesId(sr.getMaxSalesId() + 1);
            sd.setBillId(billId);
            sd.setCheckOutDate(checkOutDate);
            int result = sr.addSales(sd);

            if (result > 0) {
                md.setMessage("Sales Added");
                md.setStatus(true);
            }
        }
        md.setCommon(billId);
        return md;
    }

    @Override
    public SalesDto searchSalesById(int id) {
        return sr.searchSalesById(id);
    }

    @Override
    public MessageDto updateSales(SalesDto updateSalesDto) {
        int flag = 0;
        MessageDto md = new MessageDto("failed", false);
        SalesDto existingSales = sr.searchSalesById(updateSalesDto.getSalesId());
        SalesAuditDto sad = new SalesAuditDto();
        sad.setAuditBy(lu.getUserId());
        sad.setAuditType("EDIT");
        sad.setCheckOutDate(existingSales.getCheckOutDate());
        sad.setEntryBy(existingSales.getEntryBy());
        sad.setMedicineId(existingSales.getMedicineId());
        sad.setPrice(existingSales.getPrice());
        sad.setQuantity(existingSales.getQuantity());
        sad.setSalesId(existingSales.getSalesId());
        sad.setBatchNo(existingSales.getBatchNo());
        sad.setExpiryDate(existingSales.getExpiryDate());
        sar.addSalesAudit(sad);
        flag = sr.updateSales(updateSalesDto);
        if (flag > 0) {
            md.setMessage("User Updated Successfully");
            md.setStatus(true);
        }
        return md;
    }
}
