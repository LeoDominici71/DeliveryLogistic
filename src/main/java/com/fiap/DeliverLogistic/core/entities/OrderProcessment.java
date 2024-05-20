package com.fiap.DeliverLogistic.core.entities;

import java.util.List;

public class OrderProcessment {

	private List<Courier> couriers;
	private List<Pedidos> pedidos;
	private String expectdTimeToDeliver;

	public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public String getExpectdTimeToDeliver() {
		return expectdTimeToDeliver;
	}

	public void setExpectdTimeToDeliver(String expectdTimeToDeliver) {
		this.expectdTimeToDeliver = expectdTimeToDeliver;
	}

}
