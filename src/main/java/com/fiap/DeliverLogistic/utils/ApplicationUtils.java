package com.fiap.DeliverLogistic.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fiap.DeliverLogistic.adapters.input.entities.CourierResponse;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierStatusRequest;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierUpdate;
import com.fiap.DeliverLogistic.adapters.input.entities.Orders;
import com.fiap.DeliverLogistic.adapters.input.entities.PedidosResponse;
import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.CourierEntity;
import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.PedidosEntity;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;

public class ApplicationUtils {

	public static Courier toCourier(CourierEntity courierEntity) {
		Courier courier = new Courier();
		courier.setCourierid(courierEntity.getCourierid());
		if (courierEntity.getPedidos() != null) {
			courier.setDeliver(
					courierEntity.getPedidos().stream().map(ApplicationUtils::toPedidos).collect(Collectors.toList()));
		}
		courier.setEmail(courierEntity.getEmail());
		courier.setName(courierEntity.getName());
		courier.setOnline(courierEntity.getOnline());
		if (courierEntity.getTimeOnline() != null) {
			courier.setTimeOnline(courierEntity.getTimeOnline());
		}
		return courier;
	}

	public static Courier toCourier(CourierUpdate courierEntity) {
		Courier courier = new Courier();

		if (courierEntity.getEmail() != null) {
			courier.setEmail(courierEntity.getEmail());
		}

		if (courierEntity.getName() != null) {
			courier.setName(courierEntity.getName());
		}

		return courier;
	}

	public static Courier toCourier(CourierStatusRequest courierStatus) {
		Courier courier = new Courier();

		courier.setOnline(courierStatus.getOnline());

		return courier;
	}

	public static CourierEntity toCourierEntity(Courier courier) {
		CourierEntity courierEntity = new CourierEntity();
		if (courier.getCourierid() != null) {
			courierEntity.setCourierid(courier.getCourierid());
		}
		if (courier.getPedidos() != null) {
			courierEntity.setPedidos(
					courier.getPedidos().stream().map(ApplicationUtils::toPedidosEntity).collect(Collectors.toList()));
		}
		if (courier.getEmail() != null) {
			courierEntity.setEmail(courier.getEmail());
		}
		if (courier.getName() != null) {
			courierEntity.setName(courier.getName());
		}
		if (courier.getOnline() != null) {
			courierEntity.setOnline(courier.getOnline());
		}
		if (courier.getTimeOnline() != null) {
			courierEntity.setTimeOnline(courier.getTimeOnline());
		}

		return courierEntity;
	}

	public static CourierResponse toCourierResponse(Courier courier) {
		CourierResponse courierEntity = new CourierResponse();
		courierEntity.setCourierid(courier.getCourierid());
		courierEntity.setEmail(courier.getEmail());
		courierEntity.setName(courier.getName());
		
		courierEntity.setOnline(courier.getOnline());
		if (courier.getTimeOnline() != null) {
			courierEntity.setTimeOnline(courier.getTimeOnline());
		}
		if (courier.getPedidos() != null) {
			courierEntity.setPedidos(courier.getPedidos().stream().map(ApplicationUtils::pedidostoPedidosResponse)
					.collect(Collectors.toList()));
		}

		return courierEntity;
	}

	public static CourierEntity updateCourier(CourierEntity past, CourierEntity current) {
		if (current.getEmail() != null) {
			past.setEmail(current.getEmail());
		}

		if (current.getName() != null) {
			past.setName(current.getName());
		}
		return past;
	}

	public static CourierEntity updateStatus(CourierEntity past, Courier current) {
		past.setOnline(current.getOnline());
		if (current.getOnline().equals(true)) {
			past.setTimeOnline(System.currentTimeMillis());
		} else if (current.getOnline().equals(false)) {
			past.setTimeOnline(null);

		}
		return past;
	}

	public static CourierEntity updateDeliver(CourierEntity past, List<PedidosEntity> pedidos) {
		past.setPedidos(pedidos);
		return past;
	}

	public static Pedidos toPedidos(PedidosEntity entity) {
		Pedidos pedidos = new Pedidos();
		pedidos.setCity(entity.getCity());
		pedidos.setStatus(entity.getStatus());
		pedidos.setComplement(entity.getComplement());
		pedidos.setDistrict(entity.getDistrict());
		pedidos.setLocalization(entity.getLocalization());
		pedidos.setExpectedTimeToDeliver(entity.getExpectedTimeToDeliver());
		pedidos.setId(entity.getId());
		pedidos.setQuantity(entity.getQuantity());
		pedidos.setStreet(entity.getStreet());
		pedidos.setUserName(entity.getUserName());
		pedidos.setZipCode(entity.getZipCode());
		return pedidos;
	}

	public static PedidosEntity toPedidosEntity(Pedidos pedidos) {
		PedidosEntity entity = new PedidosEntity();
		entity.setCity(pedidos.getCity());
		entity.setComplement(pedidos.getComplement());
		entity.setDistrict(pedidos.getDistrict());
		entity.setStatus(pedidos.getStatus());
		entity.setLocalization(pedidos.getLocalization());
		entity.setExpectedTimeToDeliver(pedidos.getExpectedTimeToDeliver());
		entity.setId(pedidos.getId());
		entity.setQuantity(pedidos.getQuantity());
		entity.setStreet(pedidos.getStreet());
		entity.setUserName(pedidos.getUserName());
		entity.setZipCode(pedidos.getZipCode());
		return entity;
	}

	public static PedidosResponse pedidosEntitytoPedidosResponse(PedidosEntity entity) {
		PedidosResponse pedidosResponse = new PedidosResponse();
		pedidosResponse.setCity(entity.getCity());
		pedidosResponse.setStatus(entity.getStatus());
		pedidosResponse.setComplement(entity.getComplement());
		pedidosResponse.setDistrict(entity.getDistrict());
		pedidosResponse.setLocalization(entity.getLocalization());
		pedidosResponse.setExpectedTimeToDeliver(entity.getExpectedTimeToDeliver());
		pedidosResponse.setId(entity.getId());
		pedidosResponse.setQuantity(entity.getQuantity());
		pedidosResponse.setStreet(entity.getStreet());
		pedidosResponse.setUserName(entity.getUserName());
		pedidosResponse.setZipCode(entity.getZipCode());
		return pedidosResponse;
	}

	public static PedidosResponse pedidostoPedidosResponse(Pedidos pedidos) {
		PedidosResponse pedidosResponse = new PedidosResponse();
		pedidosResponse.setCity(pedidos.getCity());
		pedidosResponse.setComplement(pedidos.getComplement());
		pedidosResponse.setDistrict(pedidos.getDistrict());
		pedidosResponse.setStatus(pedidos.getStatus());
		pedidosResponse.setLocalization(pedidos.getLocalization());
		pedidosResponse.setExpectedTimeToDeliver(pedidos.getExpectedTimeToDeliver());
		pedidosResponse.setId(pedidos.getId());
		pedidosResponse.setQuantity(pedidos.getQuantity());
		pedidosResponse.setStreet(pedidos.getStreet());
		pedidosResponse.setUserName(pedidos.getUserName());
		pedidosResponse.setZipCode(pedidos.getZipCode());
		return pedidosResponse;
	}

	public static Pedidos convertOrderToPedido(Orders order) {
		Pedidos pedido = new Pedidos();
		pedido.setId(order.getId());
		pedido.setUserName(order.getUserName());
		pedido.setZipCode(order.getZipCode());
		pedido.setStatus(order.getStatus());
		pedido.setCity(order.getCity());
		pedido.setDistrict(order.getDistrict());
		pedido.setStreet(order.getStreet());
		pedido.setComplement(order.getComplement());
		pedido.setExpectedTimeToDeliver(order.getExpectedTimeToDeliver());
		pedido.setLocalization(order.getLocalization());
		pedido.setDate(LocalDate.now());
		pedido.setQuantity(order.getProducts() != null ? order.getProducts().size() : 0);
		return pedido;
	}

}
