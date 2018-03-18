package br.com.vanhack.vanhackorders.security;

import java.io.Serializable;

public class Authentication implements Serializable {

	private static final long serialVersionUID = 9039414612390294772L;

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
