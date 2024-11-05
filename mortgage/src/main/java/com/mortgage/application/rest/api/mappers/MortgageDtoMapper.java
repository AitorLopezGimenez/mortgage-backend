package com.mortgage.application.rest.api.mappers;

import org.mapstruct.Mapper;

import com.mortgage.application.rest.api.model.MortgageCheckRequest;
import com.mortgage.application.rest.api.model.MortgageCheckResponse;
import com.mortgage.domain.core.model.Mortgage;

@Mapper(componentModel = "spring")
public interface MortgageDtoMapper {

	Mortgage mapDtoToModel(MortgageCheckRequest mortgageCheckRequest);

	MortgageCheckResponse mapModelToDto(Mortgage mortgage);
}
