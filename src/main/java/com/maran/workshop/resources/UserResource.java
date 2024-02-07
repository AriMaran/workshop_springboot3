package com.maran.workshop.resources;

import com.maran.workshop.entities.User;
import com.maran.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping //While @GetMapping is used for retrieving data, @PostMapping is used for inserting data into the database.
    public ResponseEntity<User> insert(@RequestBody User obj){

        /*To deserialize a JSON request body into a User object, you can use the @RequestBody annotation.
        This annotation tells Spring to convert the HTTP request body into an object of the specified class.
        */
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj); //The create method expects a URI format and the response is expected to contain a
                                                      // header with the new address of the inserted resource.
    }
    @DeleteMapping(value ="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); //return empty response. HTTP 204
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
        obj = service.update(id,obj);
        return ResponseEntity.ok(obj);
    }
}
