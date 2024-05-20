package com.fiap.DeliverLogistic.adapters.output.h2dataBase.repository.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.CourierEntity;
import com.fiap.DeliverLogistic.adapters.output.h2dataBase.repository.CourierJpaRepository;
import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.entities.Pedidos;
import com.fiap.DeliverLogistic.utils.ApplicationUtils;

import jakarta.persistence.EntityNotFoundException;

@Component
public class CourierRepositoryImpl implements CourierRepository {

	private final CourierJpaRepository repository;

	@Autowired
	public CourierRepositoryImpl(CourierJpaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Courier courierRegistry(Courier courier) {
		// TODO Auto-generated method stub
		CourierEntity courierEntity = ApplicationUtils.toCourierEntity(courier);
		courierEntity.setOnline(false);
		return ApplicationUtils.toCourier(repository.save(courierEntity));
	}

	@Override
	public List<Courier> listAllCourier() {
		// TODO Auto-generated method stub
		return repository.findAll().stream().map(courier -> ApplicationUtils.toCourier(courier))
				.collect(Collectors.toList());
	}

	@Override
	public Courier getCourierById(Long id) {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourier = repository.findById(id);
		CourierEntity courier = optionalCourier.orElseThrow(() -> new EntityNotFoundException("Courier not found"));
		return ApplicationUtils.toCourier(courier);
	}

	@Override
	public void deleteCourier(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public Courier updateCourier(Long id, Courier courier) {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourier = repository.findById(id);
		CourierEntity pastCourier = optionalCourier.orElseThrow(() -> new EntityNotFoundException("Courier not found"));
		CourierEntity courierUpdated = ApplicationUtils.updateCourier(pastCourier,
				ApplicationUtils.toCourierEntity(courier));
		repository.save(courierUpdated);
		return ApplicationUtils.toCourier(courierUpdated);
	}

	@Override
	public List<Courier> listAllCourierByTimeOnline() {
		// TODO Auto-generated method stub
		return repository.findAllCourierByTimeOnlineAsc().stream().map(courier -> ApplicationUtils.toCourier(courier))
				.collect(Collectors.toList());

	}

	@Override
	public Courier updateStatus(Long id, Courier status) {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourier = repository.findById(id);
		CourierEntity pastCourier = optionalCourier.orElseThrow(() -> new EntityNotFoundException("Courier not found"));
		CourierEntity courierUpdated = ApplicationUtils.updateStatus(pastCourier, status);
		repository.save(courierUpdated);
		return ApplicationUtils.toCourier(courierUpdated);
	}

	@Override
	public Courier designateDeliver(Long id, List<Pedidos> pedidos) {
		// TODO Auto-generated method stub
		Optional<CourierEntity> optionalCourier = repository.findById(id);
		CourierEntity pastCourier = optionalCourier.orElseThrow(() -> new EntityNotFoundException("Courier not found"));
		pastCourier.setPedidos(
				pedidos.stream().map(pedido -> ApplicationUtils.toPedidosEntity(pedido)).collect(Collectors.toList()));
		CourierEntity courierUpdated = repository.save(pastCourier);

		return ApplicationUtils.toCourier(courierUpdated);
	}

}
