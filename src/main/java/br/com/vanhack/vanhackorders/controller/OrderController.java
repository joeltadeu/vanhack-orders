package br.com.vanhack.vanhackorders.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vanhack.vanhackorders.dto.OrderDto;
import br.com.vanhack.vanhackorders.service.IOrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@GetMapping("/Order/{id}")
	public OrderDto getOrderById(@PathVariable(value = "id") Long orderId) {
		OrderDto order = orderService.findOne(orderId);
		return order;
	}

	@GetMapping("/Order/status/{id}")
	public String getOrderStatus(@PathVariable(value = "id") Long orderId) {
		OrderDto order = orderService.findOne(orderId);
		return order.getStatus();
	}

	@PutMapping("/Order/cancel/{id}")
	public OrderDto updateOrder(@PathVariable(value = "id") @Valid Long orderId) {
		OrderDto updatedOrder = orderService.cancel(orderId);
		return updatedOrder;
	}

	@PostMapping("/Order") 
	public OrderDto createOrder(@Valid @RequestBody OrderDto order) {
		return orderService.save(order);
	}
}
