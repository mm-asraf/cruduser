package com.indusnet.cruduserdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.indusnet.cruduserdetails.service.IPersonalDetailsService;

@RestController
@RequestMapping("/api/v0")
public class PersonController {
	
	@Autowired
	IPersonalDetailsService iPersonalDetailService;
	
	@Autowired
	Gson gson;
	
	
	
}
