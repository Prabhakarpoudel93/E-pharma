package com.eq.epharma.repo;

import com.eq.epharma.dto.SalesDto;

public interface SalesRepo {
    public int addSales(SalesDto sales);

    public int getMaxSalesId();

    public int getMaxBillId();

    public SalesDto searchSalesById(int id);

    public int updateSales(SalesDto updateSalesDto);

}
