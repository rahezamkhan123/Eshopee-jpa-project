package com.alzoharshopee.webservice.Controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alzoharshopee.webservice.Entity.Owner;
import com.alzoharshopee.webservice.Entity.ShopRegistration;
import com.alzoharshopee.webservice.Exception.OwnerNotFound;
import com.alzoharshopee.webservice.Exception.ShopRegistrationNotFound;
import com.alzoharshopee.webservice.Repository.ShopRegistrationRepository;
import com.alzoharshopee.webservice.services.MailService;

@RestController
@RequestMapping("api")
public class ShopRegistrationController {

	@Autowired
	ShopRegistrationRepository shopRepo;

	@Autowired
	MailService mailsender;

	@GetMapping("/shopbyname")
	public List<ShopRegistration> getShopByName(@RequestParam("name") String name) {
		List<ShopRegistration> list = shopRepo.findByName(name);
		if (list != null) {
			return list;
		}
		throw new ShopRegistrationNotFound("shop not found by given name = " + name);
	}

	@GetMapping("/registerlist")
	public List<ShopRegistration> getAllResgister() {
		List<ShopRegistration> list = shopRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new ShopRegistrationNotFound("registration list is empty , zero records Found !");
	}

	@GetMapping("/shop/{id}")
	public Optional<ShopRegistration> getShopRegistrationById(@PathVariable("id") long id) {
		Optional<ShopRegistration> shop = shopRepo.findById(id);
		if (shop != null) {
			return shop;
		}
		throw new ShopRegistrationNotFound("Shop not found by give id =" + id);
	}

	@PostMapping("/register")
	public ShopRegistration addShop(@RequestBody ShopRegistration shopRegistration) throws MessagingException {
		ShopRegistration shopData = shopRepo.save(shopRegistration);
		if (shopData != null) {
			mailsender.send(shopData.getOwner().getEmail(), "rahezamkhan18@gmail.com",
					"The shop registration is successfully",
					"lkasdjfoiuoriljfkvljslfjalkfjsiajrlfkm fj aiwjrlfksvlkj rwru pflisjvnisjg alsijfipssjlkksajfkljoiww oiiijfsdoilnail4urofslv ");
		}
		return shopData;
	}

	@PutMapping("/register")
	public Map<String, String> updateShop(@RequestBody ShopRegistration shopRegistration) {
		ShopRegistration rowsAffected = shopRepo.save(shopRegistration);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Shop registration updated successfully !");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@DeleteMapping("/register/{id}")
	public String deleteShop(@PathVariable("id") long id) {
		shopRepo.deleteById(id);
		return "Shop Deleted Successfully -----------";
	}

	@GetMapping("/activeshop")
	public List<ShopRegistration> getActiveOwners() {
		List<ShopRegistration> list = shopRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new OwnerNotFound("Active Shop list is empty , zero records Found !");
	}

	@GetMapping("/inactiveshop")
	public List<ShopRegistration> getInActiveOwners() {
		List<ShopRegistration> list = shopRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new OwnerNotFound("InActive Shop list is empty , zero records Found !");
	}

}
