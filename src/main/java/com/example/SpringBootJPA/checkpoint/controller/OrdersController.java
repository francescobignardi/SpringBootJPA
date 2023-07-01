package com.example.SpringBootJPA.checkpoint.controller;

import com.example.SpringBootJPA.checkpoint.entity.Orders;
import com.example.SpringBootJPA.checkpoint.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orders")
public class OrdersController {
    @Autowired
    public OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/insertOrder")
    public ResponseEntity<?> insertOrder(@RequestBody Orders order){
        ordersService.insertOrder(order);
        return ResponseEntity.ok("Ordine inserito");
    }

    @GetMapping("/findById/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable("orderId") Integer id){
        ordersService.getOrderById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllOrders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderId") Integer id){
        ordersService.deleteOrder(id);
        return ResponseEntity.ok("Ordine eliminato");
    }

    @PutMapping("/updateOrder/{orderId}")
    public ResponseEntity<?> updateOrder(@RequestBody Orders order, @PathVariable("orderId") Integer id){
        ordersService.updateOrder(order, id);
        return ResponseEntity.ok("Ordine modificato");
    }
}
