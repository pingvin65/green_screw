package com.quince.java.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.quince.java.entity.AlbumEntity;

public interface AlbumRepository extends PagingAndSortingRepository<AlbumEntity, Long>{

}
