package com.fiap.DeliverLogistic.core.usecase;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class UpdateCourier {
	
	private final CourierRepository courierRepository;

	public UpdateCourier(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public Courier courierUpdate(Long id, Courier courier) {
		return courierRepository.updateCourier(id, courier);
	}

}
