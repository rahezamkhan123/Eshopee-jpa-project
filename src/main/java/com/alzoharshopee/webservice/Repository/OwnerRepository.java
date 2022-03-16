package com.alzoharshopee.webservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alzoharshopee.webservice.Entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

	@Query(value = "select * from shopee_owner o where o.name like %:name%", nativeQuery = true)
	List<Owner> findByName(String name);

}
