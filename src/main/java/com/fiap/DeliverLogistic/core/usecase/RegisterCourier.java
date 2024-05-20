package com.fiap.DeliverLogistic.core.usecase;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class RegisterCourier {

	private final CourierRepository courierRepository;

	public RegisterCourier(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public Courier courierRegistry(Courier courier) {
		return courierRepository.courierRegistry(courier);
	}

}
