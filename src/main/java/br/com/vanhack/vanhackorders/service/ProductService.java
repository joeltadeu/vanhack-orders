package br.com.vanhack.vanhackorders.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.dto.ProductDto;
import br.com.vanhack.vanhackorders.model.Product;
import br.com.vanhack.vanhackorders.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override

	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		return convertToListDto(products);
	}

	@Override
	public ProductDto findOne(Long id) {
		Product product = productRepository.findOne(id);
		return convertToDto(product);
	}

	@Override
	public List<ProductDto> findByNameOrDescription(String name) {
		List<Product> products = productRepository.findByNameOrDescription(name);
		return convertToListDto(products);
	}

	private ProductDto convertToDto(Product product) {
		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	private List<ProductDto> convertToListDto(List<Product> products) {
		return products.stream().map(product -> convertToDto(product)).collect(Collectors.toList());
	}

}
