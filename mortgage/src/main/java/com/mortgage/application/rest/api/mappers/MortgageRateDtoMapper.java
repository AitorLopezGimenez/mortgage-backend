package com.mortgage.application.rest.api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mortgage.application.rest.api.model.MortgageRateResponse;
import com.mortgage.domain.core.model.MortgageRate;

@Mapper(componentModel = "spring")
public interface MortgageRateDtoMapper {

	MortgageRateDtoMapper INSTANCE = Mappers.getMapper(MortgageRateDtoMapper.class);

	List<MortgageRateResponse> mapInterestRates(List<MortgageRate> mortgageRates);

	MortgageRateResponse mapInterestRate(MortgageRate mortgageRate);

}
