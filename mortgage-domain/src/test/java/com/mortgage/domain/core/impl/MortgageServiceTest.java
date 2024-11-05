package com.mortgage.domain.core.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mortgage.domain.core.MortgageRateService;
import com.mortgage.domain.core.MortgageService;
import com.mortgage.domain.core.impl.config.MortgageServiceTestConfig;
import com.mortgage.domain.core.model.Mortgage;
import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.domain.exceptions.BusinessException;

@SpringJUnitConfig
@Import({ MortgageServiceTestConfig.class, MortgageServiceImpl.class })
public class MortgageServiceTest {

	@MockBean
	private MortgageRateService mortgageRateService;

	@Autowired
	private MortgageService mortgageService;

	@Autowired
	private Mortgage mortgageLoanValueGreaterThanHomeValue;

	@Autowired
	private Mortgage mortgageLoanValueGreaterThanIncomePerParameter;

	@Autowired
	private Mortgage mortgage;

	@Test
	void testMortgageCheck_ThrowException_LoanValueGreaterThanHomeValue() {
		// Given //when
		BusinessException exception = Assertions.assertThrows(BusinessException.class,
				() -> this.mortgageService.mortgageCheck(this.mortgageLoanValueGreaterThanHomeValue));

		// Then
		String expectedMessage = String.format("Loan value (%s) should not exceed home value (%s)",
				this.mortgageLoanValueGreaterThanHomeValue.getLoanValue(),
				this.mortgageLoanValueGreaterThanHomeValue.getHomeValue());
		Assertions.assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testMortgageCheck_ThrowException_LoanValueGreaterThanIncomePerParameter() {
		// Given //when
		BusinessException exception = Assertions.assertThrows(BusinessException.class,
				() -> this.mortgageService.mortgageCheck(this.mortgageLoanValueGreaterThanIncomePerParameter));

		// Then
		String expectedMessage = String.format("Loan value (%s) should not exceed income (%s) value * %s (%s)",
				this.mortgageLoanValueGreaterThanIncomePerParameter.getLoanValue(),
				this.mortgageLoanValueGreaterThanIncomePerParameter.getIncome(), 4,
				this.mortgageLoanValueGreaterThanIncomePerParameter.getIncome().multiply(BigDecimal.valueOf(4)));
		Assertions.assertEquals(expectedMessage, exception.getMessage());
	}

	@Test
	void testMortgageCheck() {
		// Given
		var mortgageRate = new MortgageRate(1L, 30, BigDecimal.valueOf(2.67f), null);
		Mockito.when(this.mortgageRateService.getInterestRateByMaturityPeriod(ArgumentMatchers.anyInt()))
				.thenReturn(mortgageRate);
		// When
		var mortgageCheck = this.mortgageService.mortgageCheck(this.mortgage);

		// Then
		Assertions.assertNotNull(mortgageCheck);
		Assertions.assertTrue(mortgageCheck.isFeasible());
		Assertions.assertEquals(mortgageCheck.getMonthlyCosts(),
				BigDecimal.valueOf(2429.70f).setScale(2, RoundingMode.UP));
	}

}
