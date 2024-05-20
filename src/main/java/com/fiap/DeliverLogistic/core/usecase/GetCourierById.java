package com.fiap.DeliverLogistic.core.usecase;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class GetCourierById {

	private final CourierRepository courierRepository;

	public GetCourierById(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}
	
	public Courier getCourierById(Long id) {
		return courierRepository.getCourierById(id);
	}

}
