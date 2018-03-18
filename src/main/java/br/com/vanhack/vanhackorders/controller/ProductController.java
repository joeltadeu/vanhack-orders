package br.com.vanhack.vanhackorders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.dto.ProductDto;
import br.com.vanhack.vanhackorders.service.IProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	IProductService productService;

	@GetMapping("/Product")
	public List<ProductDto> getAllProducts() {
		return productService.findAll();
	}

	@GetMapping("/Product/{productId}")
	public ProductDto getProductById(@PathVariable(value = "productId") Long storeId) {
		return productService.findOne(storeId);
	}

	@GetMapping("/Product/search/{searchText}")
	public List<ProductDto> getProductsByNameOrDescription(@PathVariable("searchText") String name) {
		return productService.findByNameOrDescription(name);
	}
}
