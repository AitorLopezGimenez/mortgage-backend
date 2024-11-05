package com.mortgage.infraestructure.persistence.mapper;

import com.mortgage.domain.core.model.MortgageRate;
import com.mortgage.infraestructure.persistence.entity.MortgageRateEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T19:11:00+0100",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class MortgageRateMapperImpl implements MortgageRateMapper {

    @Override
    public List<MortgageRate> mapFromPersistence(List<MortgageRateEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MortgageRate> list = new ArrayList<MortgageRate>( entities.size() );
        for ( MortgageRateEntity mortgageRateEntity : entities ) {
            list.add( mapFromPersistence( mortgageRateEntity ) );
        }

        return list;
    }

    @Override
    public MortgageRate mapFromPersistence(MortgageRateEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MortgageRate mortgageRate = new MortgageRate();

        mortgageRate.setId( entity.getId() );
        mortgageRate.setInterestRate( entity.getInterestRate() );
        mortgageRate.setLastUpdate( entity.getLastUpdate() );
        if ( entity.getMaturityPeriod() != null ) {
            mortgageRate.setMaturityPeriod( entity.getMaturityPeriod() );
        }

        return mortgageRate;
    }
}
