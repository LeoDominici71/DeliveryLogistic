package com.fiap.DeliverLogistic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.DeliverLogistic.adapter.output.externalApi.UpdateOrdersById;
import com.fiap.DeliverLogistic.core.CourierRepository;
import com.fiap.DeliverLogistic.core.GetOrdersList;
import com.fiap.DeliverLogistic.core.UpdateOrders;
import com.fiap.DeliverLogistic.core.usecase.DeleteCourier;
import com.fiap.DeliverLogistic.core.usecase.DeliverProcessment;
import com.fiap.DeliverLogistic.core.usecase.DeliverUpdate;
import com.fiap.DeliverLogistic.core.usecase.DesignateDeliver;
import com.fiap.DeliverLogistic.core.usecase.GetAllCouriersByTimeOnline;
import com.fiap.DeliverLogistic.core.usecase.GetCourierById;
import com.fiap.DeliverLogistic.core.usecase.ListAllCourier;
import com.fiap.DeliverLogistic.core.usecase.RegisterCourier;
import com.fiap.DeliverLogistic.core.usecase.UpdateCourier;
import com.fiap.DeliverLogistic.core.usecase.UpdateStatus;

@Configuration
public class BeansConfig {

	@Bean
	public DeleteCourier deleteCourier(CourierRepository courierRepository) {
		return new DeleteCourier(courierRepository);
	}

	@Bean
	public DeliverProcessment deliverProcessment(GetOrdersList getOrders, UpdateOrders updateOrders,
			DesignateDeliver designate, GetAllCouriersByTimeOnline getCouriers) {
		return new DeliverProcessment(getOrders, updateOrders, designate, getCouriers);
	}

	@Bean
	public DeliverUpdate deliverUpdate(CourierRepository courierRepository, UpdateOrdersById updateOrder) {
		return new DeliverUpdate(courierRepository, updateOrder);
	}

	@Bean
	public DesignateDeliver designateDeliver(CourierRepository courierRepository) {
		return new DesignateDeliver(courierRepository);

	}
	
	
	@Bean
	public GetAllCouriersByTimeOnline getAllCountriesByTimeOnline(CourierRepository courierRepository) {
		return new GetAllCouriersByTimeOnline(courierRepository);

	}
	
	@Bean
	public GetCourierById getCourierById(CourierRepository courierRepository) {
		return new GetCourierById(courierRepository);

	}
	
	@Bean
	public ListAllCourier listAllCourier(CourierRepository courierRepository) {
		return new ListAllCourier(courierRepository);
	}
	
	@Bean
	public RegisterCourier registerCourier(CourierRepository courierRepository) {
		return new RegisterCourier(courierRepository);
	}
	
	@Bean
	public UpdateCourier updateCourier(CourierRepository courierRepository) {
		return new UpdateCourier(courierRepository);
	}
	
	@Bean
	public UpdateStatus updateStatus(CourierRepository courierRepository) {
		return new UpdateStatus(courierRepository);
	}
	

}
