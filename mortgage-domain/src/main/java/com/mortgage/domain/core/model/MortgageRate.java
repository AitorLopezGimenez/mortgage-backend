package com.mortgage.domain.core.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//tried to be a record but couldn't make mapstruct works with it
public class MortgageRate {

	Long id;
	int maturityPeriod;
	BigDecimal interestRate;
	Timestamp lastUpdate;
}
