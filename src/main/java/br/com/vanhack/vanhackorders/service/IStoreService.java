package br.com.vanhack.vanhackorders.service;

import java.util.List;

import br.com.vanhack.vanhackorders.dto.StoreDto;

public interface IStoreService {

	public List<StoreDto> findAll();
	public StoreDto findOne(Long id);
	public List<StoreDto> findByNameContaining(String name);
	public List<StoreDto> findByCousine(Long cousineId);
}
