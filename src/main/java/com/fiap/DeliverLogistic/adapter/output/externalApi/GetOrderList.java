package com.fiap.DeliverLogistic.adapter.output.externalApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fiap.DeliverLogistic.adapters.input.entities.Orders;
import com.fiap.DeliverLogistic.core.GetOrdersList;
import com.fiap.DeliverLogistic.core.entities.Pedidos;
import com.fiap.DeliverLogistic.exception.GeneralClientSystemException;
import com.fiap.DeliverLogistic.utils.ApplicationUtils;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class GetOrderList implements GetOrdersList{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Pedidos> getOrders() {
		// TODO Auto-generated method stub
		try {

			GetOrderList.log.info("IN - orders list");


		    final String url = "http://localhost:8765/orderManagement/api/order/ordersByStatus?status=confirmado";
	        Orders[] pedidosArray = restTemplate.getForObject(url, Orders[].class);
            List<Orders> ordersList = new ArrayList<>(Arrays.asList(pedidosArray));

			GetOrderList.log.info("OUT - orders list");

			return ordersList.stream().map(ApplicationUtils::convertOrderToPedido).collect(Collectors.toList());

		} catch (Exception e) {
			e.getStackTrace();
			throw new GeneralClientSystemException("Error in accessing order registry");
		}
	}

}
