package com.quince.java.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.ui.Model;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.quince.java.accessingdatamysql.MovieRepository;
import com.quince.java.entity.Movie;
import com.quince.java.service.MovieService;

@RestController
//@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	MovieService service;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String movieName) {

		Movie m = new Movie();
		m.setMovieName(movieName);
		movieRepository.save(m);
		return "Saved";
	}

//	@GetMapping(path = "/all")
//	public @ResponseBody Iterable<Movie> getAllUsers() {
//		// This returns a JSON or XML with the users
//		
//		return movieRepository.findAll();
//	}

	@GetMapping(path = "/all")
	public Page<Movie> showUsers(
			@PageableDefault(size = 2, page = 0, sort = { "movieName" }, direction = Direction.ASC) Pageable pageable) {
		// pageable = PageRequest.of(0, 2, Sort.by("name").descending());
	
		return service.getAll(pageable);
	}
//	  @RequestMapping(value = "/movies", method = RequestMethod.GET) 
//	  HttpEntity<PagedResources<Movie>> persons(Pageable pageable, 
//	    PagedResourcesAssembler assembler) { 
//
//	    Page<Movie> persons = service.getAll(pageable); 
//	    return new ResponseEntity<>(assembler.toResources(persons), HttpStatus.OK);
//	  }
	
}
