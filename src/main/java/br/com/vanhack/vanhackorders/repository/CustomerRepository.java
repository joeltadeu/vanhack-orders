package br.com.vanhack.vanhackorders.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vanhack.vanhackorders.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Optional<Customer> findByEmailAndPassword(String email, String password);

	public Customer findByEmail(String email);
}
