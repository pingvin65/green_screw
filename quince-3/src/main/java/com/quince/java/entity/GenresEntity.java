package com.quince.java.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="genre")
@RestResource(exported=false)
public class GenresEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="genre_id")
    private Long genreId;
	
    @Column(name="genre_name")
    private String genreName;

    @JsonIgnore
	@OneToMany(mappedBy = "genresEntity", cascade = CascadeType.ALL)
	private Set<MovieEntity> movieEntity;
    
    
	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<MovieEntity> getMovieEntity() {
		return movieEntity;
	}

	public void setMovieEntity(Set<MovieEntity> movieEntity) {
		this.movieEntity = movieEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
		result = prime * result + ((movieEntity == null) ? 0 : movieEntity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenresEntity other = (GenresEntity) obj;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		if (movieEntity == null) {
			if (other.movieEntity != null)
				return false;
		} else if (!movieEntity.equals(other.movieEntity))
			return false;
		return true;
	}
	
    
}
