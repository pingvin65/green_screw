package com.quince.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quince.java.entity.User;
import com.quince.java.repository.UserRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/add") 
	  public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    User n = new User();
	    n.setName(name);
	    n.setEmail(email);
	    userRepository.save(n);
	    return "Saved";
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
//		  System.out.println(userRepository.findAll());
		 long num =  userRepository.count();
		 System.out.println(num);
	    return userRepository.findAll();
	  }

}
