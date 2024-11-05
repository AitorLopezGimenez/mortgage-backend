package com.mortgage.domain.core.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.domain.core.MortgageRateService;
import com.mortgage.domain.core.MortgageService;
import com.mortgage.domain.core.model.Mortgage;
import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.domain.exceptions.BusinessException;

@Service
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	private MortgageRateService mortgageRateService;

	// Could be a property in yml configuration
	private static final int INCOME_MULTIPLE_TIMES = 4;

	@Override
	public Mortgage mortgageCheck(Mortgage mortgage) {

		// Validate loan value not exceed home value
		validateMortgageNotExceedHomeValue(mortgage);
		// validate that load value not exceed income x INCOME_MULTIPLE_TIMES
		validateMortgageNoExceedIncome(mortgage);

		// Get interest rate by maturity period
		MortgageRate interestRate = this.mortgageRateService
				.getInterestRateByMaturityPeriod(mortgage.getMaturityPeriod());
		if (interestRate == null) {
			throw new BusinessException(String.format("Maturity Period %s not found", mortgage.getMaturityPeriod()));
		}

		// Calculate the monthly costs and returns itselfs
		return mortgage.calculateMonthlyCosts(interestRate);
	}

	private void validateMortgageNoExceedIncome(Mortgage mortgage) {
		// Mortgage should not exceed 4 times the income
		if (mortgage.loanValueExceedIncomePerTimes(INCOME_MULTIPLE_TIMES)) {
			// throw exception
			var income = mortgage.getIncome().multiply(BigDecimal.valueOf(INCOME_MULTIPLE_TIMES));
			throw new BusinessException(String.format("Loan value (%s) should not exceed income (%s) value * %s (%s)",
					mortgage.getLoanValue(), mortgage.getIncome(), INCOME_MULTIPLE_TIMES, income));
		}
	}

	private void validateMortgageNotExceedHomeValue(Mortgage mortgage) {
		// Mortgage should not exceed the home value
		if (mortgage.loanValueExceedHomeValue()) {
			// Throw exception
			throw new BusinessException(String.format("Loan value (%s) should not exceed home value (%s)",
					mortgage.getLoanValue(), mortgage.getHomeValue()));
		}
	}

}
