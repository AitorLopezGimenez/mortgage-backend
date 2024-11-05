package com.mortgage.infraestructure.persistence.adapter;

import static org.mockito.Mockito.times;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.mortgage.domain.ports.MortgageRatePort;
import com.mortgage.infraestructure.persistence.adapter.config.MorgateRateAdapterTestConfig;
import com.mortgage.infraestructure.persistence.entity.MortgageRateEntity;
import com.mortgage.infraestructure.persistence.mapper.MortgageRateMapper;
import com.mortgage.infraestructure.persistence.mapper.MortgageRateMapperImpl;
import com.mortgage.infraestructure.persistence.repository.MortgageRateRepository;

@SpringJUnitConfig
@Import({ MortgageRateAdapter.class, MortgageRateMapperImpl.class, MorgateRateAdapterTestConfig.class })
public class MorgateRateAdapterTest {

	@Autowired
	private MortgageRatePort mortgageRatePort;

	@Autowired
	private MortgageRateMapper mortgageRateMapper;

	@Autowired
	public List<MortgageRateEntity> mortgageRateEntities;

	@MockBean
	private MortgageRateRepository mortgageRateRepository;

	@Test
	void testFindAll() {
		// Given
		Mockito.when(this.mortgageRateRepository.findAll()).thenReturn(this.mortgageRateEntities);
		// When
		var mortgageRatesEntites = this.mortgageRatePort.findAll();
		// Then
		Assertions.assertThat(mortgageRatesEntites).isNotNull();
		Assertions.assertThat(mortgageRatesEntites.size()).isEqualTo(3);
		Mockito.verify(this.mortgageRateRepository, times(1)).findAll();
		Mockito.verifyNoMoreInteractions(this.mortgageRateRepository);

	}

	@Test
	void testGetInterestRateByMaturityPeriod() {
		// Given
		Mockito.when(this.mortgageRateRepository.findByMaturityPeriod(ArgumentMatchers.anyInt()))
				.thenReturn(this.mortgageRateEntities.get(0));
		// When
		var mortgageRate = this.mortgageRatePort.getInterestRateByMaturityPeriod(30);
		// Then
		Assertions.assertThat(mortgageRate).isNotNull();
		Assertions.assertThat(mortgageRate.getMaturityPeriod()).isEqualTo(30);
		Mockito.verify(this.mortgageRateRepository, times(1)).findByMaturityPeriod(ArgumentMatchers.anyInt());
		Mockito.verifyNoMoreInteractions(this.mortgageRateRepository);

	}

}
