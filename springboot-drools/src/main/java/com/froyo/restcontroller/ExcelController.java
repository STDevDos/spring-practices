package com.froyo.restcontroller;

import com.froyo.dto.Order;
import com.froyo.service.ExcelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    private final ExcelService excelService;

    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/order")
    public Order order(@RequestBody Order order) {
        excelService.getDiscount(order);
        return order;
    }

}
