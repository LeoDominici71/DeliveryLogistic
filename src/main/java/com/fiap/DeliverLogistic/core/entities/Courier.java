package com.fiap.DeliverLogistic.core.entities;

import java.util.List;
import java.util.Objects;

public class Courier {

	private Long courierid;
	private String name;
	private String email;
	private Boolean online;
	private Long timeOnline;
	private List<Pedidos> pedidos;
	
	public Courier() {
		super();
	}

	public Courier(Long courierid, String name, String email, Boolean online, Long timeOnline, List<Pedidos> pedidos) {
		super();
		this.courierid = courierid;
		this.name = name;
		this.email = email;
		this.online = online;
		this.timeOnline = timeOnline;
		this.pedidos = pedidos;
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

	@Override
	public int hashCode() {
		return Objects.hash(courierid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courier other = (Courier) obj;
		return Objects.equals(courierid, other.courierid);
	}
	
	

}