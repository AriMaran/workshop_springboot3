package com.maran.workshop.resources;

import com.maran.workshop.entities.Order;
import com.maran.workshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {

    @Autowired
    private OrderService service;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Parameter to inform GetMapping that requistion will accept id inside URL
    public ResponseEntity<Order> findById(@PathVariable Long id){ //To make Spring consider the parameter that will be received by URL, it is necessary to use @PathVariable
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj); //ResponseEntity.ok to indicate that was everything correct
    }

}
