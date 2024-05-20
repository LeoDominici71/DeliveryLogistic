package com.fiap.DeliverLogistic.core;

import java.util.List;
import java.util.Map;

import com.fiap.DeliverLogistic.core.entities.Pedidos;

public interface UpdateOrders {
	
	
	void updateOrderStatus(List<Map<Integer, List<Pedidos>>> listOrders);

}
