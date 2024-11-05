package com.mortgage.application.rest.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MortgageCheckRequest implements Serializable {

	private static final long serialVersionUID = -2704166316653935398L;

	@NotNull
	private BigDecimal income;

	@NotNull
	private Integer maturityPeriod;

	@NotNull
	private BigDecimal loanValue;

	@NotNull
	private BigDecimal homeValue;

}
