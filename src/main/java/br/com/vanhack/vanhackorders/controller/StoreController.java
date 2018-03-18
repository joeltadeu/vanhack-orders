package br.com.vanhack.vanhackorders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.dto.StoreDto;
import br.com.vanhack.vanhackorders.service.IStoreService;

@RestController
@RequestMapping("/api/v1")
public class StoreController {

	@Autowired
	IStoreService storeService;

	@GetMapping("/Store")
	public List<StoreDto> getAllStories() {
		return storeService.findAll();
	}

	@GetMapping("/Store/{storeId}")
	public StoreDto getStoreById(@PathVariable(value = "storeId") Long storeId) {
		return storeService.findOne(storeId);
	}

	@GetMapping("/Store/search/{searchText}")
	public List<StoreDto> getStoresByName(@PathVariable("searchText") String name) {
		return storeService.findByNameContaining(name);
	}
}
