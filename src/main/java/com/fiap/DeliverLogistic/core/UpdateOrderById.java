package com.fiap.DeliverLogistic.core;

import com.fiap.DeliverLogistic.core.entities.OrderRequestUpdate;

public interface UpdateOrderById {
	
	void updateOrderById(Long id, OrderRequestUpdate update);

}
