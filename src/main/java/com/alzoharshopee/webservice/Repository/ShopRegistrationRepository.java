package com.alzoharshopee.webservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alzoharshopee.webservice.Entity.ShopRegistration;

@Repository
public interface ShopRegistrationRepository extends JpaRepository<ShopRegistration, Long> {

	List<ShopRegistration> findByName(String name);

}
