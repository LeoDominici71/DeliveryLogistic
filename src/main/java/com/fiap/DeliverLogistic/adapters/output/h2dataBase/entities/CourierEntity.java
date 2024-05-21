package com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities;

import java.util.List;

import com.fiap.DeliverLogistic.core.entities.Pedidos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_courier")
@Getter
@Setter
@NoArgsConstructor
public class CourierEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courierid;
	private String name;
	private String email;
	private Boolean online;
	private Long timeOnline;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidos_id")
	private List<PedidosEntity> pedidos;

}
