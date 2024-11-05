package com.mortgage.infraestructure.persistence.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.domain.ports.MortgageRatePort;
import com.mortgage.infraestructure.persistence.mapper.MortgageRateMapper;
import com.mortgage.infraestructure.persistence.repository.MortgageRateRepository;

@Component
public class MortgageRateAdapter implements MortgageRatePort {

	@Autowired
	private MortgageRateMapper mortgageRateMapper;

	@Autowired
	private MortgageRateRepository mortgageRateRepository;

	@Override
	public List<MortgageRate> findAll() {
		return this.mortgageRateMapper.mapFromPersistence(this.mortgageRateRepository.findAll());
	}

	@Override
	public MortgageRate getInterestRateByMaturityPeriod(Integer maturityPeriod) {
		return this.mortgageRateMapper
				.mapFromPersistence(this.mortgageRateRepository.findByMaturityPeriod(maturityPeriod));
	}

}
