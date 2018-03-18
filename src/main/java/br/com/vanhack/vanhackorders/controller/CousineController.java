package br.com.vanhack.vanhackorders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.dto.CousineDto;
import br.com.vanhack.vanhackorders.dto.StoreDto;
import br.com.vanhack.vanhackorders.service.ICousineService;
import br.com.vanhack.vanhackorders.service.IStoreService;

@RestController
@RequestMapping("/api/v1")
public class CousineController {

	@Autowired
	ICousineService cousineService;

	@Autowired
	IStoreService storeService;
	
	@GetMapping("/Cousine")
	public List<CousineDto> getAllStories() {
		return cousineService.findAll();
	}

	@GetMapping("/Cousine/{cousineId}/stores")
	public List<StoreDto> getStoresByCousineId(@PathVariable(value = "cousineId") Long cousineId) {
		return storeService.findByCousine(cousineId);
	}

	@GetMapping("/Cousine/search/{searchText}")
	public List<CousineDto> getCousinesByName(@PathVariable("searchText") String name) {
		return cousineService.findByNameContaining(name);
	}
}
