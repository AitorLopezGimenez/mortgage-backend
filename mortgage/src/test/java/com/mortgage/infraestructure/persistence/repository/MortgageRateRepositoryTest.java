package com.mortgage.infraestructure.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@Sql("classpath:data.sql")
@AutoConfigureTestDatabase
public class MortgageRateRepositoryTest {

	@Autowired
	private MortgageRateRepository mortgageRateRespository;

	@Test
	void testFindByMaturityPeriod() {
		Assertions.assertThat(this.mortgageRateRespository.findByMaturityPeriod(30)).isNotNull();
	}

	@Test
	void testFindByMaturityPeriodEmpty() {
		Assertions.assertThat(this.mortgageRateRespository.findByMaturityPeriod(100)).isNull();
	}
}
