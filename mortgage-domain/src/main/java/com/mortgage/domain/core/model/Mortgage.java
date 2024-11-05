package com.mortgage.domain.core.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;

@Data
public class Mortgage {

	private BigDecimal income;

	private Integer maturityPeriod;

	private BigDecimal loanValue;

	private BigDecimal homeValue;

	private boolean feasible;

	private BigDecimal monthlyCosts;

	public boolean loanValueExceedHomeValue() {
		return this.loanValue.compareTo(this.homeValue) > 0;
	}

	public boolean loanValueExceedIncomePerTimes(int multiplierValue) {
		return this.loanValue.compareTo(this.income.multiply(BigDecimal.valueOf(multiplierValue))) > 0;

	}

	public Mortgage calculateMonthlyCosts(MortgageRate interestRate) {
		// Monthly Interest rate
		var montlhyInterestRate = interestRate.getInterestRate()
				.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
				.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

		// Total payments months
		var totalMonths = this.maturityPeriod * 12;

		// Algorithm to calculate monthly costs
		this.monthlyCosts = this.loanValue.multiply(montlhyInterestRate)
				.multiply(BigDecimal
						.valueOf(Math.pow(montlhyInterestRate.add(BigDecimal.ONE).doubleValue(), totalMonths))
						.divide(BigDecimal.valueOf(
								Math.pow(montlhyInterestRate.add(BigDecimal.ONE).doubleValue(), totalMonths) - 1), 2,
								RoundingMode.HALF_UP));
		// Round it to two decimals
		this.monthlyCosts = this.monthlyCosts.setScale(2, RoundingMode.HALF_UP);
		this.feasible = true;
		return this;
	}
}
