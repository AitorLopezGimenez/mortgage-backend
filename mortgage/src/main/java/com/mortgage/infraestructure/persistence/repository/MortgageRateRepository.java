package com.mortgage.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mortgage.infraestructure.persistence.entity.MortgageRateEntity;

@Repository
public interface MortgageRateRepository extends JpaRepository<MortgageRateEntity, Long> {

	@Query
	MortgageRateEntity findByMaturityPeriod(@Param("maturityPeriod") Integer maturityPeriod);

}
