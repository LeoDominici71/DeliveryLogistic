package com.fiap.DeliverLogistic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.DeliverLogistic.adapters.input.entities.Courier;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierStatusRequest;
import com.fiap.DeliverLogistic.adapters.input.entities.CourierUpdate;
import com.fiap.DeliverLogistic.adapters.output.h2dataBase.repository.CourierJpaRepository;
import com.fiap.DeliverLogistic.factory.Factory;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerIT {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private CourierJpaRepository repository;
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveRegistrarUmCourier() throws Exception {
		// Arrange
		Courier request = Factory.createCourier();
		String jsonBody = objectMapper.writeValueAsString(request);

		// Act
		ResultActions response = mockMvc
				.perform(post("/api/courier").content(jsonBody).contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isCreated());
		response.andExpect(jsonPath("$.name").exists());
		response.andExpect(jsonPath("$.email").exists());


	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveBuscarCourierPorId() throws Exception {

		//Arrange
		repository.save(Factory.createCourierEntity());
		
		// Act
		ResultActions result = mockMvc.perform(get("/api/courier/{id}", 1L).accept(MediaType.APPLICATION_JSON));

		// Assert
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.name").exists());
		

	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void naoDeveBuscarCourierPorId() throws Exception {

		//Arrange
		repository.save(Factory.createCourierEntity());
		
		// Act
		ResultActions result = mockMvc.perform(get("/api/courier/{id}", 3L).accept(MediaType.APPLICATION_JSON));

		// Assert
		result.andExpect(status().isNotFound());

		

	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveDeletarReservaPorId() throws Exception {
		// Arrange
		repository.save(Factory.createCourierEntity());

		// Act
		ResultActions result = mockMvc
				.perform(delete("/api/courier/delete/{id}", 1L).accept(MediaType.APPLICATION_JSON));
		// Assert
		result.andExpect(status().isNoContent());
	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveBuscarListaDeCourierPorTempoAsc() throws Exception {
		// Arrange
		repository.save(Factory.createCourierEntity());


		// Act
		ResultActions response = mockMvc.perform(get("/api/courier/listCourierByTimeOnline").contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isOk());


	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveBuscarListaDeCourier() throws Exception {
		// Arrange
		repository.save(Factory.createCourierEntity());


		// Act
		ResultActions response = mockMvc.perform(get("/api/courier").contentType(MediaType.APPLICATION_JSON));

		// Assert
		response.andExpect(status().isOk());


	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveAtualizarCourierPorId() throws Exception {
		// Arrange
		repository.save(Factory.createCourierEntity());
		CourierUpdate request = Factory.createCourierUpdate();
		String jsonBody = objectMapper.writeValueAsString(request);
		// Act
		ResultActions result = mockMvc.perform(put("/api/courier/updateCourier/{id}", 1L).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		// Assert
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.name").exists());

	}
	
	@Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
	public void deveAtualizarCourierStatus() throws Exception {
		// Arrange
		repository.save(Factory.createCourierEntity());
		CourierStatusRequest request = Factory.createStatusUpdate();
		String jsonBody = objectMapper.writeValueAsString(request);
		// Act
		ResultActions result = mockMvc.perform(put("/api/courier/updateStatus/{id}", 1L).content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
		// Assert
		result.andExpect(status().isOk());

	}
	
	

}
