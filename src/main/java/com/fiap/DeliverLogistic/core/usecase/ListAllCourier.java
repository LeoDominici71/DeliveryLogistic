package com.fiap.DeliverLogistic.core.usecase;

import java.util.List;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class ListAllCourier {

	private final CourierRepository courierRepository;

	public ListAllCourier(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public List<Courier> listAllCourier() {
		return courierRepository.listAllCourier();
	}

}
