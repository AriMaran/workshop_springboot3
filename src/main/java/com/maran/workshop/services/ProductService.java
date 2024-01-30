package com.maran.workshop.services;

import com.maran.workshop.entities.Product;
import com.maran.workshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //register class as spring component. @Component for general.
public class ProductService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductRepository repository;


    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
