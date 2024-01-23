package com.maran.workshop.repositories;

import com.maran.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//not needed @Repository, because extends JpaRepository. @Repository is optional.
public interface OrderRepository extends JpaRepository<Order,Long> {

}
