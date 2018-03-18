package br.com.vanhack.vanhackorders.service;

import br.com.vanhack.vanhackorders.security.Authentication;
import br.com.vanhack.vanhackorders.service.exception.BusinessException;

public interface IAuthenticationService {

	public String authenticate(Authentication user) throws BusinessException;
}
