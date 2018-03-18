package br.com.vanhack.vanhackorders.service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vanhack.vanhackorders.dto.OrderDto;
import br.com.vanhack.vanhackorders.dto.OrderItemDto;
import br.com.vanhack.vanhackorders.model.Order;
import br.com.vanhack.vanhackorders.model.OrderItem;
import br.com.vanhack.vanhackorders.model.Product;
import br.com.vanhack.vanhackorders.model.StatusOrder;
import br.com.vanhack.vanhackorders.repository.OrderRepository;
import br.com.vanhack.vanhackorders.service.exception.ParseEntityException;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public OrderDto findOne(Long orderId) {
		Order order = orderRepository.findOne(orderId);
		return convertToOrderDto(order);
	}

	@Override
	public OrderDto cancel(Long orderId) {
		Order order = orderRepository.findOne(orderId);
		order.setStatus(StatusOrder.CANCELED);
		order.setLastUpdate(LocalDateTime.now());
		Order updatedOrder = orderRepository.saveAndFlush(order);
		return convertToOrderDto(updatedOrder);
	}

	@Override
	public OrderDto save(OrderDto orderDto) {
		Order order;
		try {
			order = convertToEntity(orderDto);
		} catch (ParseException e) {
			throw new ParseEntityException("Error to parse object");
		}
		orderRepository.save(order);
		return convertToOrderDto(order);
	}

	private OrderDto convertToOrderDto(Order order) {
		List<OrderItemDto> orderItems = order.getOrderItems().stream()
				.map(orderItem -> convertToOrderItemDto(orderItem)).collect(Collectors.toList());
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		orderDto.setDate(order.getCreation());
		orderDto.setOrderItems(orderItems);
		return orderDto;
	}

	private OrderItemDto convertToOrderItemDto(OrderItem orderItem) {
		return modelMapper.map(orderItem, OrderItemDto.class);
	}

	private Order convertToEntity(OrderDto orderDto) throws ParseException {
		orderDto.getOrderItems().stream().map(orderItemDto -> convertToOrderItemEntity(orderItemDto)).collect(Collectors.toList());
		Order order = modelMapper.map(orderDto, Order.class);
		if (order.getId() != null && order.getId().equals(0L)) {
			order.setId(null);
		}
		order.setCreation(orderDto.getDate());
		order.getOrderItems().forEach(entry -> {
			  entry.setOrder(order);
			  entry.setId(null);
			});
		
		return order;
	}

	private OrderItem convertToOrderItemEntity(OrderItemDto orderItemDto) {
		Product product = modelMapper.map(orderItemDto.getProduct(), Product.class);
		OrderItem orderItem = modelMapper.map(orderItemDto, OrderItem.class);
		orderItem.setProduct(product);
		return orderItem;
	}
}
