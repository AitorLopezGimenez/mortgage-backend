package com.mortgage.infraestructure.persistence.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MORTGAGES_INTEREST_RATES")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class MortgageRateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "MATURITY_PERIOD")
	private Integer maturityPeriod;

	@Column(name = "INTEREST_RATE")
	private BigDecimal interestRate;

	@Column(name = "LAST_UPDATE")
	@LastModifiedDate
	private Timestamp lastUpdate;
}
