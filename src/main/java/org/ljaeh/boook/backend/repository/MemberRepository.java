package org.ljaeh.boook.backend.repository;

import org.ljaeh.boook.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	Member findByEmailAndPassword(String email, String password);

}
