package com.fiap.DeliverLogistic.core.usecase;

import com.fiap.DeliverLogistic.core.CourierRepository;

public class DeleteCourier {
	
	private final CourierRepository courierRepository;

	public DeleteCourier(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public void deleteCourier(Long id) {
		courierRepository.deleteCourier(id);
	}

}
