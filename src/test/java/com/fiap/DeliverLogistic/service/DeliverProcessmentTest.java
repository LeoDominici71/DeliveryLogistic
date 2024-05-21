package com.fiap.DeliverLogistic.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.DeliverLogistic.core.GetOrdersList;
import com.fiap.DeliverLogistic.core.UpdateOrders;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;
import com.fiap.DeliverLogistic.core.usecase.DeliverProcessment;
import com.fiap.DeliverLogistic.core.usecase.DesignateDeliver;
import com.fiap.DeliverLogistic.core.usecase.GetAllCouriersByTimeOnline;
import com.fiap.DeliverLogistic.factory.Factory;

@SpringBootTest
public class DeliverProcessmentTest {

	@InjectMocks
	private DeliverProcessment service;

	@Mock
	private GetOrdersList getOrders;
	@Mock
	private UpdateOrders updateOrders;
	@Mock
	private DesignateDeliver designate;
	@Mock
	private GetAllCouriersByTimeOnline getCouriers;

	@Test
	public void testDeliverProcessment() {
		// Arrange
		Courier courier = new Courier();
		courier.setCourierid(1L);
		courier.setName("Leo");
		courier.setEmail("leo@gamil.com");
		courier.setOnline(true);
		courier.setTimeOnline(12232323213L);
		List<Courier> couriers = new ArrayList<>();
		couriers.add(courier);
		Pedidos pedido = Factory.createPedidos();
		List<Pedidos> pedidos = new ArrayList<>();
		pedidos.add(pedido);
		Map<Integer, List<Pedidos>> map = new HashMap<>();
		map.put(0, pedidos);
		List<Map<Integer, List<Pedidos>>> orderedHashMaps = new ArrayList<>();
		orderedHashMaps.add(map);
		// Act
		Mockito.when(getOrders.getOrders()).thenReturn(pedidos);
		Assertions.assertDoesNotThrow(() -> {
			updateOrders.updateOrderStatus(orderedHashMaps);
		});
		Mockito.when(getCouriers.listAllCourierByTimeOnline()).thenReturn(couriers);
		Assertions.assertDoesNotThrow(() -> {
			designate.courierUpdate(1L, pedidos);
		});

		service.deliverProcessment();

		verify(getOrders, times(1)).getOrders();
		verify(updateOrders, times(1)).updateOrderStatus(orderedHashMaps);
		verify(getCouriers, times(1)).listAllCourierByTimeOnline();
	}

}
