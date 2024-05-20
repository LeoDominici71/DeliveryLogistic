package com.fiap.DeliverLogistic.core.usecase;

import java.util.List;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class GetAllCouriersByTimeOnline {

	private final CourierRepository courierRepository;

	public GetAllCouriersByTimeOnline(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}

	public List<Courier> listAllCourierByTimeOnline() {
		return courierRepository.listAllCourierByTimeOnline();
	}

}
