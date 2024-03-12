package org.ljaeh.boook.backend.repository;

import org.ljaeh.boook.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
}
