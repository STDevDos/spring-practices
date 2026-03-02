package com.froyo.service.impl;

import com.froyo.dto.Order;
import com.froyo.service.ExcelService;
import org.springframework.stereotype.Service;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public Order getDiscount(Order order) {
        // Dummy implementation
        if ("GOLD".equals(order.getCardType())) {
            order.setDiscount(10);
        } else {
            order.setDiscount(5);
        }
        return order;
    }
}
