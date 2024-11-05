package com.mortgage.domain.core;

import java.util.List;

import com.mortgage.domain.core.model.MortgageRate;

public interface MortgageRateService {

	List<MortgageRate> getInterestRates();

	MortgageRate getInterestRateByMaturityPeriod(Integer maturityPeriod);
}
