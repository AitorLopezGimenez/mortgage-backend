package com.mortgage.application.rest.api.mappers;

import com.mortgage.application.rest.api.model.MortgageCheckRequest;
import com.mortgage.application.rest.api.model.MortgageCheckResponse;
import com.mortgage.domain.core.model.Mortgage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-05T19:00:39+0100",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class MortgageDtoMapperImpl implements MortgageDtoMapper {

    @Override
    public Mortgage mapDtoToModel(MortgageCheckRequest mortgageCheckRequest) {
        if ( mortgageCheckRequest == null ) {
            return null;
        }

        Mortgage mortgage = new Mortgage();

        mortgage.setHomeValue( mortgageCheckRequest.getHomeValue() );
        mortgage.setIncome( mortgageCheckRequest.getIncome() );
        mortgage.setLoanValue( mortgageCheckRequest.getLoanValue() );
        mortgage.setMaturityPeriod( mortgageCheckRequest.getMaturityPeriod() );

        return mortgage;
    }

    @Override
    public MortgageCheckResponse mapModelToDto(Mortgage mortgage) {
        if ( mortgage == null ) {
            return null;
        }

        MortgageCheckResponse mortgageCheckResponse = new MortgageCheckResponse();

        mortgageCheckResponse.setFeasible( mortgage.isFeasible() );
        mortgageCheckResponse.setMonthlyCosts( mortgage.getMonthlyCosts() );

        return mortgageCheckResponse;
    }
}
