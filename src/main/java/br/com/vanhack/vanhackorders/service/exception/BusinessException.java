package br.com.vanhack.vanhackorders.service.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1447330660517159248L;

	public BusinessException(String message) {
		super(message);
	}

}
