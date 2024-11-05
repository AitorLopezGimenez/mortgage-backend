package com.mortgage.domain.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mortgage.domain.core.MortgageRateService;
import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.domain.ports.MortgageRatePort;

@Service
public class MortgageRateServiceImpl implements MortgageRateService {

	@Autowired
	private MortgageRatePort mortgageRatePort;

	@Override
	public List<MortgageRate> getInterestRates() {
		return this.mortgageRatePort.findAll();
	}

	@Override
	public MortgageRate getInterestRateByMaturityPeriod(Integer maturityPeriod) {
		return this.mortgageRatePort.getInterestRateByMaturityPeriod(maturityPeriod);
	}

}
