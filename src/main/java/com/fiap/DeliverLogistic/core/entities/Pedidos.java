package com.fiap.DeliverLogistic.core.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pedidos {

	private Long id;
	private String userName;
	private String status;
	private String zipCode;
	private String city;
	private String district;
	private String street;
	private String complement;
	private String expectedTimeToDeliver;
	private String localization;
	private Integer quantity;
	private LocalDate date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getExpectedTimeToDeliver() {
		return expectedTimeToDeliver;
	}
	public void setExpectedTimeToDeliver(String expectedTimeToDeliver) {
		this.expectedTimeToDeliver = expectedTimeToDeliver;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Pedidos() {
		super();
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedidos other = (Pedidos) obj;
		return Objects.equals(id, other.id);
	}
	
	

}