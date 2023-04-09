package com.custauthsecpratice.code.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	
	
	@GetMapping(value="/getmessage")
	public String message()
	{
		return "gotcha and authenticated successfully";
	}
}
