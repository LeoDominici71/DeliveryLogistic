package com.fiap.DeliverLogistic.adapter.output.externalApi;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fiap.DeliverLogistic.adapters.input.entities.Orders;
import com.fiap.DeliverLogistic.core.UpdateOrderById;
import com.fiap.DeliverLogistic.core.entities.OrderRequestUpdate;
import com.fiap.DeliverLogistic.core.usecase.DeliverProcessment;
import com.fiap.DeliverLogistic.exception.GeneralClientSystemException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UpdateOrdersById implements UpdateOrderById {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = Logger.getLogger(DeliverProcessment.class.getName());

	@Override
	public void updateOrderById(Long id, OrderRequestUpdate update) {
		// TODO Auto-generated method stub
		try {
			UpdateOrdersById.log.info("IN - update order by id");

			final String url = "http://localhost:8765/orderManagement/api/order/atualiza/{id}";

			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("id", id.toString());

			HttpEntity<OrderRequestUpdate> requestEntity = new HttpEntity<>(update);

			restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Orders.class, uriVariables);

			UpdateOrdersById.log.info("OUT - update order by id");

		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralClientSystemException("Error updating order by id");
		}
	}
}
