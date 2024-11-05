package com.mortgage.application.rest.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mortgage.application.rest.api.mappers.MortgageDtoMapper;
import com.mortgage.application.rest.api.model.MortgageCheckRequest;
import com.mortgage.application.rest.api.model.MortgageCheckResponse;
import com.mortgage.domain.core.MortgageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Mortgage", description = "The mortgage API")

public class MortgageController {

	private MortgageService mortgageService;

	private MortgageDtoMapper mortgageDtoMapper;

	public MortgageController(MortgageService mortgageService, MortgageDtoMapper mortgageDtoMapper) {
		this.mortgageService = mortgageService;
		this.mortgageDtoMapper = mortgageDtoMapper;
	}

	@PostMapping("/mortgage-check")
	@Operation(summary = "Mortgage Check", responses = {
			@ApiResponse(responseCode = "200", description = "Checks if the mortgage is feasible and calculates the monthly costs", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MortgageCheckRequest.class))),
			@ApiResponse(responseCode = "409", description = "Business error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
	public MortgageCheckResponse mortgageCheck(@RequestBody MortgageCheckRequest request) {
		return this.mortgageDtoMapper
				.mapModelToDto(this.mortgageService.mortgageCheck(this.mortgageDtoMapper.mapDtoToModel(request)));
	}
}
