package com.pink.screw.java.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pink.screw.java.entities.Product;
import com.pink.screw.java.repository.ProductRepository;

@Controller
@Validated 
@RequestMapping(path = "/api/v1")
public class MainController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addNewProduct(@RequestParam String productCode, @RequestParam String name,
			@RequestParam Integer quantity, @RequestParam Float price) {


		String message = "Saved\n";

		Product product = new Product(productCode, name, quantity, price);

//		System.out.println(product);
		productRepository.save(product);

		return message;
	}
	

	
	@PostMapping("/add2")
	ResponseEntity<String> addProduct(@Valid @RequestBody Product newProduct){

		try {
			productRepository.save(newProduct);	
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");	
		}
			
							
		return ResponseEntity.ok("Saved");		
	}



	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Product> getAllUsers() {
		// This returns a JSON or XML with the users
		return productRepository.findAll();
	}

}
