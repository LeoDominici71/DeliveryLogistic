package com.fiap.DeliverLogistic.adapters.input.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
public class CourierResponse {
	
	private Long courierid;
	private String name;
	private String email;
	private Boolean online;
	private Long timeOnline;
	private List<PedidosResponse> pedidos;

}
