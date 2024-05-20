package com.fiap.DeliverLogistic.adapters.input.entities;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Orders {

	private Long id;
	private Long userId;
	private String status;
	private String userName;
	private String zipCode;
	private String city;
	private String district;
	private String street;
	private String complement;
	private String localization;
	private String expectedTimeToDeliver;
	private List<Products> products;

}
