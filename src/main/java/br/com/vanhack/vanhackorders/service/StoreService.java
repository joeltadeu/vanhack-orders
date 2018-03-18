package br.com.vanhack.vanhackorders.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.dto.StoreDto;
import br.com.vanhack.vanhackorders.model.Store;
import br.com.vanhack.vanhackorders.repository.StoreRepository;

@Service
public class StoreService implements IStoreService {

	@Autowired
	StoreRepository storeRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override

	public List<StoreDto> findAll() {
		List<Store> stores = storeRepository.findAll();
		return convertToListDto(stores);
	}

	@Override
	public StoreDto findOne(Long id) {
		Store store = storeRepository.findOne(id);
		return convertToDto(store);
	}

	@Override
	public List<StoreDto> findByNameContaining(String name) {
		List<Store> stores = storeRepository.findByNameContaining(name);
		return convertToListDto(stores);
	}

	@Override
	public List<StoreDto> findByCousine(Long cousineId) {
		List<Store> stores = storeRepository.findByCousineId(cousineId);
		return convertToListDto(stores);
	}
	
	private StoreDto convertToDto(Store store) {
		StoreDto storeDto = modelMapper.map(store, StoreDto.class);
		return storeDto;
	}

	private List<StoreDto> convertToListDto(List<Store> stores) {
		return stores.stream().map(store -> convertToDto(store)).collect(Collectors.toList());
	}

	

}
