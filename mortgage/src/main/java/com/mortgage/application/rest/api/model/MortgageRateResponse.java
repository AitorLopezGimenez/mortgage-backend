package com.mortgage.application.rest.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MortgageRateResponse implements Serializable {

	private static final long serialVersionUID = 2087223009533388662L;

	private Integer maturityPeriod;

	private BigDecimal interestRate;

	private Timestamp lastUpdate;

	private Long id;

}
