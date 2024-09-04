package com.eq.epharma.repo;

import com.eq.epharma.dto.BillsDto;

import java.util.List;

public interface BillsRepo {
    public int addBills(BillsDto bill);
    public int getMaxBillsId();
    public List<BillsDto> getBillsById(int id);
}
