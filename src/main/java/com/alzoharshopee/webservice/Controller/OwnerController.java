package com.alzoharshopee.webservice.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.alzoharshopee.webservice.Exception.OwnerNotFound;
import com.alzoharshopee.webservice.Repository.OwnerRepository;

@RestController
@RequestMapping("api")
public class OwnerController {

	@Autowired
	OwnerRepository ownerRepo;

	@GetMapping("/owner")
	public List<Owner> getOwnerByName(@RequestParam("name") String name) {
		List<Owner> list = ownerRepo.findByName(name);
		if (list != null) {
			return list;
		}
		throw new OwnerNotFound("Owner not found by ginven name = " + name);
	}

	@GetMapping("/owners")
	public List<Owner> getAllOwner() {
		List<Owner> list = ownerRepo.findAll();
		if (list != null) {
			return list;

		}
		throw new OwnerNotFound("owner list is empty , zero records Found !");
	}

	@GetMapping("/owner/{id}")
	public Owner getOwnerById(@PathVariable("id") long id) {
		Owner owner = ownerRepo.getById(id);
		if (owner != null) {
			return owner;
		}
		throw new OwnerNotFound("Owner Not found with given id = " + id);
	}

	@PostMapping("/owner")
	public Owner addOwner(@RequestBody Owner owner) {
		return ownerRepo.save(owner);
	}

	@PutMapping("/owners")
	public Map<String, String> updateEmployee(@RequestBody Owner owner) {
		Owner rowsAffected = ownerRepo.save(owner);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Owner updated successfully !");
		response.put("rowsAffected", String.valueOf(rowsAffected));
		return response;
	}

	@DeleteMapping("/owner/{id}")
	public String deleteOwner(@PathVariable("id") long id) {
		ownerRepo.deleteById(id);
		return "Owner Deleted Successfully -----------";
	}

	@GetMapping("/activeowns")
	public List<Owner> getActiveOwners() {
		List<Owner> list = ownerRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new OwnerNotFound("Active Owner list is empty , zero records Found !");
	}

	@GetMapping("/inactiveowns")
	public List<Owner> getInActiveOwners() {
		List<Owner> list = ownerRepo.findAll();
		if (list != null) {
			return list;
		}
		throw new OwnerNotFound("InActive Owner list is empty , zero records Found !");
	}
}
