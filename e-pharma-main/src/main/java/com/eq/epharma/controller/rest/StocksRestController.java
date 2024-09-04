package com.eq.epharma.controller.rest;

import com.eq.epharma.dto.MessageDto;
import com.eq.epharma.dto.StockDto;
import com.eq.epharma.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class StocksRestController {

    @Autowired
    StockService ss;

    @PostMapping("/stocks")
    public ResponseEntity<MessageDto> addStock(@RequestBody StockDto stockDto){
        MessageDto response = ss.addStock(stockDto);
        if (response.isStatus()){
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity <StockDto> searchStockById(@PathVariable int id){
        StockDto stocks = ss.searchStockById(id);
        if (stocks != null) {
            return ResponseEntity.ok().body(stocks);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<MessageDto> updateStock(@PathVariable int id, @RequestBody StockDto stockDto){
        stockDto.setStockId(id);
        MessageDto response = ss.updateStock(stockDto);
        if (response.isStatus()){
            return ResponseEntity.ok().body(response);
        }
        else {
            return ResponseEntity.badRequest().body(response);
        }
    }

}
