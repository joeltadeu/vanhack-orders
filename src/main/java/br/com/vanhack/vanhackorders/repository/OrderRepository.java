package br.com.vanhack.vanhackorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vanhack.vanhackorders.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
