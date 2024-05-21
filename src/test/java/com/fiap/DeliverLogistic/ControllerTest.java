package com.fiap.DeliverLogistic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.DeliverLogistic.core.usecase.DeliverProcessment;
import com.fiap.DeliverLogistic.core.usecase.DeliverUpdate;
import com.fiap.DeliverLogistic.factory.Factory;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private DeliverUpdate deliverUpdate;

	@MockBean
	private DeliverProcessment processment;

	@Test
	@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveAtualizarCourierPorId() throws Exception {

		// Act
		Assertions.assertDoesNotThrow(() -> {
			deliverUpdate.updateDeliver(1L);
		});

		// Act
		ResultActions result = mockMvc.perform(put("/api/courier/updateDeliver/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		// Assert
		result.andExpect(status().isNoContent());

	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void updateDeliver() throws Exception {
		// Act
				Assertions.assertDoesNotThrow(() -> {
					processment.deliverProcessment();					
				});


		// Act
		ResultActions response = mockMvc.perform(get("/api/courier/deliverProcessment").contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isNoContent());


	}

}
