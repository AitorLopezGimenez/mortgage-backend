package com.mortgage.application.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public abstract class BaseControllerTest {

	@Autowired
	protected MockMvc mockMvc;
}
