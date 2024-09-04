package com.eq.epharma.service;

import com.eq.epharma.dto.BillsDto;
import com.eq.epharma.dto.MessageDto;

import java.util.List;

public interface BillsService {
    public MessageDto addBills(BillsDto billsDto);
    public List<BillsDto> getBillsById(int id);
}
