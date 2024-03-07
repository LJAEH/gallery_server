package org.ljaeh.boook.backend.repository;

import java.util.List;

import org.ljaeh.boook.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	List<Cart> findByMemberId(int memberId);
	Cart findByMemberIdAndItemId(int memberId , int itemId);
	
}
