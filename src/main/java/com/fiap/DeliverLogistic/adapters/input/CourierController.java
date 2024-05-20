package com.fiap.DeliverLogistic.adapters.input;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.DeliverLogistic.adapters.input.entities.CourierResponse;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierStatusRequest;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierUpdate;
import com.fiap.DeliverLogistic.core.entities.Courier;
import com.fiap.DeliverLogistic.core.usecase.DeleteCourier;
import com.fiap.DeliverLogistic.core.usecase.DeliverProcessment;
import com.fiap.DeliverLogistic.core.usecase.DeliverUpdate;
import com.fiap.DeliverLogistic.core.usecase.GetAllCouriersByTimeOnline;
import com.fiap.DeliverLogistic.core.usecase.GetCourierById;
import com.fiap.DeliverLogistic.core.usecase.ListAllCourier;
import com.fiap.DeliverLogistic.core.usecase.RegisterCourier;
import com.fiap.DeliverLogistic.core.usecase.UpdateCourier;
import com.fiap.DeliverLogistic.core.usecase.UpdateStatus;
import com.fiap.DeliverLogistic.utils.ApplicationUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/courier")
@Slf4j
public class CourierController {

	private final DeleteCourier deleteCourier;
	private final GetAllCouriersByTimeOnline getCouriersByTimeOnline;
	private final GetCourierById getCouriersById;
	private final ListAllCourier listAllCourier;
	private final RegisterCourier registerCourier;
	private final UpdateCourier updateCourier;
	private final UpdateStatus updateStatus;
	private final DeliverUpdate deliverUpdate;
	private final DeliverProcessment processment;


	public CourierController(DeleteCourier deleteCourier,DeliverProcessment processment, GetAllCouriersByTimeOnline getCouriersByTimeOnline,
			GetCourierById getCouriersById, ListAllCourier listAllCourier, RegisterCourier registerCourier,
			UpdateCourier updateCourier, UpdateStatus updateStatus, DeliverUpdate deliverUpdate) {
		this.deleteCourier = deleteCourier;
		this.getCouriersByTimeOnline = getCouriersByTimeOnline;
		this.getCouriersById = getCouriersById;
		this.listAllCourier = listAllCourier;
		this.registerCourier = registerCourier;
		this.updateCourier = updateCourier;
		this.updateStatus = updateStatus;
		this.deliverUpdate = deliverUpdate;
		this.processment = processment;
	}

	@GetMapping
	public ResponseEntity<List<CourierResponse>> listAllCourier() {
		CourierController.log.info("IN - get courier list");
		List<Courier> couriers = listAllCourier.listAllCourier();
		List<CourierResponse> couriersList = couriers.stream()
				.map(courier -> ApplicationUtils.toCourierResponse(courier)).collect(Collectors.toList());
		CourierController.log.info("OUT - get courier list");
		return ResponseEntity.ok().body(couriersList);

	}

	@GetMapping("/listCourierByTimeOnline")
	public ResponseEntity<List<CourierResponse>> listAllCouriersByTimeOnline() {
		CourierController.log.info("IN - get courier list by time online");
		List<Courier> couriers = getCouriersByTimeOnline.listAllCourierByTimeOnline();
		List<CourierResponse> couriersList = couriers.stream()
				.map(courierResponse -> ApplicationUtils.toCourierResponse(courierResponse))
				.collect(Collectors.toList());
		CourierController.log.info("OUT - get courier list by time online");
		return ResponseEntity.ok().body(couriersList);

	}

	@GetMapping("/{id}")
	public ResponseEntity<CourierResponse> getCourierById(@PathVariable Long id) {
		CourierController.log.info("IN - get courier by id");
		Courier courier = getCouriersById.getCourierById(id);
		CourierController.log.info("OUT - get courier by id");
		return ResponseEntity.ok().body(ApplicationUtils.toCourierResponse(courier));

	}

	@PostMapping
	public ResponseEntity<CourierResponse> courierRegistry(@RequestBody Courier courier) {
		CourierController.log.info("IN - register courier");
		Courier courierSaved = registerCourier.courierRegistry(courier);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(courier.getCourierid())
				.toUri();
		CourierController.log.info("OUT - register courier");
		return ResponseEntity.created(uri).body(ApplicationUtils.toCourierResponse(courierSaved));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCourier(@PathVariable Long id) {
		CourierController.log.info("IN - delete courier");
		deleteCourier.deleteCourier(id);
		CourierController.log.info("OUT - delete courier");
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping("/updateCourier/{id}")
	public ResponseEntity<CourierResponse> updateCourier(@PathVariable Long id, @RequestBody CourierUpdate courier){
		CourierController.log.info("IN - update courier");
		Courier courierUpdate = updateCourier.courierUpdate(id, ApplicationUtils.toCourier(courier));
		CourierController.log.info("OUT - update courier");
		return ResponseEntity.ok().body(ApplicationUtils.toCourierResponse(courierUpdate));

	}
	
	@PutMapping("/updateStatus/{id}")
	public ResponseEntity<CourierResponse> updateStatus(@PathVariable Long id, @RequestBody CourierStatusRequest courier){
		CourierController.log.info("IN - update courier");
		Courier courierUpdate = updateStatus.courierUpdate(id, ApplicationUtils.toCourier(courier));
		CourierController.log.info("OUT - update courier");
		return ResponseEntity.ok().body(ApplicationUtils.toCourierResponse(courierUpdate));

	}
	
	@PutMapping("/updateDeliver/{id}")
	public ResponseEntity<CourierResponse> updateDeliver(@PathVariable Long id){
		CourierController.log.info("IN - update deliver");
		deliverUpdate.updateDeliver(id);
		CourierController.log.info("OUT - update deliver");
		return ResponseEntity.noContent().build();

	}
	
	@GetMapping("/deliverProcessment")
	public ResponseEntity<List<CourierResponse>> processDeliverToCouriers() {
		CourierController.log.info("IN - process delivers");
		processment.deliverProcessment();
		CourierController.log.info("OUT - process delivers");
		return ResponseEntity.noContent().build();

	}

}
