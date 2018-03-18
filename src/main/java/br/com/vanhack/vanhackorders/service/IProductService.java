package br.com.vanhack.vanhackorders.service;

import java.util.List;

import br.com.vanhack.vanhackorders.dto.ProductDto;

public interface IProductService {

	public List<ProductDto> findAll();
	public ProductDto findOne(Long id);
	public List<ProductDto> findByNameOrDescription(String name);
}
