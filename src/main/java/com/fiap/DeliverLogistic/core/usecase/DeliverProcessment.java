package com.fiap.DeliverLogistic.core.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.fiap.DeliverLogistic.core.GetOrdersList;
import com.fiap.DeliverLogistic.core.UpdateOrders;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;
import com.fiap.DeliverLogistic.exception.GeneralClientSystemException;

public class DeliverProcessment {

	private final GetOrdersList getOrders;
	private final UpdateOrders updateOrders;
	private final DesignateDeliver designate;
	private final GetAllCouriersByTimeOnline getCouriers;

	private static final Logger log = Logger.getLogger(DeliverProcessment.class.getName());

	public DeliverProcessment(GetOrdersList getOrders, UpdateOrders updateOrders, DesignateDeliver designate,
			GetAllCouriersByTimeOnline getCouriers) {
		this.getOrders = getOrders;
		this.updateOrders = updateOrders;
		this.designate = designate;
		this.getCouriers = getCouriers;
	}

	public void deliverProcessment() {

		try {

			DeliverProcessment.log.info("IN - delivery processment");

			List<Pedidos> pedidos = getOrders.getOrders();
			
			Map<Integer, List<Pedidos>> separationBySubSector = new HashMap<>();

			for (Pedidos pedido : pedidos) {
				String cep = pedido.getZipCode();
				char quartoNumeroChar = cep.charAt(cep.length() - 4);
				int quartoNumero = Character.getNumericValue(quartoNumeroChar);

				if (separationBySubSector.containsKey(quartoNumero)) {
					List<Pedidos> pedidoList = separationBySubSector.get(quartoNumero);
					pedidoList.add(pedido);
				} else {
					List<Pedidos> novaLista = new ArrayList<>();
					novaLista.add(pedido);
					separationBySubSector.put(quartoNumero, novaLista);
				}

			}

			List<Map<Integer, List<Pedidos>>> orderedHashMaps = new ArrayList<>();

			// Ordenar o mapa pelo tamanho das listas de pedidos em ordem decrescente
			separationBySubSector.entrySet().stream()
					.sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
					.forEachOrdered(entry -> {
						// Adicionar o mapa ordenado ao ArrayList
						orderedHashMaps.add(new HashMap<>(Map.of(entry.getKey(), entry.getValue())));
					});

			// Update orders status
			updateOrders.updateOrderStatus(orderedHashMaps);

			// Catching couriers
			List<Courier> couriers = getCouriers.listAllCourierByTimeOnline();

			// Designar pedidos aos couriers
			for (int i = 0; i < couriers.size() && i < orderedHashMaps.size(); i++) {
				Courier courier = couriers.get(i);

				// Pegar o mapa correspondente na lista ordenada
				Map<Integer, List<Pedidos>> map = orderedHashMaps.get(i);

				// Pegar a lista de pedidos (único valor no mapa)
				List<Pedidos> pedidosParaEntregar = map.values().iterator().next();

				if (!pedidosParaEntregar.get(0).equals(null)) {
					// Designar pedidos ao courier
					designate.courierUpdate(courier.getCourierid(), pedidosParaEntregar);
				} else {
					DeliverProcessment.log.info("não há mais entregas");
					break;
				}
			}

			DeliverProcessment.log.info("OUT - delivery processment");

		} catch (Exception e) {
			e.printStackTrace();
			throw new GeneralClientSystemException("Error in accessing order registry");
		}
	}
}
