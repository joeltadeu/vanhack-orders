package br.com.vanhack.vanhackorders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.model.Customer;
import br.com.vanhack.vanhackorders.repository.CustomerRepository;
import br.com.vanhack.vanhackorders.security.Authentication;
import br.com.vanhack.vanhackorders.security.Token;
import br.com.vanhack.vanhackorders.service.exception.BusinessException;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	Token token;

	private static final String ERROR_MESSAGE = "\"error\": \"User and Password not found.\"";

	@Override
	public String authenticate(Authentication user) throws BusinessException {

		if (user.getEmail() == null || user.getPassword() == null) {
			throw new BusinessException(ERROR_MESSAGE);
		}

		String email = user.getEmail();
		String password = user.getPassword();

		Customer customer = customerRepository.findByEmail(email);

		if (customer == null) {
			throw new BusinessException(ERROR_MESSAGE);
		}

		String pwd = customer.getPassword();

		if (!password.equals(pwd)) {
			throw new BusinessException(ERROR_MESSAGE);
		}

		return token.generate(email);
	}

}
