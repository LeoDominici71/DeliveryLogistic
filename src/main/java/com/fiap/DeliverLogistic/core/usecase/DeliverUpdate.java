package com.fiap.DeliverLogistic.core.usecase;

import java.util.logging.Logger;

import com.fiap.DeliverLogistic.adapter.output.externalApi.UpdateOrdersById;
import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.OrderRequestUpdate;
import com.fiap.DeliverLogistic.exception.GeneralClientSystemException;

public class DeliverUpdate {

	private final CourierRepository courierRepository;
	private final UpdateOrdersById updateOrder;

	public DeliverUpdate(CourierRepository courierRepository, UpdateOrdersById updateOrder) {
		this.courierRepository = courierRepository;
		this.updateOrder = updateOrder;

	}

	private static final Logger log = Logger.getLogger(DeliverProcessment.class.getName());

	public void updateDeliver(Long id) {
		
		try {
		Courier courier = courierRepository.getCourierById(id);
		OrderRequestUpdate update = new OrderRequestUpdate();

		for (int i = 0; i < courier.getPedidos().size();) {

			if (courier.getPedidos().get(i).getStatus().equals("aguardando entrega")) {
				update.setExpectedTimeToDeliver("Delivered");
				update.setStatus("Entregue");
				update.setLocalization(courier.getPedidos().get(i).getCity() + " "
						+ courier.getPedidos().get(i).getStreet());
				updateOrder.updateOrderById(courier.getPedidos().get(i).getId(), update);
				DeliverUpdate.log.info("sucess delivered");
				break;
			} else {
				throw new GeneralClientSystemException("Error in deliver order");

			}

		}

	}catch(Exception e) {
		throw new GeneralClientSystemException("Error in deliver order");
	}
	}

}
