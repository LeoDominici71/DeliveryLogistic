package com.fiap.DeliverLogistic.adapters.input.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Products {
	
	
	private Long id;
	private Long productCode;
	private String name;
	private String description;
	private String stock;
	private Double price;
	
	private List<Orders> order;

}
