package br.com.vanhack.vanhackorders.service;

import java.util.List;

import br.com.vanhack.vanhackorders.dto.CousineDto;

public interface ICousineService {

	public List<CousineDto> findAll();
	public CousineDto findOne(Long id);
	public List<CousineDto> findByNameContaining(String name);
}
