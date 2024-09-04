package com.eq.epharma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eq.epharma.dto.BillsDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.repo.BillsRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillsServiceImpl implements BillsService{
    @Autowired
    BillsRepo br;

    @Override
    public MessageDto addBills(BillsDto billsDto) {
        billsDto.setBillId(br.getMaxBillsId()+1);
        MessageDto md=new MessageDto("Bills Added Successfully",true);
        return md;
    }


    @Override
    public List<BillsDto> getBillsById(int id) {

        List<BillsDto> dto= br.getBillsById(id);

        int sumOfQuantity = dto.stream().mapToInt(BillsDto::getQuantity).sum();
        double sumOfPrice = dto.stream().mapToDouble(BillsDto::getPrice).sum();

        dto.forEach(d->{
            d.setTotalQuantity(sumOfQuantity);
            d.setTotalPrice(sumOfPrice);
        });

        return dto;
    }
}
