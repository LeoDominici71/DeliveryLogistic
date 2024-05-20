package com.fiap.DeliverLogistic.adapter.output.externalApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fiap.DeliverLogistic.adapters.input.entities.Orders;
import com.fiap.DeliverLogistic.core.UpdateOrders;
import com.fiap.DeliverLogistic.core.entities.Pedidos;
import com.fiap.DeliverLogistic.exception.GeneralClientSystemException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UpdateOrder implements UpdateOrders {

	@Autowired
	private RestTemplate restTemplate;
	// Constants
	public static final String AGUARDANDO_ENTREGA = "aguardando entrega";

	@Override
	public void updateOrderStatus(List<Map<Integer, List<Pedidos>>> listOrders) {
		// TODO Auto-generated method stub
		try {

			UpdateOrder.log.info("IN - orders save all");
			
			List<Pedidos> listSaveAll = new ArrayList<>();
			
			
			for (int i = 0; i < listOrders.size(); i++) {

				// Pegar o mapa correspondente na lista ordenada
				Map<Integer, List<Pedidos>> map = listOrders.get(i);

				 // Itera sobre os valores do mapa
	            for (List<Pedidos> pedidosParaEntregar : map.values()) {
	                // Adiciona todos os pedidos da lista ao listSaveAll
	                listSaveAll.addAll(pedidosParaEntregar);
	            }
			}
			
			for(Pedidos pedidos : listSaveAll ) {
				pedidos.setExpectedTimeToDeliver("today");
				pedidos.setLocalization("Fiap Package Center");
				pedidos.setStatus(AGUARDANDO_ENTREGA);
			}

			final String url = "http://localhost:8765/orderManagement/api/order/saveAll";

			// Definir os headers, se necessário
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");

			// Criar a entidade HTTP contendo a lista de pedidos e os headers
			HttpEntity<List<Pedidos>> request = new HttpEntity<>(listSaveAll, headers);

			// Fazer a chamada POST
			restTemplate.exchange(url, HttpMethod.POST, request, Void.class);

			UpdateOrder.log.info("OUT - orders list");


		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralClientSystemException("Error in accessing order registry");
		}
	}

}
