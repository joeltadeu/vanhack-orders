package br.com.vanhack.vanhackorders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vanhack.vanhackorders.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
	public List<Store> findByNameContaining(String name);

	public List<Store> findByCousineId(Long cousineId);
}
