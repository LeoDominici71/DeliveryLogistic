package com.fiap.DeliverLogistic.utilstest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fiap.DeliverLogistic.adapters.output.h2dataBase.entities.PedidosEntity;
import com.fiap.DeliverLogistic.utils.ApplicationUtils;

@SpringBootTest
public class ApplicationUtilsTest {
	
	@Test
	public void toPedidoTest() {
		PedidosEntity pedido = new PedidosEntity();
		pedido.setCity("Praia");
		pedido.setStatus("praia");
		pedido.setComplement("25");
		pedido.setDistrict("guilhermina");
		pedido.setLocalization("aqui");
		pedido.setExpectedTimeToDeliver("deliver");
		pedido.setId(1L);
		pedido.setQuantity(1);
		pedido.setStreet("itarare");
		pedido.setUserName("Leo");
		pedido.setZipCode("112121");
		
		
		
		assertNotNull(ApplicationUtils.toPedidos(pedido));

	}

}
