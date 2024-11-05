package com.mortgage.domain.ports;

import java.util.List;

import com.mortgage.domain.core.model.MortgageRate;

public interface MortgageRatePort {

	List<MortgageRate> findAll();

	MortgageRate getInterestRateByMaturityPeriod(Integer maturityPeriod);
}
