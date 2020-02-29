package com.quince.java.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quince.java.assembers.ActorModelAssembler;
import com.quince.java.assembers.AlbumModelAssembler;
import com.quince.java.entity.ActorEntity;
import com.quince.java.entity.AlbumEntity;
import com.quince.java.model.ActorModel;
import com.quince.java.model.AlbumModel;
import com.quince.java.repository.ActorRepository;
import com.quince.java.repository.AlbumRepository;

@RestController
public class WebController {

	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private ActorModelAssembler actorModelAssembler;
	
	@Autowired
	private AlbumModelAssembler albumModelAssembler;
	
	@Autowired
	private PagedResourcesAssembler<AlbumEntity> pagedResourcesAssembler;
	
	@GetMapping("/api/actors")
	public ResponseEntity<CollectionModel<ActorModel>> getAllActors() 
	{
		List<ActorEntity> actorEntities = (List<ActorEntity>) actorRepository.findAll();
		
		return new ResponseEntity<>(
				actorModelAssembler.toCollectionModel(actorEntities), 
				HttpStatus.OK);
	}
	
	@GetMapping("/api/actors/{id}")
	public ResponseEntity<ActorModel> getActorById(@PathVariable("id") Long id) 
	{
		return actorRepository.findById(id) 
				.map(actorModelAssembler::toModel) 
				.map(ResponseEntity::ok) 
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/api/albums")
	public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums() 
	{
		List<AlbumEntity> albumEntities = (List<AlbumEntity>) albumRepository.findAll();
		
		return new ResponseEntity<>(
				albumModelAssembler.toCollectionModel(albumEntities), 
				HttpStatus.OK);
	}
		
	@GetMapping("/api/albums/{id}")
	public ResponseEntity<AlbumModel> getAlbumById(@PathVariable("id") Long id) {
		return albumRepository.findById(id).map(albumModelAssembler::toModel).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//		return albumRepository.findById(id) 
//				.map(albumModelAssembler::toModel) 
//				.map(ResponseEntity::ok) 
//				.orElse(ResponseEntity.notFound().build());
	}
	
	//Pageable
	
	@GetMapping("/api/albums-list")
	public ResponseEntity<PagedModel<AlbumModel>> getAllAlbums(Pageable pageable) 
	{
		Page<AlbumEntity> albumEntities = albumRepository.findAll(pageable);
		
		PagedModel<AlbumModel> collModel = pagedResourcesAssembler
							.toModel(albumEntities, albumModelAssembler);
		
		return new ResponseEntity<>(collModel,HttpStatus.OK);
	}
}
