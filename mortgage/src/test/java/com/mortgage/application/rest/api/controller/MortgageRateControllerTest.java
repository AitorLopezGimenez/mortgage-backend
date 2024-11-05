package com.mortgage.application.rest.api.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mortgage.application.rest.api.controller.config.MortgageRateControllerTestConfig;
import com.mortgage.application.rest.api.mappers.MortgageRateDtoMapper;
import com.mortgage.application.rest.api.mappers.MortgageRateDtoMapperImpl;
import com.mortgage.domain.core.MortgageRateService;
import com.mortgage.domain.core.model.MortgageRate;

@WebMvcTest(MortgageRateController.class)
@Import({ MortgageRateControllerTestConfig.class, MortgageRateDtoMapperImpl.class })
public class MortgageRateControllerTest extends BaseControllerTest {

	@MockBean
	private MortgageRateService mortgageRateService;

	@Autowired
	private List<MortgageRate> mortgageRates;

	@Autowired
	private MortgageRateDtoMapper mortgageRateDtoMapper;

	@Test
	void testGetInterestRates() throws Exception {

		// Given
		Mockito.when(this.mortgageRateService.getInterestRates()).thenReturn(this.mortgageRates);

		// When
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/interest-rates"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

		// Then
		ObjectMapper objectMapper = new ObjectMapper();
		List<MortgageRate> participantJsonList = objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
				new TypeReference<List<MortgageRate>>() {
				});

		Assertions.assertThat(participantJsonList).isNotNull();
		Assertions.assertThat(participantJsonList.size()).isEqualTo(4);

	}
}
