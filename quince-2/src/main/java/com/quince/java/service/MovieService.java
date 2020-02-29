package com.quince.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.stereotype.Service;

import com.quince.java.accessingdatamysql.MovieRepository;
import com.quince.java.entity.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired 
	private EntityLinks links;
	
	public MovieService(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	public Page<Movie>  getAll(@PageableDefault Pageable pageable){
		
		Page<Movie> pagedResult = movieRepository.findAll(pageable);

		return pagedResult;
		
	}
	
	
//	 private String createLinkHeader(PagedResources < Movie > pr) {
//		  final StringBuilder linkHeader = new StringBuilder();
//		  linkHeader.append(buildLinkHeader(pr.getLinks("first").get(0).getHref(), "first"));
//		  linkHeader.append(", ");
//		  linkHeader.append(buildLinkHeader(pr.getLinks("next").get(0).getHref(), "next"));
//		  return linkHeader.toString();
//		 }

//		 public static String buildLinkHeader(final String uri, final String rel) {
//		  return "<" + uri + ">; rel=\"" + rel + "\"";
//		 }
	
}
