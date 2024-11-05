package com.mortgage.domain.core.impl.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mortgage.domain.core.model.MortgageRate;

@TestConfiguration
public class MortgageRateServiceTestConfig {

	@Bean
	public List<MortgageRate> getMortgageRates() {
		List<MortgageRate> mortgageRates = new ArrayList<>();
		mortgageRates.add(new MortgageRate(1L, 30, BigDecimal.valueOf(10), null));
		mortgageRates.add(new MortgageRate(2L, 25, BigDecimal.valueOf(15.75f), null));
		mortgageRates.add(new MortgageRate(3L, 27, BigDecimal.valueOf(6), null));
		return mortgageRates;
	}

}
