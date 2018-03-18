package br.com.vanhack.vanhackorders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vanhack.vanhackorders.model.Cousine;

@Repository
public interface CousineRepository extends JpaRepository<Cousine, Long>{
	public List<Cousine> findByNameContaining(String name);
}
