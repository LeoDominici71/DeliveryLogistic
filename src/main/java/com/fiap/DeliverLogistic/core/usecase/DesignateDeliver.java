package com.fiap.DeliverLogistic.core.usecase;

import java.util.List;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;

public class DesignateDeliver {
	
	private final CourierRepository courierRepository;

	public DesignateDeliver(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public Courier courierUpdate(Long id, List<Pedidos> pedidos) {
		return courierRepository.designateDeliver(id, pedidos);
	}


}
