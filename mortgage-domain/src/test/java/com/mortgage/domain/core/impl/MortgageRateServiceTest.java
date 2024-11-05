package com.mortgage.domain.core.impl;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mortgage.domain.core.MortgageRateService;
import com.mortgage.domain.core.impl.config.MortgageRateServiceTestConfig;
import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.domain.ports.MortgageRatePort;

@SpringJUnitConfig
@Import({ MortgageRateServiceImpl.class, MortgageRateServiceTestConfig.class })
public class MortgageRateServiceTest {

	@Autowired
	private MortgageRateService mortgageRateService;

	@Autowired
	private List<MortgageRate> getMortgageRates;

	@MockBean
	private MortgageRatePort mortgageRatesPort;

	@Test
	void testGetInterestRates() {
		// Given
		Mockito.when(this.mortgageRatesPort.findAll()).thenReturn(this.getMortgageRates);
		// When
		var interestRates = this.mortgageRateService.getInterestRates();
		// Then
		Assertions.assertThat(interestRates).isNotNull();
		Assertions.assertThat(interestRates.size()).isEqualTo(3);

	}

	@Test
	void testGetInterestRateByMaturityPeriod() {
		// Given
		Mockito.when(this.mortgageRatesPort.getInterestRateByMaturityPeriod(ArgumentMatchers.anyInt()))
				.thenReturn(this.getMortgageRates.get(0));
		// When
		var interestRates = this.mortgageRateService.getInterestRateByMaturityPeriod(30);
		// Then
		Assertions.assertThat(interestRates).isNotNull();
		Assertions.assertThat(interestRates.getId()).isEqualTo(1);

	}

	@Test
	void testGetInterestRateByMaturityPeriodEmpty() {
		// Given
		Mockito.when(this.mortgageRatesPort.getInterestRateByMaturityPeriod(ArgumentMatchers.anyInt()))
				.thenReturn(null);
		// When
		var interestRates = this.mortgageRateService.getInterestRateByMaturityPeriod(50);
		// Then
		Assertions.assertThat(interestRates).isNull();

	}
}
