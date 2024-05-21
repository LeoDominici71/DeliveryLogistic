package com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_orders")
@Getter
@Setter
@NoArgsConstructor
public class PedidosEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String zipCode;
	private String status;
	private String city;
	private String district;
	private String street;
	private String complement;
	private String localization;
	private String expectedTimeToDeliver;
	private Integer quantity;
	@ManyToOne
    @JoinColumn(name = "courier_id")
	@JsonIgnore
	private CourierEntity courier;

	

}
