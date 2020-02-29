package com.quince.java.accessingdatamysql;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.quince.java.entity.Movie;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long>{
	
	List<Movie> findAllByMovieName(String movieName, Pageable pageable);

}
