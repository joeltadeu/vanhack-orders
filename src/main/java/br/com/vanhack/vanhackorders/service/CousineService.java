package br.com.vanhack.vanhackorders.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.dto.CousineDto;
import br.com.vanhack.vanhackorders.model.Cousine;
import br.com.vanhack.vanhackorders.repository.CousineRepository;

@Service
public class CousineService implements ICousineService {

	@Autowired
	CousineRepository cousineRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override

	public List<CousineDto> findAll() {
		List<Cousine> cousines = cousineRepository.findAll();
		return convertToListDto(cousines);
	}

	@Override
	public CousineDto findOne(Long id) {
		Cousine cousine = cousineRepository.findOne(id);
		return convertToDto(cousine);
	}

	@Override
	public List<CousineDto> findByNameContaining(String name) {
		List<Cousine> cousines = cousineRepository.findByNameContaining(name);
		return convertToListDto(cousines);
	}
	
	private CousineDto convertToDto(Cousine cousine) {
		CousineDto cousineDto = modelMapper.map(cousine, CousineDto.class);
		return cousineDto;
	}

	private List<CousineDto> convertToListDto(List<Cousine> cousines) {
		return cousines.stream().map(cousine -> convertToDto(cousine)).collect(Collectors.toList());
	}

}
