package com.quince.java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.quince.java.entity.MovieEntity;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<MovieEntity, Long>{
	
//	@RestResource(path = "id", rel = "id")
//	Optional<MovieEntity> findById(@Param("id") Long id);
//	List<MovieEntity> findAllByMovieName(String movieName, Pageable pageable);
	@RestResource(path = "titles", rel = "titles")
	List<MovieEntity> findByTitleStartingWith(@Param("title") String title);
//	Optional<MovieEntity> findByMovieName(String movieName);
	
//	@RestResource(path = "descriptions", rel = "descriptions")
//	List<MovieEntity> findByDescriptionContaining(@Param("des") String description);

}