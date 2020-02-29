package com.budget.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.budget.home.iface.service.CompanyInterface;
import com.budget.home.model.Company;
import com.budget.home.service.CompanyService;

@RestController
@RequestMapping("v1")
public class CompanyController {

	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Company> getAllCompan(){
		return null;
	}
	
}
