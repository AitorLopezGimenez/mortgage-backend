package com.mortgage.infraestructure.persistence.adapter.config;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.mortgage.infraestructure.persistence.entity.MortgageRateEntity;

@TestConfiguration
public class MorgateRateAdapterTestConfig {

	@Bean
	public List<MortgageRateEntity> mortgageRateEntities() {
		var mortgageRates = new ArrayList<MortgageRateEntity>();
		mortgageRates.add(createMortgageRateEntity(1L, 30, BigDecimal.valueOf(10), null));
		mortgageRates.add(createMortgageRateEntity(2L, 25, BigDecimal.valueOf(15.75f), null));
		mortgageRates.add(createMortgageRateEntity(3L, 27, BigDecimal.valueOf(6), null));
		return mortgageRates;
	}

	private MortgageRateEntity createMortgageRateEntity(Long id, Integer maturityPeriod, BigDecimal interestRate,
			Timestamp lastUpdate) {
		var mortgageRateEntity = new MortgageRateEntity();
		mortgageRateEntity.setId(id);
		mortgageRateEntity.setMaturityPeriod(maturityPeriod);
		mortgageRateEntity.setInterestRate(interestRate);
		mortgageRateEntity.setLastUpdate(lastUpdate);
		return mortgageRateEntity;
	}

}
