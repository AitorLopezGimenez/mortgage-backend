package com.mortgage.domain.core.impl.config;

import java.math.BigDecimal;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mortgage.domain.core.model.Mortgage;

@TestConfiguration
public class MortgageServiceTestConfig {

	@Bean
	public Mortgage mortgageLoanValueGreaterThanHomeValue() {
		var mortgage = new Mortgage();
		mortgage.setHomeValue(BigDecimal.valueOf(0));
		mortgage.setLoanValue(BigDecimal.valueOf(10));
		return mortgage;
	}

	@Bean
	public Mortgage mortgageLoanValueGreaterThanIncomePerParameter() {
		var mortgage = new Mortgage();
		mortgage.setIncome(BigDecimal.valueOf(10));
		mortgage.setHomeValue(BigDecimal.valueOf(20000));
		mortgage.setLoanValue(BigDecimal.valueOf(1000));
		return mortgage;
	}

	@Bean
	public Mortgage mortgage() {
		var mortgage = new Mortgage();
		mortgage.setLoanValue(BigDecimal.valueOf(600000));
		mortgage.setHomeValue(BigDecimal.valueOf(800000));
		mortgage.setIncome(BigDecimal.valueOf(240000));
		mortgage.setMaturityPeriod(30);
		return mortgage;
	}

}
