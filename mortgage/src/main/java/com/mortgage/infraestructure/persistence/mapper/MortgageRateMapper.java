package com.mortgage.infraestructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.infraestructure.persistence.entity.MortgageRateEntity;

@Mapper(componentModel = "spring")
public interface MortgageRateMapper {

	MortgageRateMapper INSTANCE = Mappers.getMapper(MortgageRateMapper.class);

	List<MortgageRate> mapFromPersistence(List<MortgageRateEntity> entities);

	MortgageRate mapFromPersistence(MortgageRateEntity entity);

}
