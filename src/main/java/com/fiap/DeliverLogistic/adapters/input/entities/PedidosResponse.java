package com.fiap.DeliverLogistic.adapters.input.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidosResponse {
	
	private Long id;
	private String userName;
	private String zipCode;
	private String status;
	private String city;
	private String district;
	private String street;
	private String complement;
	private String expectedTimeToDeliver;
	private String localization;
	private Integer quantity;

	

}
