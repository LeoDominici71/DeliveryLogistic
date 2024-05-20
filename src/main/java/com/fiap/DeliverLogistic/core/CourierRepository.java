package com.fiap.DeliverLogistic.core;

import java.util.List;

import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;

public interface CourierRepository {

	Courier courierRegistry(Courier courier);

	List<Courier> listAllCourier();

	Courier getCourierById(Long id);

	void deleteCourier(Long id);

	Courier updateCourier(Long id, Courier courier);

	List<Courier> listAllCourierByTimeOnline();

	Courier updateStatus(Long id, Courier status);

	Courier designateDeliver(Long id, List<Pedidos> pedidos);

}
