package com.mortgage.domain.core.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MortgageTest {

	@Test
	void testLoanValueExceedHomeValue() {
		// Given
		var mortgage = new Mortgage();
		mortgage.setLoanValue(BigDecimal.valueOf(600000));
		mortgage.setHomeValue(BigDecimal.valueOf(0));
		// When //Then
		Assertions.assertThat(mortgage.loanValueExceedHomeValue()).isTrue();

		// Given
		mortgage.setHomeValue(BigDecimal.valueOf(800000));
		// When //Then
		Assertions.assertThat(mortgage.loanValueExceedHomeValue()).isFalse();

	}

	@Test
	void testLoanValueExceedIncomePerTimes() {
		// Given
		var mortgage = new Mortgage();
		mortgage.setLoanValue(BigDecimal.valueOf(600000));
		mortgage.setIncome(BigDecimal.valueOf(0));

		// When //Then
		Assertions.assertThat(mortgage.loanValueExceedIncomePerTimes(4)).isTrue();

		// Given
		mortgage.setIncome(BigDecimal.valueOf(300000));
		// When //Then
		Assertions.assertThat(mortgage.loanValueExceedIncomePerTimes(4)).isFalse();
	}

	@Test
	void testCalculateMonthlyCosts() {

		// Given
		var mortgage = new Mortgage();
		mortgage.setLoanValue(BigDecimal.valueOf(600000));
		mortgage.setHomeValue(BigDecimal.valueOf(800000));
		mortgage.setIncome(BigDecimal.valueOf(240000));
		mortgage.setMaturityPeriod(30);

		var mortgageRate = new MortgageRate(1L, 30, BigDecimal.valueOf(2.67f), null);

		// When
		mortgage = mortgage.calculateMonthlyCosts(mortgageRate);

		// Then
		Assertions.assertThat(mortgage.isFeasible()).isTrue();
		Assertions.assertThat(mortgage.getMonthlyCosts())
				.isEqualTo(BigDecimal.valueOf(2429.70f).setScale(2, RoundingMode.UP));
	}
}
