package com.mortgage.application.rest.api.mappers;

import com.mortgage.application.rest.api.model.MortgageRateResponse;
import com.mortgage.domain.core.model.MortgageRate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T19:00:39+0100",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class MortgageRateDtoMapperImpl implements MortgageRateDtoMapper {

    @Override
    public List<MortgageRateResponse> mapInterestRates(List<MortgageRate> mortgageRates) {
        if ( mortgageRates == null ) {
            return null;
        }

        List<MortgageRateResponse> list = new ArrayList<MortgageRateResponse>( mortgageRates.size() );
        for ( MortgageRate mortgageRate : mortgageRates ) {
            list.add( mapInterestRate( mortgageRate ) );
        }

        return list;
    }

    @Override
    public MortgageRateResponse mapInterestRate(MortgageRate mortgageRate) {
        if ( mortgageRate == null ) {
            return null;
        }

        MortgageRateResponse mortgageRateResponse = new MortgageRateResponse();

        mortgageRateResponse.setId( mortgageRate.getId() );
        mortgageRateResponse.setInterestRate( mortgageRate.getInterestRate() );
        mortgageRateResponse.setLastUpdate( mortgageRate.getLastUpdate() );
        mortgageRateResponse.setMaturityPeriod( mortgageRate.getMaturityPeriod() );

        return mortgageRateResponse;
    }
}
