package com.mortgage.application.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.application.rest.api.mappers.MortgageRateDtoMapper;
import com.mortgage.application.rest.api.model.MortgageRateResponse;
import com.mortgage.domain.core.MortgageRateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Mortgage Rate", description = "The mortgage rate API")
public class MortgageRateController {

	@Autowired
	private MortgageRateService mortgageRateService;

	@Autowired
	private MortgageRateDtoMapper mortgageRateMapper;

	@GetMapping("/interest-rates")
	@Operation(summary = "Interest rates", responses = {
			@ApiResponse(responseCode = "200", description = "Interest rates", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MortgageRateResponse.class)))) })
	public List<MortgageRateResponse> getInterestRates() {
		return this.mortgageRateMapper.mapInterestRates(this.mortgageRateService.getInterestRates());
	}

}
