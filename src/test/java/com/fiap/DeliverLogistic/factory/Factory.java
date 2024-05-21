package com.fiap.DeliverLogistic.factory;

import com.fiap.DeliverLogistic.adapters.input.entities.Courier;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierStatusRequest;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierUpdate;
import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.CourierEntity;
import com.fiap.DeliverLogistic.core.entities.Pedidos;

public class Factory {
	
	public static Courier createCourier() {
		Courier courier = new Courier();
		courier.setEmail("leo@gmail.com");
		courier.setName("Leonardo");
		
		return courier;
	}
	
	public static CourierUpdate createCourierUpdate() {
		CourierUpdate courier = new CourierUpdate();
		courier.setEmail("leo@gmail.com");
		courier.setName("Leo");
		
		return courier;
	}
	
	public static CourierStatusRequest createStatusUpdate() {
		CourierStatusRequest courier = new CourierStatusRequest();
		courier.setOnline(true);
		
		return courier;
	}
	
	public static Courier createCourierSemEmail() {
		Courier courier = new Courier();
		courier.setName("Leonardo");
		
		return courier;
	}
	
	public static CourierEntity createCourierEntity() {
		CourierEntity courier = new CourierEntity();
		courier.setEmail("leo@gmail.com");
		courier.setName("Leonardo");
		courier.setOnline(false);
		return courier;
	}
	
	public static Pedidos createPedidos() {
		Pedidos pedidos = new Pedidos();
		pedidos.setCity("Praia Grande");
		pedidos.setComplement("ap");
		pedidos.setDistrict("Guilhermina");
		pedidos.setExpectedTimeToDeliver("today");
		pedidos.setLocalization("Hub Fiap center");
		pedidos.setQuantity(2);
		pedidos.setStatus("Aguardando entrega");
		pedidos.setStreet("itarare");
		pedidos.setUserName("Leonardo");
		pedidos.setZipCode("11701-620");
		return pedidos;
	}

}
