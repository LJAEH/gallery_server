package org.ljaeh.boook.backend.repository;

import java.util.List;

import org.ljaeh.boook.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByIdIn(List<Integer> ids);
}
