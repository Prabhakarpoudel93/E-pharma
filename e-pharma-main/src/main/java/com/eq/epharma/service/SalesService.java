package com.eq.epharma.service;

import com.eq.epharma.dto.MedicinesDto;
import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.SalesDto;

import java.util.List;

public interface SalesService {
    public MessageDto addSales(SalesDto salesDto);

    public MessageDto addSalesInBulk(List<SalesDto> salesDto) throws Exception;

    public SalesDto searchSalesById(int id);

    public MessageDto updateSales(SalesDto updateSalesDto);

}
