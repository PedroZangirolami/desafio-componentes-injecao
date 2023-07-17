package com.devsuperior.order.services;

import com.devsuperior.order.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    @Autowired
    ShippingService shippingService;

   public Double total(Order order){
        Double totalDesconto = order.getBasic() - (order.getBasic() * (order.getDiscount()/100));
        return totalDesconto + shippingService.shipment(order);
   }
}
