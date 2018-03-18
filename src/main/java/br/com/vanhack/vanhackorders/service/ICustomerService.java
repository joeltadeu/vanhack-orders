package br.com.vanhack.vanhackorders.service;

import java.util.List;

import br.com.vanhack.vanhackorders.dto.CustomerDto;

public interface ICustomerService {

	public List<CustomerDto> findAll();

	public String save(CustomerDto customer);
	
	public CustomerDto findOne(Long id);
}
