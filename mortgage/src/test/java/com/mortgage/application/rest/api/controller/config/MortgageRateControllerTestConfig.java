package com.mortgage.application.rest.api.controller.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mortgage.domain.core.model.MortgageRate;

@TestConfiguration
public class MortgageRateControllerTestConfig {

	@Bean
	public List<MortgageRate> mortgageRates() {
		List<MortgageRate> mortgageRates = new ArrayList<>();
		mortgageRates.add(new MortgageRate(1L, 30, BigDecimal.valueOf(2.5f), null));
		mortgageRates.add(new MortgageRate(2L, 20, BigDecimal.valueOf(3f), null));
		mortgageRates.add(new MortgageRate(3L, 25, BigDecimal.valueOf(4f), null));
		mortgageRates.add(new MortgageRate(4L, 26, BigDecimal.valueOf(5.15f), null));
		return mortgageRates;
	}

}
