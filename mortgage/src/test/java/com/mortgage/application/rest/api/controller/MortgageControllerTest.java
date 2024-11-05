package com.mortgage.application.rest.api.controller;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mortgage.application.rest.api.mappers.MortgageDtoMapper;
import com.mortgage.application.rest.api.mappers.MortgageDtoMapperImpl;
import com.mortgage.application.rest.api.model.MortgageCheckRequest;
import com.mortgage.domain.core.MortgageService;
import com.mortgage.domain.core.model.Mortgage;
import com.mortgage.domain.exceptions.BusinessException;

@WebMvcTest(MortgageController.class)
@Import({ MortgageDtoMapperImpl.class })
public class MortgageControllerTest extends BaseControllerTest {

	@MockBean
	private MortgageService mortgageService;

	@Autowired
	private MortgageDtoMapper mortgageDtoMapper;

	@Test
	void testMortgageCheck() throws JsonProcessingException, Exception {
		// Given
		var mortgage = new Mortgage();
		mortgage.setFeasible(Boolean.TRUE);
		mortgage.setMonthlyCosts(BigDecimal.valueOf(850.50f));
		var mortgageCheckRequest = getMortgageCheckRequest(5000f, 30, 190000f, 500000f);
		Mockito.when(this.mortgageService.mortgageCheck(ArgumentMatchers.any(Mortgage.class))).thenReturn(mortgage);
		// When // Then
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/api/mortgage-check").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(mortgageCheckRequest))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.feasible").value(Boolean.TRUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.monthlyCosts").value(BigDecimal.valueOf(850.50f)));

	}

	private MortgageCheckRequest getMortgageCheckRequest(Float income, Integer maturityPeriod, Float loanValue,
			Float homeValue) {
		return new MortgageCheckRequest(BigDecimal.valueOf(50000), 30, BigDecimal.valueOf(190000),
				BigDecimal.valueOf(500000));
	}

	@Test
	void testMortgageCheck_ThrowBusinessException_LoanValueGreaterThanHomeValue()
			throws JsonProcessingException, Exception {
		// Given
		Mockito.when(this.mortgageService.mortgageCheck(ArgumentMatchers.any(Mortgage.class)))
				.thenThrow(BusinessException.class);

		// When // Then
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/mortgage-check").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(getMortgageCheckRequest(5000f, 30, 600000f, 500000f)))
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isConflict());
	}

}
