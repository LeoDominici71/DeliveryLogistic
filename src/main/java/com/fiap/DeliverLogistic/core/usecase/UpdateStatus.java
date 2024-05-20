package com.fiap.DeliverLogistic.core.usecase;

import java.util.logging.Logger;

import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;

public class UpdateStatus {

	private static final Logger LOGGER = Logger.getLogger(UpdateStatus.class.getName());

	private final CourierRepository courierRepository;

	public UpdateStatus(CourierRepository courierRepository) {
		this.courierRepository = courierRepository;

	}

	public Courier courierUpdate(Long id, Courier status) {
		LOGGER.info("IN - Getting online process");
		Courier pastCourier = courierRepository.getCourierById(id);
		if (pastCourier.getOnline() && status.getOnline().equals(true)) {
			throw new IllegalArgumentException("You are already online");
		}
		return courierRepository.updateStatus(id, status);
	}

}
