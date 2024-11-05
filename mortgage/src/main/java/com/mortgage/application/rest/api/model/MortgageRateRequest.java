package com.mortgage.application.rest.api.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MortgageRateRequest implements Serializable {

	private static final long serialVersionUID = 2627157664564399718L;

	private Integer maturityPeriod;

	@NotNull
	private Float interestRate;

	private Timestamp lastUpdate;

	private Long id;

}
