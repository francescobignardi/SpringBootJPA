package com.example.SpringBootJPA.checkpoint.service;

import com.example.SpringBootJPA.checkpoint.entity.Orders;
import com.example.SpringBootJPA.checkpoint.repository.OrdersRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    public OrdersRepository ordersRepository;

    public void insertOrder(Orders order){
        ordersRepository.save(order);
    }

    public Orders getOrderById(Integer id){
        return ordersRepository.findById(id).get();
    }

    public List<Orders> getAllOrders(){
        List<Orders> ordini = new ArrayList<Orders>();
        ordini.addAll(ordersRepository.findAll());
        return ordini;
    }

    public void deleteOrder(Integer id){
        ordersRepository.deleteById(id);
    }

    public void updateOrder (Orders order, Integer id){
        ordersRepository.deleteById(id);
        ordersRepository.save(order);
    }
}
