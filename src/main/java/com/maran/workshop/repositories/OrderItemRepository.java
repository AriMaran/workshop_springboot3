package com.maran.workshop.repositories;

import com.maran.workshop.entities.Order;
import com.maran.workshop.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

//not needed @Repository, because extends JpaRepository. @Repository is optional.
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
