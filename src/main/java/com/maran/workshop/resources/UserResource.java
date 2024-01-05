package com.maran.workshop.resources;

import com.maran.workshop.entities.User;
import com.maran.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Parameter to inform GetMapping that requistion will accept id inside URL
    public ResponseEntity<User> findById(@PathVariable Long id){ //To make Spring consider the parameter that will be received by URL, it is necessary to use @PathVariable
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj); //ResponseEntity.ok to indicate that was everything correct
    }

}
