package com.pink.screw.java.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pink.screw.java.entities.Person;

public class Resources2 extends RepresentationModel<Resources2> {
	private final List<Person> producers;
	private final Page<Person> producers2;

	@JsonCreator
	public Resources2(@JsonProperty("producers") List<Person> producers) {

		this.producers2 = null;
		this.producers = producers;
	}



	public Resources2(@JsonProperty("producers") Page<Person> producers2) {
		this.producers2 = producers2;
		this.producers = null;
		// TODO Auto-generated constructor stub
	}



	public List<Person> getContent() {
		return producers;
	}



	public Page<Person> getProducers2() {
		return producers2;
	}

}
