package br.com.vanhack.vanhackorders.service;

import br.com.vanhack.vanhackorders.dto.OrderDto;

public interface IOrderService {

	public OrderDto findOne(Long orderId);

	public OrderDto cancel(Long orderId);

	public OrderDto save(OrderDto order);

}
