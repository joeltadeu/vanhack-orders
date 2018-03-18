package br.com.vanhack.vanhackorders.service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.dto.CustomerDto;
import br.com.vanhack.vanhackorders.model.Customer;
import br.com.vanhack.vanhackorders.repository.CustomerRepository;
import br.com.vanhack.vanhackorders.security.Token;
import br.com.vanhack.vanhackorders.service.exception.ParseEntityException;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	Token token;

	@Override

	public List<CustomerDto> findAll() {
		List<Customer> customers = customerRepository.findAll();
		return convertToListDto(customers);
	}

	@Override
	public CustomerDto findOne(Long id) {
		Customer customer = customerRepository.findOne(id);
		return convertToDto(customer);
	}

	@Override
	public String save(CustomerDto customerDto) {
		Customer customer;
		try {
			customer = convertToEntity(customerDto);
		} catch (ParseException e) {
			throw new ParseEntityException("Error to parse CustomerDto to Customer");
		}
		customerRepository.save(customer);
		return token.generate(customer.getEmail());
	}

	private CustomerDto convertToDto(Customer customer) {
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}

	private List<CustomerDto> convertToListDto(List<Customer> customers) {
		return customers.stream().map(customer -> convertToDto(customer)).collect(Collectors.toList());
	}

	private Customer convertToEntity(CustomerDto customerDto) throws ParseException {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		if (customer.getId() != null && customer.getId().equals(0L)) {
			customer.setId(null);
		}
		return customer;
	}
}
