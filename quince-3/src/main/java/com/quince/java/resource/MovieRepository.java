package com.quince.java.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.quince.java.entity.MovieEntity;
import com.quince.java.inter.MovieInterface;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<MovieEntity, Long> {

	@RestResource(path = "t", rel = "t")
	List<MovieEntity> findAllByTitle(String title);
	
//	@RestResource(path = "titles", rel = "titles")
//	List<MovieEntity> findByTitleStartingWith(String title);
	
	@RestResource(path = "description", rel = "description")
	List<MovieEntity> findByDescriptionStartingWith(String description);
	
	@RestResource(path = "otitles", rel = "otitles")
	Iterable<MovieEntity> findByTitleStartingWith(String title);
}
