package com.fiap.DeliverLogistic.core.entities;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class Courier {

	private Long courierid;
	@NotNull
	private String name;
	@NotNull
	private String email;
	private Boolean online;
	private Long timeOnline;
	private List<Pedidos> pedidos;
	
	public Courier() {
		super();
	}

	public Long getCourierid() {
		return courierid;
	}

	public void setCourierid(Long courierid) {
		this.courierid = courierid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Long getTimeOnline() {
		return timeOnline;
	}

	public void setTimeOnline(Long timeOnline) {
		this.timeOnline = timeOnline;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setDeliver(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

}