package com.mortgage.application.rest.api.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class MortgageCheckResponse implements Serializable {

	private static final long serialVersionUID = -7667046437615907996L;

	private boolean feasible;

	private BigDecimal monthlyCosts;

}
